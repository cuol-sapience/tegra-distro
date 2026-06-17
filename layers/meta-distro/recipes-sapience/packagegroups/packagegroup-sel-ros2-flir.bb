# SUMMARY = "TBD"
DESCRIPTION = "ros2 packages for flir cameras"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_ROS2_FLIR_PACKAGES = "\
     flir-camera-description \
     flir-camera-msgs \
     spinnaker-camera-driver \
     spinnaker-synchronized-camera-driver \
"

RDEPENDS:${PN} = "${SEL_ROS2_FLIR_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_ROS2_FLIR_PACKAGES').split())}"
