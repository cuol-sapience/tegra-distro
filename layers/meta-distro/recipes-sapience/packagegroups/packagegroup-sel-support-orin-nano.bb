# SUMMARY = "TBD"
DESCRIPTION = "Jetson (Orin Nano) Support packages"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    setup-nv-boot-control \
    tegra-nv-boot-control-config \
    tegra-redundant-boot-base \
    tegra-nvfancontrol \
    tegra-nvphs \
    tegra-nvphs-base \
    tegra-nvpmodel \
    tegra-nvpmodel-base \
    tegra-nvpower \
    tegra-nvpower-base \
    tegra-nvpower-service \
    tegra-nvsciipc \
    tegra-nvsciipc-base \
    tegra-nvstartup \
    cuda-toolkit \
    nv-kernel-module-host1x \
    nv-kernel-module-tegra-drm \
    networkmanager-wifi \
    wpa-supplicant \
    wireless-regdb-static \
    nvidia-xdriver-socket \
    i2c-tools \
    packagegroup-sel-multimedia \
    "