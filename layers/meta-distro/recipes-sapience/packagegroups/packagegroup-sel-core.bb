# SUMMARY = "TBD"
DESCRIPTION = "Core package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_CORE_PACKAGES = "\
    sel-environment \
    packagegroup-sel-ros2 \
    packagegroup-sel-utils \
    packagegroup-sel-devel \
    packagegroup-sel-optitrack \
    packagegroup-sel-sdk \
    python3-pip \
"

RDEPENDS:${PN} = "${SEL_CORE_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_CORE_PACKAGES').split())}"

RDEPENDS:${PN}:append:jetson-orin-nano-devkit = " \
    kernel-module-smsc95xx \
    networkmanager-nmcli \
    packagegroup-sel-ai \
"

RRECOMMENDS:${PN}-staticdev:append:jetson-orin-nano-devkit = " \
    packagegroup-sel-ai-staticdev \
"
