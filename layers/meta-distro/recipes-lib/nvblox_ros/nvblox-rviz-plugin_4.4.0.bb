require nvblox-isaac-ros.inc

DESCRIPTION = "RViz visualization plugin for Nvblox"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nvblox"

ROS_CN = "nvblox-rviz-plugin"
ROS_BPN = "nvblox_rviz_plugin"

S = "${UNPACKDIR}/git/isaac_ros_nvblox/nvblox_rviz_plugin"

ROS_BUILD_DEPENDS = " \
    isaac-ros-common \
    nvblox-msgs \
    pluginlib \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
    rviz-default-plugins \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    nvblox-msgs \
    pluginlib \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
    rviz-default-plugins \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
