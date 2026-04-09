# SUMMARY = "TBD"
DESCRIPTION = "Core package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    sel-environment \
    packagegroup-sel-ros2 \
    packagegroup-sel-utils \
    packagegroup-sel-devel \
"

RDEPENDS:${PN}:jetson-orin-nano-devkit:append = " \
    kernel-module-smsc95xx \
    networkmanager-nmcli \
    packagegroup-sel-ai \
"