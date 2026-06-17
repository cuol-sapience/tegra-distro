DESCRIPTION = "ai packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

RDEPENDS:${PN} = "\
    pytorch \
    nvblox \
    tensorrt-core \
    tensorrt-samples \
    tensorrt-plugins-prebuilt \
    tensorrt-trtexec-prebuilt \
"

RDEPENDS:${PN}-staticdev = "\
    pytorch-staticdev \
    tensorrt-core-staticdev \
    tensorrt-plugins-prebuilt-staticdev \
"