require negotiated.inc

DESCRIPTION = "ROS 2 message definitions for negotiated pub/sub"
HOMEPAGE = "https://github.com/osrf/negotiated"

ROS_CN = "negotiated-interfaces"
ROS_BPN = "negotiated_interfaces"

S = "${UNPACKDIR}/git/negotiated/negotiated_interfaces"

ROS_BUILD_DEPENDS = " \
    rosidl-default-generators \
    rosidl-default-runtime \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXEC_DEPENDS = " \
    rosidl-default-runtime \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
