FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://tegra234-p3767-camera-ar0234-dual.dts \
    file://0001-add-custom-overlay-to-makefile.patch \
    file://0023-driver-media-i2c-arducam-ar0234-Added-arducam-AR0234.patch \
"

EXTRA_OEMAKE += "IGNORE_MODULES='nv_ar0234'"


TEGRA_OOT_CAMERA_DRIVERS:append = "nv-kernel-module-arducam-jetvariety"


DEPENDS += "dtc-native"


DTBS_DIR = "${B}/kernel-devicetree/generic-dts/dtbs"

BASE_DTB ?= "tegra234-p3768-0000+p3767-0005-nv-super.dtb"

# Inject your custom overlay into the JP6 hardware OOT tree before compilation
do_configure:append() {
    # Ensure the target directory exists just in case
    install -d ${S}/hardware/nvidia/t23x/nv-public/overlay
    
    # Copy your overlay into the build tree
    install -m 0644 ${UNPACKDIR}/tegra234-p3767-camera-ar0234-dual.dts ${S}/hardware/nvidia/t23x/nv-public/overlay/
}

do_compile:append() {
    DTBO="${DTBS_DIR}/tegra234-p3767-camera-ar0234-dual.dtbo"
    BASE="${DTBS_DIR}/${BASE_DTB}"
    MERGED="${DTBS_DIR}/tegra234-p3768-0000+p3767-0005-nv-super-sel.dtb"

    if [ ! -f "${DTBO}" ]; then
        bbfatal "Expected overlay not found after OOT build: ${DTBO}"
    fi
    if [ ! -f "${BASE}" ]; then
        bbfatal "Base DTB not found: ${BASE}"
    fi

    fdtoverlay -i "${BASE}" -o "${MERGED}" "${DTBO}"
    bbnote "Merged ${BASE_DTB} + ar0234-dual.dtbo -> tegra234-p3768-0000+p3767-0005-nv-super-sel.dtb"
}




# put conftest.h in staging sysroot to be used by ar0234-mipi-nvidia
do_install:append() {
    # Install the full conftest output tree so relative includes work
    install -d ${D}${includedir}/${BPN}
    cp -r ${B}/out/nvidia-conftest/. ${D}${includedir}/${BPN}/
}
