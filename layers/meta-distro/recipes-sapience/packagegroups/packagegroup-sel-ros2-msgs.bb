# SUMMARY = "TBD"
DESCRIPTION = "msgs package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = "\
    common-interfaces \
	action-msgs \
	lifecycle-msgs \
"