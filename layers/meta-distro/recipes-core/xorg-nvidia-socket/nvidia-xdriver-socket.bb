SRC_URI += "file://nvidia-xdriver.conf"

inherit systemd tmpfiles

do_install:append() {
    install -d ${D}${nonarch_libdir}/tmpfiles.d
    install -m 0644 ${WORKDIR}/nvidia-xdriver.conf \
        ${D}${nonarch_libdir}/tmpfiles.d/
}

FILES:${PN} += "${nonarch_libdir}/tmpfiles.d/nvidia-xdriver.conf"