FILESEXTRAPATHS:prepend := "${THISDIR}/files:"


SRC_URI:append = " \
    file://0001-fix-gcc15-build.patch \
"