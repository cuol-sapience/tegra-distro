require nvblox-isaac-ros.inc

DESCRIPTION = "Python utilities used across nvblox_ros"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nvblox"

ROS_CN = "nvblox-ros-python-utils"
ROS_BPN = "nvblox_ros_python_utils"

S = "${UNPACKDIR}/git/isaac_ros_nvblox/nvblox_ros_python_utils"

ROS_BUILD_DEPENDS = " \
    isaac-ros-common \
"

ROS_BUILDTOOL_DEPENDS = " \
    python3-native \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"

ROS_BUILD_TYPE = "ament_python"
inherit ros_${ROS_BUILD_TYPE}
