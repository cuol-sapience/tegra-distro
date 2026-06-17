DESCRIPTION = "ai packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_AI_PACKAGES = "\
    pytorch \
    nvblox \
    tensorrt-core \
    tensorrt-samples \
    tensorrt-plugins-prebuilt \
    tensorrt-trtexec-prebuilt \
"

RDEPENDS:${PN} = "${SEL_AI_PACKAGES}"
RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_AI_PACKAGES').split())}"
