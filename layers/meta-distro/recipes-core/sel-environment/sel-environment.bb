LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "\
    file://profile-sourcing.sh \
    file://sel.sh \
"


S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 sel.sh ${D}${sysconfdir}/profile.d/
    chmod 0644 ${D}${sysconfdir}/profile.d/sel.sh

    install -m 664 profile-sourcing.sh ${D}${sysconfdir}/bash.bashrc
}