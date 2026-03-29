DESCRIPTION = "Lightweight LiDAR-inertial odometry package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b8006bec129c9b8669ec031a076bf27"


ROS_CN = "direct-lidar-inertial-odometry"
ROS_BPN = "direct_lidar_inertial_odometry"

PV = "1.1.1"
PR = "r0"

SRCREV = "fc8d183f18cdcfb9bb4fc754c6d373cedc4cbd04"
SRC_URI = "git://github.com/cuol-sapience/dlio;branch=master;name=master;protocol=https"

DEPENDS = "ament-cmake-native rclcpp ros-environment std-msgs sensor-msgs geometry-msgs nav-msgs pcl-ros libeigen"

inherit ros_ament_cmake