
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

SRC_URI = "gitsm://github.com/ouster-lidar/ouster-ros.git;branch=ros2;protocol=https;destsuffix=git/ouster-ros \
           file://0001-use-system-spdlog.patch;patchdir=${UNPACKDIR}/git/ouster-ros \
           file://0002-remove-vendored-spdlog.patch;patchdir=${UNPACKDIR}/git/ouster-ros \
          "
SRCREV = "e0fd263034c2c25a20bac9973bd984a566bee833"

S = "${UNPACKDIR}/git/ouster-ros/ouster-ros"

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
    fmt \
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
    libzip \
    fmt \
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
    fmt \
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

FILES:${PN} += " \
    /opt/ros/humble/lib/libos*.so \
    /opt/ros/humble/lib/libouster*.so \
"

FILES:${PN}-dev = " \
    /opt/ros/humble/include/* \
    /opt/ros/humble/share/ouster_ros/cmake/* \
"   

EXTRA_OECMAKE += " \
    -DCMAKE_NO_SYSTEM_FROM_IMPORTED=ON \
    -Dspdlog_DIR=${STAGING_DIR_TARGET}/usr/lib/cmake/spdlog \
    -DSPDLOG_FMT_EXTERNAL=ON \
"

CXXFLAGS:append = " -DSPDLOG_FMT_EXTERNAL"
