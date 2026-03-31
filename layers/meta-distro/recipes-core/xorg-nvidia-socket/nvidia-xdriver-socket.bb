LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://nvidia-xdriver.conf"

S = "${UNPACKDIR}"

inherit systemd

do_install:append() {
    install -d ${D}${nonarch_libdir}/tmpfiles.d
    install -m 0644 ${UNPACKDIR}/nvidia-xdriver.conf \
        ${D}${nonarch_libdir}/tmpfiles.d/
}

FILES:${PN} += "${nonarch_libdir}/tmpfiles.d/nvidia-xdriver.conf"