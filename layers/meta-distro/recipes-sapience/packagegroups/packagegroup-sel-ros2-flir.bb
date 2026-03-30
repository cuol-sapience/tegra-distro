# SUMMARY = "TBD"
DESCRIPTION = "ros2 packages for flir cameras"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
     flir-camera-description \
     flir-camera-msgs \
     spinnaker-camera-driver \
     spinnaker-synchronized-camera-driver \
"