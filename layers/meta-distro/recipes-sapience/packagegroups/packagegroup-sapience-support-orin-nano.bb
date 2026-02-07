# SUMMARY = "TBD"
DESCRIPTION = "Jetson (Orin Nano) Support packages"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


PACKAGES = "${PN}"


# override kernel flags to remove 'firmware_class.path=/etc/firmware'
KERNEL_ARGS:${PN} = "mminit_loglevel=4 console=ttyTCU0,115200 fbcon=map:0 nospectre_bhb video=efifb:off console=tty0"


MACHINE_EXTRA_RRECOMMENDS:append:${PN}  = " nv-kernel-module-host1x nv-kernel-module-tegra-drm"

KERNEL_MODULE_AUTOLOAD:append:${PN}  = " host1x tegra-drm"

PREFERRED_PROVIDER_virtual_dtb:${PN} = "nvidia-kernel-oot"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:${PN} += "nvidia-kernel-oot-alsa nvidia-kernel-oot-display"



RDEPENDS:${PN} = "\
    setup-nv-boot-control \
    tegra-nv-boot-control-config \
    tegra-redundant-boot-base \
    cuda-toolkit \
    nv-kernel-module-host1x \
    nv-kernel-module-tegra-drm \
    networkmanager-wifi \
    wpa-supplicant \
    wireless-regdb-static \
    "