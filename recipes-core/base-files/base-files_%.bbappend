FILESEXTRAPATHS_prepend_stm32mp1 := "${THISDIR}/${PN}:"

dirs755_append_stm32mp1 = " ${STM32MP_USERFS_MOUNTPOINT_IMAGE}"
dirs755_append_stm32mp1 = " ${STM32MP_VENDORFS_MOUNTPOINT_IMAGE}"
