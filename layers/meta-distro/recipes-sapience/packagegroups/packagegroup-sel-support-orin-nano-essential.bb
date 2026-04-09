# SUMMARY = "TBD"
DESCRIPTION = "Jetson (Orin Nano) Support packages - Essential (required for operation)"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    setup-nv-boot-control \
    tegra-nv-boot-control-config \
    tegra-redundant-boot-base \
    tegra-nvfancontrol \
    tegra-nvphs \
    tegra-nvphs-base \
    tegra-nvpmodel \
    tegra-nvpmodel-base \
    tegra-nvpower \
    tegra-nvsciipc \
    tegra-nvsciipc-base \
    tegra-nvstartup \
    nv-kernel-module-host1x \
    nv-kernel-module-tegra-drm \
    nvidia-kernel-oot-alsa \
    nvidia-kernel-oot-display \
    nvidia-kernel-oot-devicetrees \
    tegra-configs-udev \
    tegra-firmware \
    resize-nvme \
"