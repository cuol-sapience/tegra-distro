# SUMMARY = "TBD"
DESCRIPTION = "Utility package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    bash \
    sudo \
    net-tools \
    iproute2 \
    os-release \
    usbutils \
    pciutils \
    btop \
    htop \
    nano \
    tmux \
    screen \
"