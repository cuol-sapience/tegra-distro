# SUMMARY = "TBD"
DESCRIPTION = "optitrack package group"

PV = "1.0.0"

inherit packagegroup

RDEPENDS:${PN} = "\
    vrpn \
    vrpn-mocap \
"