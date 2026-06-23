DESCRIPTION = "ai packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

RDEPENDS:${PN} = "\
    pytorch \
    nvblox \
    python3-optuna \
    python3-pytorch-symbolic \
    python3-resdag \
    python3-scipy \
"

RDEPENDS:${PN}:append:jetson-orin-nano-devkit = "\
    tensorrt-core \
    tensorrt-samples \
    tensorrt-plugins-prebuilt \
    tensorrt-trtexec-prebuilt \
"

RDEPENDS:${PN}-staticdev = "\
    pytorch-staticdev \
"

RDEPENDS:${PN}-staticdev:append:jetson-orin-nano-devkit = "\
    tensorrt-core-staticdev \
    tensorrt-plugins-prebuilt-staticdev \
"