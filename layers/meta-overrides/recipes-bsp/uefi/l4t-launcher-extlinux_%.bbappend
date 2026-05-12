# Clear L4T_UBOOT_EXTLINUX_FDT so l4t-launcher-extlinux does not copy the DTB into
# /boot and does not attempt to sign it separately. The DTB lives in /boot/devicetree/
# as installed by nvidia-kernel-oot-devicetrees, and UBOOT_EXTLINUX_FDT already points
# the extlinux.conf FDT line there.
L4T_UBOOT_EXTLINUX_FDT:jetson-orin-nano-devkit = ""
