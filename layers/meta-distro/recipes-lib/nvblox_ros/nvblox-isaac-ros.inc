# Shared settings for packages from NVIDIA-ISAAC-ROS/isaac_ros_nvblox monorepo

SRCREV = "e3fbaea70d34ec60830f77322cda5b4b269f7b1c"
SRC_URI = "git://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nvblox.git;branch=main;protocol=https;nobranch=1;destsuffix=git/isaac_ros_nvblox"

inherit ros_distro_humble

PV = "4.4.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

EXTRA_OECMAKE += "-DCMAKE_NO_SYSTEM_FROM_IMPORTED=ON"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-dbg += "buildpaths"
