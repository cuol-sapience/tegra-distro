# (ros)-recipes-core | this requires core-image-minimal
require sapience-image-minimal.bb


SUMMARY = "Core Sapience image containing ROS"

# IMAGE_INSTALL:append = " ros-core"
EXTRA_IMAGE_FEATURES:append = " ros-implicit-workspace"

IMAGE_INSTALL:append = " packagegroup-pipewire packagegroup-gnome-desktop" 