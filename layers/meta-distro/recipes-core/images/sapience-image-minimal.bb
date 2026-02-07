# (ros)-recipes-core | this requires core-image-minimal
require recipes-core/images/ros-image-core.bb


SUMMARY = "Core Sapience image containing ROS"

# Use networkmanager instead of systemd-networkd (allows us to use simpler nmcli instead of low level iw commands)
NETWORK_MANAGER = "networkmanager"

# note: MACHINE_EXTRA_RRECOMMENDS adds rtl88x2ce from nvidia
IMAGE_INSTALL:append = "\
    ${MACHINE_EXTRA_RRECOMMENDS} \
    kernel-module-smsc95xx \
    networkmanager-nmcli \
    packagegroup-sapience-ros2 \
    packagegroup-sapience-utils \
"

EXTRA_IMAGE_FEATURES:append = " ros-implicit-workspace"

