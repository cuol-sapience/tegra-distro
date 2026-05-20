require isaac-ros-nitros.inc

DESCRIPTION = "Isaac ROS GXF framework integration"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros"

ROS_CN = "isaac-ros-gxf"
ROS_BPN = "isaac_ros_gxf"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-fix-cross-compile-arch-detection.patch;patchdir=${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_gxf"

S = "${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_gxf"

ROS_BUILD_DEPENDS = " \
    isaac-ros-common \
    magic-enum \
    ucx \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-auto-native \
"

ROS_EXEC_DEPENDS = " \
    magic-enum \
    ucx \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
