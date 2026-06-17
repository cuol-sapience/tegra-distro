# SUMMARY = "TBD"
DESCRIPTION = "Jetson (Orin Nano) Support packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_SUPPORT_ORIN_NANO_PACKAGES = "\
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

RDEPENDS:${PN} = "${SEL_SUPPORT_ORIN_NANO_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_SUPPORT_ORIN_NANO_PACKAGES').split())}"
