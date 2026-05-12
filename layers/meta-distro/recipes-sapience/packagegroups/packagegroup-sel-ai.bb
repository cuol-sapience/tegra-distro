DESCRIPTION = "ai packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    pytorch \
    python3-torch \
    nvblox \
    python3-pip \
    python3-scipy \
"