# SUMMARY = "TBD"
DESCRIPTION = "Jetson (Orin Nano) Support packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    cuda-toolkit \
    gcc-for-nvcc \
    kernel-module-ar0234 \
    kernel-module-ftdi-sio \
    networkmanager-wifi \
    wpa-supplicant \
    wireless-regdb-static \
    nvidia-xdriver-socket \
    i2c-tools \
    packagegroup-sel-multimedia \
"