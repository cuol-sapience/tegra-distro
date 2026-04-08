# SUMMARY = "TBD"
DESCRIPTION = "ros2 package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
     ros-core \
     micro-xrce-dds-agent \
     packagegroup-sel-ros2-flir \
     packagegroup-sel-ros2-ouster \
     python3-colcon-common-extensions \
"