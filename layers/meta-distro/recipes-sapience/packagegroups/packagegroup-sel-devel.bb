# SUMMARY = "TBD"
DESCRIPTION = "Development package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_DEVEL_PACKAGES = "\
    packagegroup-core-buildessential \
    git \
    cmake \
    make \
    ninja \
"

RDEPENDS:${PN} = "${SEL_DEVEL_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_DEVEL_PACKAGES').split())}"
