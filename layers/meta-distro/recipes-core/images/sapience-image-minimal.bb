# (ros)-recipes-core | this requires core-image-minimal
require recipes-core/images/ros-image-core.bb


SUMMARY = "Core Sapience image containing ROS"

IMAGE_INSTALL:append = " ros-core micro-xrce-dds-agent rtl88x2ce" 
EXTRA_IMAGE_FEATURES:append = " ros-implicit-workspace"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    useradd -p '' sapience; \
    usermod -a -G input,video sapience; \
    "