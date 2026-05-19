require negotiated.inc

DESCRIPTION = "Negotiating publisher and subscription for ROS 2"
HOMEPAGE = "https://github.com/osrf/negotiated"

ROS_CN = "negotiated"
ROS_BPN = "negotiated"

S = "${UNPACKDIR}/git/negotiated/negotiated"

ROS_BUILD_DEPENDS = " \
    negotiated-interfaces \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    negotiated-interfaces \
    rclcpp \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
