require isaac-ros-common-repo.inc

DESCRIPTION = "Utilities for performing common functions in Isaac ROS packages"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_common"

inherit cuda-available

ROS_CN = "isaac-ros-common"
ROS_BPN = "isaac_ros_common"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-make-vpi-optional.patch;patchdir=${UNPACKDIR}/git/isaac_ros_common/isaac_ros_common"

S = "${UNPACKDIR}/git/isaac_ros_common/isaac_ros_common"

ROS_BUILD_DEPENDS = " \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    python3-pyyaml-native \
"

ROS_EXEC_DEPENDS = " \
    rclcpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
