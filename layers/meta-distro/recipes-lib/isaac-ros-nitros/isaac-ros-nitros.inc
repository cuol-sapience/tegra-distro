# Shared settings for packages from NVIDIA-ISAAC-ROS/isaac_ros_nitros monorepo

SRCREV = "4fbeb113fdf98b8dea857c1044ed414b25ec9271"
SRC_URI = "git://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros.git;branch=main;protocol=https;nobranch=1;destsuffix=git/isaac_ros_nitros"

inherit ros_distro_humble
inherit cuda-available

PV = "4.4.0"
LICENSE = "CLOSED"

EXTRA_OECMAKE += "-DCMAKE_NO_SYSTEM_FROM_IMPORTED=ON"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-dbg += "buildpaths"
