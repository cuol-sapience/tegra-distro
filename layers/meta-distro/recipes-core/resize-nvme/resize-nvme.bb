SUMMARY = "Resize rootfs to fill NVMe partition on first boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://resize-nvme.service \
"


inherit systemd

RDEPENDS:${PN} = "e2fsprogs-resize2fs"

SYSTEMD_SERVICE:${PN} = "resize-nvme.service"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/resize-nvme.service ${D}${systemd_system_unitdir}
}