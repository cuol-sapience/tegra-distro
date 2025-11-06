# (ros)-recipes-core | this requires core-image-minimal
require recipes-core/images/ros-image-core.bb


SUMMARY = "Core Sapience image containing ROS"

# IMAGE_INSTALL:append = " ros-core"
EXTRA_IMAGE_FEATURES:append = " ros-implicit-workspace"