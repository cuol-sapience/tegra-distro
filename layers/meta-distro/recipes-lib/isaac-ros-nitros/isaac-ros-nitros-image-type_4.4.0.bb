require isaac-ros-nitros.inc

DESCRIPTION = "Isaac ROS NITROS Image Type"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros"

ROS_CN = "isaac-ros-nitros-image-type"
ROS_BPN = "isaac_ros_nitros_image_type"

# Package lives in the nitros_type subdirectory of the monorepo
S = "${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_nitros_type/isaac_ros_nitros_image_type"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    isaac-ros-nitros \
    isaac-ros-common \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    isaac-ros-nitros \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
