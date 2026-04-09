# SUMMARY = "TBD"
DESCRIPTION = "Development package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    packagegroup-core-buildessential \
    git \
    cmake \
    make \ 
    ninja \
"