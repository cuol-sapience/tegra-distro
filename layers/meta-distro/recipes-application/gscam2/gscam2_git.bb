inherit ros_distro_humble
inherit ros_component

DESCRIPTION = "ROS2 port of gscam with IPC support"
HOMEPAGE = "https://github.com/clydemcqueen/gscam2"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

ROS_CN = "gscam2"
ROS_BPN = "gscam2"

PV = "0.0.2+git"

SRCREV = "392486810d0e511da444a207bf13db7632f0c49a"
SRC_URI = "git://github.com/clydemcqueen/gscam2.git;branch=main;protocol=https"

GSCAM2_DEPS = " \
    camera-calibration-parsers \
    camera-info-manager \
    class-loader \
    cv-bridge \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    rclcpp \
    rclcpp-components \
    rclpy \
    sensor-msgs \
"

ROS_BUILD_DEPENDS = " \
    ${GSCAM2_DEPS} \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    ${GSCAM2_DEPS} \
"

ROS_EXEC_DEPENDS = " \
    ${GSCAM2_DEPS} \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}