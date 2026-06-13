DESCRIPTION = "ai packages"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    pytorch \
    python3-torch \
    nvblox \
    tensorrt-core \
    tensorrt-samples \
    tensorrt-plugins \
    tensorrt-trtexec \
    tensorrt-trtexec-prebuilt \
    onnx \
    onnxruntime \
    python3-onnx \
"