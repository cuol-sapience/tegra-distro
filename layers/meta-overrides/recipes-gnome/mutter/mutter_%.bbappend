FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://0002-disable-kms-on-tagged-gpu.patch \
    file://98-sapience-tegra-mutter.rules \
"

do_install:append() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${UNPACKDIR}/98-sapience-tegra-mutter.rules ${D}${sysconfdir}/udev/rules.d/98-sapience-tegra-mutter.rules
}