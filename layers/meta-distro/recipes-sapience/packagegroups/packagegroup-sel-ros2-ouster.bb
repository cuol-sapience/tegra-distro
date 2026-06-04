# SUMMARY = "TBD"
DESCRIPTION = "ros2 packages for ouster lidars"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
     ouster-ros \
     ouster-sensor-msgs \
     ouster-msgs \
"