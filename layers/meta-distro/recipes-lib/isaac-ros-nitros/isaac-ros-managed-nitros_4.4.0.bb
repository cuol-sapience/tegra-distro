require isaac-ros-nitros.inc

DESCRIPTION = "Utilities for leveraging NITROS in custom ROS 2 nodes"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros"

ROS_CN = "isaac-ros-managed-nitros"
ROS_BPN = "isaac_ros_managed_nitros"

S = "${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_managed_nitros"

# gxf_isaac_message_compositor is a pre-built .so installed by isaac_ros_gxf,
# not a separate ROS package.
ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    message-filters \
    isaac-ros-nitros \
    isaac-ros-nitros-tensor-list-type \
    isaac-ros-gxf \
    isaac-ros-common \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    message-filters \
    isaac-ros-nitros \
    isaac-ros-nitros-tensor-list-type \
    isaac-ros-gxf \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
