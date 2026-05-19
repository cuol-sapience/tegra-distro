require nvblox-isaac-ros.inc

DESCRIPTION = "Utilities used across the isaac_ros_nvblox repo"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nvblox"

ROS_CN = "nvblox-ros-common"
ROS_BPN = "nvblox_ros_common"

S = "${UNPACKDIR}/git/isaac_ros_nvblox/nvblox_ros_common"

ROS_BUILD_DEPENDS = " \
    isaac-ros-common \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-auto-native \
"

ROS_EXEC_DEPENDS = " \
    rclcpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
