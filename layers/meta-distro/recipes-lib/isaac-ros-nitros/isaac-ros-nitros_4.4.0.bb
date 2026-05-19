require isaac-ros-nitros.inc

DESCRIPTION = "NVIDIA Isaac Transport for ROS — zero-copy hardware-accelerated messaging"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros"

ROS_CN = "isaac-ros-nitros"
ROS_BPN = "isaac_ros_nitros"

S = "${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_nitros"

# All gxf_isaac_* cmake targets (optimizer, message_compositor, gxf_helpers,
# sight, atlas) are pre-built .so files installed by the isaac_ros_gxf package —
# they are not separate ROS packages.
ROS_BUILD_DEPENDS = " \
    negotiated \
    rclcpp \
    rclcpp-components \
    std-msgs \
    diagnostic-msgs \
    isaac-ros-gxf \
    ament-index-cpp \
    isaac-ros-common \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    negotiated \
    rclcpp \
    rclcpp-components \
    std-msgs \
    diagnostic-msgs \
    isaac-ros-gxf \
    ament-index-cpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
