# SUMMARY = "TBD"
DESCRIPTION = "sdk, dbg packages and -dev versions of ros packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

RDEPENDS:${PN} = "\
    packagegroup-core-sdk \
    packagegroup-core-standalone-sdk-target \
    packagegroup-core-tools-debug \
    packagegroup-sel-ros2-dev \
"

RDEPENDS:${PN}-staticdev = "\
    packagegroup-sel-ros2-staticdev \
"