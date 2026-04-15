inherit ros_distro_humble
inherit ros_component

DESCRIPTION = "Lightweight LiDAR-inertial odometry package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b8006bec129c9b8669ec031a076bf27"


ROS_CN = "direct-lidar-inertial-odometry"
ROS_BPN = "direct_lidar_inertial_odometry"

PV = "1.1.1"
PR = "r0"

SRCREV = "bbbd0677a78ac5468d65b332a8c4415ad1693c18"
SRC_URI = "git://github.com/cuol-sapience/dlio.git;branch=city;protocol=https"


ROS_BUILD_DEPENDS = " \
    ros-environment \
    geometry-msgs \
    rclcpp \
    std-msgs \
    sensor-msgs \
    geometry-msgs \
    nav-msgs \ 
    pcl \
    pcl-conversions \
    pcl-ros \ 
    libeigen \
    openmp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"


ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    rclcpp \
    std-msgs \
    sensor-msgs \
    geometry-msgs \
    nav-msgs \ 
    pcl \
    pcl-conversions \
    pcl-ros \ 
    openmp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    rclcpp \
    std-msgs \
    sensor-msgs \
    geometry-msgs \
    nav-msgs \ 
    pcl-conversions \
    pcl-ros \ 
    libeigen \
    openmp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

EXTRA_OECMAKE += "-DCMAKE_NO_SYSTEM_FROM_IMPORTED=ON"