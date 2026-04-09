# SUMMARY = "TBD"
DESCRIPTION = "Jetson (Orin Nano) Support packages"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    cuda-toolkit \
    kernel-module-ar0234 \
    networkmanager-wifi \
    wpa-supplicant \
    wireless-regdb-static \
    nvidia-xdriver-socket \
    i2c-tools \
    packagegroup-sel-multimedia \
    "