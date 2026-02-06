# (ros)-recipes-core | this requires core-image-minimal
require recipes-core/images/ros-image-core.bb


SUMMARY = "Core Sapience image containing ROS"

# Use networkmanager instead of systemd-networkd (allows us to use simpler nmcli instead of low level iw commands)
NETWORK_MANAGER = "networkmanager"


# cuda-toolkit: CUDA tools and libraries
# usbutils: lsusb command
# pciutils: lspci command

# note: MACHINE_EXTRA_RRECOMMENDS adds rtl88x2ce from nvidia
IMAGE_INSTALL:append = " ${MACHINE_EXTRA_RRECOMMENDS} ros-core micro-xrce-dds-agent sudo net-tools iproute2 os-release cuda-toolkit usbutils pciutils kernel-module-smsc95xx setup-nv-boot-control tegra-nv-boot-control-config tegra-redundant-boot-base  networkmanager-nmcli networkmanager-wifi wpa-supplicant wireless-regdb-static iw" 
EXTRA_IMAGE_FEATURES:append = " ros-implicit-workspace"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    useradd -p '' sapience; \
    usermod -a -G input,video,sudo sapience; \
    "

# sudo extra config: https://stackoverflow.com/a/42615560

update_sudoers(){
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}

ROOTFS_POSTPROCESS_COMMAND += "update_sudoers;"