FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://systemd-user"

S = "${UNPACKDIR}"

do_install:append() {
    install -d ${D}${sysconfdir}/pam.d
    install -m 0644 ${UNPACKDIR}/systemd-user ${D}${sysconfdir}/pam.d/systemd-user
}

FILES:${PN} += "${sysconfdir}/pam.d/systemd-user"