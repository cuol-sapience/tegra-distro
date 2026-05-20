require isaac-ros-nitros.inc

DESCRIPTION = "NVIDIA Isaac Transport for ROS — zero-copy hardware-accelerated messaging"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros"

ROS_CN = "isaac-ros-nitros"
ROS_BPN = "isaac_ros_nitros"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0002-make-vpi-optional.patch;patchdir=${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_nitros"

S = "${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_nitros"

ROS_BUILD_DEPENDS = " \
    negotiated \
    rclcpp \
    rclcpp-components \
    std-msgs \
    diagnostic-msgs \
    isaac-ros-gxf \
    gxf-isaac-optimizer \
    ament-index-cpp \
    isaac-ros-common \
    libeigen \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-auto-native \
    eigen3-cmake-module-native \
"

ROS_EXEC_DEPENDS = " \
    negotiated \
    rclcpp \
    rclcpp-components \
    std-msgs \
    diagnostic-msgs \
    isaac-ros-gxf \
    gxf-isaac-optimizer \
    ament-index-cpp \
    libeigen \
    yaml-cpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
