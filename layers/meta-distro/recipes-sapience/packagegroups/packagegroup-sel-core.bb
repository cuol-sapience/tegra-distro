# SUMMARY = "TBD"
DESCRIPTION = "Core package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    sel-environment \
    kernel-module-smsc95xx \
    networkmanager-nmcli \
    packagegroup-sel-ros2 \
    packagegroup-sel-ai \
    packagegroup-sel-utils \
    packagegroup-sel-devel \
"