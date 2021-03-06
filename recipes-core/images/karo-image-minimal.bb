SUMMARY = "A minimal Linux system without graphics support."

require karo-image.inc 
require karo-minimal.inc

IMAGE_LINGUAS = ""
IMAGE_FEATURES += "read-only-rootfs"
PACKAGE_EXCLUDE = "python3-core"

IMAGE_ROOTFS_MAXSIZE ?= "${@bb.utils.contains('MACHINE_FEATURES',"nand","65536","",d)}"

ROOTFS_POSTPROCESS_COMMAND_remove = "rootfs_update_timestamp; empty_var_volatile;"

python extend_recipe_sysroot_append() {
    bb.note("IMAGE_FEATURES[read-only-rootfs]='%s'" % bb.utils.filter('IMAGE_FEATURES','read-only-rootfs',d))
    if bb.utils.contains('IMAGE_FEATURES','read-only-rootfs',False,True,d):
        bb.error("IMAGE_FEATURES=%s" % d.getVar('IMAGE_FEATURES'))
        raise_sanity_error("IMAGE_FEATURES is missing the 'read-only-rootfs' feature", d)

    if d.getVar('DISTRO') != 'karo-minimal':
        raise_sanity_error("cannot build karo-image-minimal with '%s' DISTRO" % d.getVar('DISTRO'), d)
}
