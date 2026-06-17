# SUMMARY = "TBD"
DESCRIPTION = "msgs package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_ROS2_MSGS_PACKAGES = "\
    common-interfaces \
	action-msgs \
	lifecycle-msgs \
	vision-msgs \
"

RDEPENDS:${PN} = "${SEL_ROS2_MSGS_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_ROS2_MSGS_PACKAGES').split())}"
