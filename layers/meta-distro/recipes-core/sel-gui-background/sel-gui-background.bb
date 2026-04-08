LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "\
    file://00-background \
    file://dconf-profile-user.txt \
    file://sel-background.png \
"


S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/dconf/profile
    install -m 0644 ${S}/dconf-profile-user.txt ${D}${sysconfdir}/dconf/profile/user

    install -d ${D}${sysconfdir}/dconf/db/local.d
    install -m 0644 ${S}/00-background ${D}${sysconfdir}/dconf/db/local.d/00-background

    install -d ${D}${datadir}/backgrounds
    install -m 0644 ${S}/sel-background.png ${D}${datadir}/backgrounds/sel.png
}

FILES:${PN} += "${datadir}/backgrounds/sel.png"