inherit ros_distro_humble
inherit ros_component

DESCRIPTION = "ROS2 C++ node for detecting preset ArUco markers from onboard camera streams and estimating their 3D pose."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"



ROS_CN = "aruco-pose-estimator-cpp"
ROS_BPN = "aruco_pose_estimator_cpp"

PV = "0.0.1"
PR = "r0"

SRCREV = "408eafc5c8bd93a224bbf87447a826e285f9e679"
SRC_URI = "git://github.com/SaidGuerazem/aruco_pose_estimator_cpp.git;branch=main;protocol=https"


ROS_BUILD_DEPENDS = " \
    ros-environment \
    rclcpp \
    std-msgs \
    sensor-msgs \
    geometry-msgs \
    cv-bridge \
    opencv \
"

# OpenCV on orin uses CUDA
ROS_BUILD_DEPENDS:append:jetson-orin-nano-devkit = " cuda-toolkit"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    std-msgs \
    sensor-msgs \
    geometry-msgs \
    nav-msgs \ 
    cv-bridge \
    opencv \
"

ROS_EXPORT_DEPENDS:append:jetson-orin-nano-devkit = " cuda-toolkit"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    std-msgs \
    sensor-msgs \
    geometry-msgs \
    nav-msgs \ 
    cv-bridge \
    opencv \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}