SUMMARY = "AR0234 MIPI driver"
DESCRIPTION = "AR0234 MIPI driver for NVIDIA Tegra platforms on hardware not using max96712"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
    git://github.com/Kurokesu/ar0234-mipi-nvidia.git;branch=main;protocol=https \
    file://Makefile \
    file://0001-fix.patch \
"

SRCREV = "295a3caaf618b352c04603848c522f70f450bd15"

PV = "1.0.0-git"

DEPENDS += "nvidia-kernel-oot"
do_compile[depends] += "nvidia-kernel-oot:do_populate_sysroot"

inherit module

EXTRA_OEMAKE += " \
    KDIR=${STAGING_KERNEL_DIR} \
    KCFLAGS=-I${STAGING_INCDIR}/nvidia-kernel-oot \
    KBUILD_EXTRA_SYMBOLS=${STAGING_INCDIR}/nvidia-kernel-oot/Module.symvers \
"

do_compile() {
    unset LDFLAGS
    install -m 0644 ${UNPACKDIR}/Makefile ${S}/Makefile

    oe_runmake
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 ${B}/nv_ar0234.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/

    install -d ${D}/var/nvidia/nvcam/settings
    install -m 0644 ${S}/tuning/camera_overrides.isp ${D}/var/nvidia/nvcam/settings/camera_overrides.isp
}

FILES:${PN} += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/nv_ar0234.ko"
FILES:${PN} += "/var/nvidia/nvcam/settings/camera_overrides.isp"


RPROVIDES:${PN} += "kernel-module-ar0234"

KERNEL_MODULE_AUTOLOAD:append:jetson-orin-nano-devkit = " nv_ar0234"
COMPATIBLE_MACHINE = "jetson-orin-nano-devkit"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dbg += "buildpaths"
