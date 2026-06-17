# SUMMARY = "TBD"
DESCRIPTION = "ros2 packages for ouster lidars"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_ROS2_OUSTER_PACKAGES = "\
     ouster-ros \
     ouster-sensor-msgs \
     ouster-msgs \
"

RDEPENDS:${PN} = "${SEL_ROS2_OUSTER_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_ROS2_OUSTER_PACKAGES').split())}"
