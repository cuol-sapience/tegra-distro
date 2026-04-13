DESCRIPTION = "Foxglove SDK"
HOMEPAGE = "https://github.com/foxglove/foxglove-sdk"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=341d96a5ee80c3f5b07f0594495657af"


require foxglove-sdk/foxglove-sdk-crates_git.inc
# inherit cargo-update-recipe-crates

# April 11, 2026 3:23 PM GMT +1
SRCREV = "a2baf30b67f19389b98542312beef1cc1c591a3b"
SRC_URI += "git://github.com/foxglove/foxglove-sdk.git;branch=main;protocol=https"


PV = "0.21.0+git"

FOXGLOVE_LIB_PREFIX = "libfoxglove"

PACKAGES =+ " \
    foxglove-sdk-examples \
    ${FOXGLOVE_LIB_PREFIX}-python \
    ${FOXGLOVE_LIB_PREFIX} \
    ${FOXGLOVE_LIB_PREFIX}-staticdev \
"

include foxglove-sdk/rust-setup.inc

inherit setuptools3 python_maturin

FOXGLOVE_REMOTE_ACCESS_DEPS = "glib-2.0 libva libwebsockets"

# Optional features
PACKAGECONFIG[remote-access] = "FOXGLOVE_REMOTE_ACCESS=ON, FOXGLOVE_REMOTE_ACCESS=OFF, ${FOXGLOVE_REMOTE_ACCESS_DEPS}"
# remote-access disables foxglove_cpp_static needed by foxglove-sdk at time of writing
PACKAGECONFIG ??= "" 

# C++ SDK
DEPENDS += "libwebrtc-rs"
export LK_CUSTOM_WEBRTC = "${STAGING_LIBDIR}/livekit-webrtc"
EXTRA_OEMAKE += "${PACKAGECONFIG_CONFARGS}"
export CPP_SDK_DIR = "artifacts/foxglove"
export PYO3_CROSS_PYTHON_VERSION = "${PYTHON_BASEVERSION}"
export PYO3_CROSS_LIB_DIR = "${STAGING_LIBDIR}"

PEP517_SOURCE_PATH = "${S}/python/foxglove-sdk"
PYTHON_MATURIN_FEATURES = "pyo3/extension-module${@bb.utils.contains('PACKAGECONFIG', 'remote-access', ',remote-access', '', d)}"


# C++ library
EXTRA_OEMAKE += "CMAKE_ARGS='-DCMAKE_TOOLCHAIN_FILE=${CMAKE_TOOLCHAIN_FILE} -DCMAKE_SKIP_RPATH=ON -DCMAKE_SKIP_INSTALL_RPATH=ON -DCMAKE_PREFIX_PATH=${STAGING_DIR_TARGET}/usr -DFOXGLOVE_PREBUILT_LIB_DIR=${S}/${CPP_SDK_DIR}/lib'"
# -DFETCHCONTENT_FULLY_DISCONNECTED=ON

# mainly since corrosion isn't packaged
# corrosion, date, httplib, mcap, lz4
do_compile[network] = "1" 

do_compile() {
    # cd to root of git source tree (in block to not affect subsequent commands)
    cd ${S}

    # OE's cargo class redirects target-dir to ${B}/target, so override
    # CARGO_LIB_DIR so Container.mk finds the built libraries there.
    # C/C++ SDK
    oe_runmake -f Container.mk build-cpp-dist CARGO_LIB_DIR=${B}/target/${CARGO_BUILD_TARGET}/release

    # C++ library
    oe_runmake -f Container.mk build-cpp

    # Python library — call maturin directly, bypassing the uv+yarn-based
    # Container.mk build-python target which is not available in OE.
    maturin build \
        --release \
        -m "${S}/python/foxglove-sdk/Cargo.toml" \
        --target "${CARGO_BUILD_TARGET}" \
        --out "${PEP517_WHEEL_PATH}" \
        --features "${PYTHON_MATURIN_FEATURES}"
}


do_install() {
    # C/C++ lib, headers and cmake package config
    cmake --install ${S}/cpp/build --prefix ${D}${prefix}

    # Examples are not in cmake's install rules; install them manually.
    install -d ${D}${bindir}
    for f in ${S}/cpp/build/example_*; do
        [ -f "$f" ] && [ -x "$f" ] && install -m 0755 "$f" ${D}${bindir}/
    done

    # Python extension wheel
    python_pep517_do_install
}

DEPENDS += " \
    nlohmann-json \
    libwebsockets \
    openssl \
    openssl-native \
    catch2 \
"


RDEPENDS:${FOXGLOVE_LIB_PREFIX} = " \
    libwebsockets \
    nlohmann-json \
    openssl \
"

RDEPENDS:${FOXGLOVE_LIB_PREFIX}-python = " \
    python3-core \
"


RDEPENDS:foxglove-sdk-examples = "${FOXGLOVE_LIB_PREFIX}"


FILES:${FOXGLOVE_LIB_PREFIX} = " \
    ${libdir}/libfoxglove.so \
    ${libdir}/libfoxglove_cpp_shared.so \
    ${includedir}/foxglove/ \
    ${includedir}/foxglove-c/ \
    ${libdir}/cmake/foxglove-sdk/ \
"


FILES:${FOXGLOVE_LIB_PREFIX}-staticdev = " \
    ${libdir}/libfoxglove.a \
    ${libdir}/libfoxglove_cpp_static.a \
"

# Python extension (module-name = "foxglove._foxglove_py" in pyproject.toml)
FILES:${FOXGLOVE_LIB_PREFIX}-python = " \
    ${PYTHON_SITEPACKAGES_DIR}/foxglove/ \
    ${PYTHON_SITEPACKAGES_DIR}/foxglove_sdk-*.dist-info/ \
"

# C++ SDK example binaries
FILES:foxglove-sdk-examples = "${bindir}/example_*"


# empty and don't ship -dev, -staticdev
FILES:${PN}-dev = ""
FILES:${PN}-staticdev = ""

# root is just a meta-package
RDEPENDS:${PN} += "foxglove-sdk-examples ${FOXGLOVE_LIB_PREFIX} ${FOXGLOVE_LIB_PREFIX}-staticdev ${FOXGLOVE_LIB_PREFIX}-python"
ALLOW_EMPTY:${PN} = "1"

INSANE_SKIP:${PN}-dbg += "buildpaths"
# /usr/lib/python3.14/site-packages/foxglove_sdk.libs/libzstd-*.so.1
# TODO: move to libfoxglove-python
INSANE_SKIP:${PN} += "already-stripped"

#  /usr/bin/example_mcap
INSANE_SKIP:${PN}-examples += "buildpaths"
# /usr/lib/libfoxglove_cpp_shared.so
INSANE_SKIP:${FOXGLOVE_LIB_PREFIX} += "buildpaths"