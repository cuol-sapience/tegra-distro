# Shared settings for packages from NVIDIA-ISAAC-ROS/isaac_ros_common monorepo

SRCREV = "d7164701715edfd4adbec87355461069bc8071d6"
SRC_URI = "git://github.com/NVIDIA-ISAAC-ROS/isaac_ros_common.git;branch=main;protocol=https;nobranch=1;destsuffix=git/isaac_ros_common"

inherit ros_distro_humble

PV = "4.4.0"
LICENSE = "CLOSED"

EXTRA_OECMAKE += "-DCMAKE_NO_SYSTEM_FROM_IMPORTED=ON"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-dbg += "buildpaths"
