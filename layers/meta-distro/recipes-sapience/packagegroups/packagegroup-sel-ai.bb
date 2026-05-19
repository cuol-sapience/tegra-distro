DESCRIPTION = "ai packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    pytorch \
    python3-torch \
    nvblox \
    nvblox-ros \
    nvblox-rviz-plugin \
    nvblox-ros-python-utils \
"