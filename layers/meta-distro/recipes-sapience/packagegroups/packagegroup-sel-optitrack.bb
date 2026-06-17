# SUMMARY = "TBD"
DESCRIPTION = "optitrack package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

SEL_OPTITRACK_PACKAGES = "\
    vrpn \
    vrpn-mocap \
"

RDEPENDS:${PN} = "${SEL_OPTITRACK_PACKAGES}"
