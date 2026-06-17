# SUMMARY = "TBD"
DESCRIPTION = "optitrack package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_OPTITRACK_PACKAGES = "\
    vrpn \
    vrpn-mocap \
"

RDEPENDS:${PN} = "${SEL_OPTITRACK_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_OPTITRACK_PACKAGES').split())}"
