# SUMMARY = "TBD"
DESCRIPTION = "sdk, dbg packages and -dev versions of ros packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    packagegroup-core-sdk \
    packagegroup-core-standalone-sdk-target \
    packagegroup-core-tools-debug \
    packagegroup-sel-ros2-dev \
"

RDEPENDS:${PN}:append:jetson-orin-nano-devkit = " \
    packagegroup-sel-ai-dev \
    cuda-toolkit-dev \
"