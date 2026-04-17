
inherit ros_distro_humble

DESCRIPTION = "Ouster ROS2 driver"
AUTHOR = "ouster developers <oss@ouster.io>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=c1feec27682903a4270dbb401e443f91"


ROS_CN = "ouster-ros"
ROS_BPN = "ouster_ros"

PV = "0.14.0+git"

SRC_URI = "git://github.com/ouster-lidar/ouster-ros.git;branch=ros2;protocol=https;subpath=ouster-ros"
SRCREV = "f56b1a0e0b12985c41d3f2630344fb5c5963f571"

S = "${UNPACKDIR}/ouster-ros"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libtins-dev} \
    curl \
    cv-bridge \
    geometry-msgs \
    jsoncpp \
    libeigen \
    ouster-sensor-msgs \
    pcl \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    class-loader \
    sensor-msgs \
    spdlog \
    std-msgs \
    std-srvs \
    tf2-eigen \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    ouster-sensor-msgs \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    class-loader \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-eigen \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libtins-dev} \
    curl \
    cv-bridge \
    geometry-msgs \
    jsoncpp \
    launch \
    launch-ros \
    ouster-sensor-msgs \
    pcl-conversions \
    pcl-ros \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    class-loader \
    rosidl-default-runtime \
    sensor-msgs \
    spdlog \
    std-msgs \
    std-srvs \
    tf2-eigen \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
