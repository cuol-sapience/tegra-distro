FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://91-nvidia-tegra-nvgpu.rules \
    file://99-sapience-tegra-gpu-perms.rules \
"

do_install:append() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${UNPACKDIR}/99-sapience-tegra-gpu-perms.rules ${D}${sysconfdir}/udev/rules.d/99-sapience-tegra-gpu-perms.rules
}