# Don't attempt to build with ROCm for nvidia SoC!
EXTRA_OECMAKE:append:jetson-orin-nano-devkit = " -DUSE_ROCM=OFF "

# Install a PEP 566 dist-info directory so pip recognises torch as already
# installed and does not attempt to download the CPU wheel on top of the
# Yocto-managed package.
do_install:append() {
    if ! ${@bb.utils.contains('PACKAGECONFIG', 'python', 'true', 'false', d)}; then
        return
    fi

    DISTINFO="${D}${PYTHON_SITEPACKAGES_DIR}/torch-${PV}.dist-info"
    install -d "${DISTINFO}"

    cat > "${DISTINFO}/METADATA" <<EOF
Metadata-Version: 2.1
Name: torch
Version: ${PV}
Summary: Tensors and Dynamic neural network computation with strong GPU acceleration
Home-page: https://pytorch.org/
License: BSD-3-Clause
EOF

    printf 'yocto\n' > "${DISTINFO}/INSTALLER"

    # Empty RECORD is valid; pip only uses it for uninstall tracking.
    touch "${DISTINFO}/RECORD"
}

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/torch-${PV}.dist-info"

# Allow recipes to depend on either conventional PyPI-style alias for pytorch.
RPROVIDES:${PN} += "python3-torch python3-pytorch"