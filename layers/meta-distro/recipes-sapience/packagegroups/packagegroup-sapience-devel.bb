# SUMMARY = "TBD"
DESCRIPTION = "Development package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    git \
    cmake \
    gcc \
    make \ 
    ninja \
"