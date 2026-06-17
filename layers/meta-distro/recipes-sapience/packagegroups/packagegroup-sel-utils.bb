# SUMMARY = "TBD"
DESCRIPTION = "Utility package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_UTILS_PACKAGES = "\
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
    rsync \
"

RDEPENDS:${PN} = "${SEL_UTILS_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_UTILS_PACKAGES').split())}"
