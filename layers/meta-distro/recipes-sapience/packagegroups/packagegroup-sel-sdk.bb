# SUMMARY = "TBD"
DESCRIPTION = "sdk, dbg packages and -dev versions of ros packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_SDK_PACKAGES = "\
    packagegroup-core-sdk \
    packagegroup-core-standalone-sdk-target \
    packagegroup-core-tools-debug \
    packagegroup-sel-ros2-dev \
"

RDEPENDS:${PN} = "${SEL_SDK_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_SDK_PACKAGES').split())}"
