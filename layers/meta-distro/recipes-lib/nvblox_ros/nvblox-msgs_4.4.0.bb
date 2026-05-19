require nvblox-isaac-ros.inc

DESCRIPTION = "ROS 2 messages for Nvblox types"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nvblox"

ROS_CN = "nvblox-msgs"
ROS_BPN = "nvblox_msgs"

S = "${UNPACKDIR}/git/isaac_ros_nvblox/nvblox_msgs"

ROS_BUILD_DEPENDS = " \
    isaac-ros-common \
    std-msgs \
    geometry-msgs \
    rosidl-default-generators \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXEC_DEPENDS = " \
    rosidl-default-runtime \
    std-msgs \
    geometry-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
