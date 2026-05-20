require isaac-ros-common-repo.inc

DESCRIPTION = "Interfaces for Isaac ROS tensor list"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_common"

ROS_CN = "isaac-ros-tensor-list-interfaces"
ROS_BPN = "isaac_ros_tensor_list_interfaces"

S = "${UNPACKDIR}/git/isaac_ros_common/isaac_ros_tensor_list_interfaces"

inherit cuda-available

ROS_BUILD_DEPENDS = " \
    isaac-ros-common \
    std-msgs \
    rosidl-default-generators \
    rosidl-default-runtime \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
"

ROS_EXEC_DEPENDS = " \
    rosidl-default-runtime \
    std-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
