DESCRIPTION = "Foxglove SDK"
HOMEPAGE = "https://github.com/foxglove/foxglove-sdk"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=341d96a5ee80c3f5b07f0594495657af"


require foxglove-sdk-crates.inc
# inherit cargo-update-recipe-crates

SRCREV = "68253a52624adc8efaeb974c8e6da8c7457b3539"
SRC_URI += "git://github.com/foxglove/foxglove-sdk.git;branch=main;protocol=https"

FOXGLOVE_LIB_PREFIX = "libfoxglove"

PACKAGES =+ "foxglove-sdk-examples ${FOXGLOVE_LIB_PREFIX}-python ${FOXGLOVE_LIB_PREFIX}-c ${FOXGLOVE_LIB_PREFIX}-cxx"

FILES:foxglove-sdk-examples = "${bindir}/example_* ${bindir}/remote_data_loader_backend_conformance"
FILES:${FOXGLOVE_LIB_PREFIX}-c = "${libdir}/libfoxglove.so"
FILES:${FOXGLOVE_LIB_PREFIX}-cxx = "${includedir}/foxglove/ ${includedir}/foxglove_data_loader/"
FILES:${FOXGLOVE_LIB_PREFIX}-python = "${PYTHON_SITEPACKAGES_DIR}/libfoxglove_py.so"


TOOLCHAIN = "clang"
TOOLCHAIN_NATIVE = "clang"


inherit cargo pkgconfig cuda-available

export BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${STAGING_DIR_TARGET} -L${STAGING_LIBDIR} -I${STAGING_INCDIR}"


export ZSTD_SYS_USE_PKG_CONFIG = "1"
export BZIP2_SYS_USE_PKG_CONFIG = "1"

# Tell rust cc crate to use native compiler for host dependencies
# eg. CC_(triple) takes priority over normal CC in this context.
RUST_BUILD_SYS_UNDERSCORE = "${@d.getVar('RUST_BUILD_SYS').replace('-','_')}"
export CC_${RUST_BUILD_SYS_UNDERSCORE} = "${RUST_BUILD_CC}"
export CXX_${RUST_BUILD_SYS_UNDERSCORE} = "${RUST_BUILD_CXX}"
export AR_${RUST_BUILD_SYS_UNDERSCORE} = "${BUILD_AR}"
export CFLAGS_${RUST_BUILD_SYS_UNDERSCORE} = "${BUILD_CFLAGS}"
export CXXFLAGS_${RUST_BUILD_SYS_UNDERSCORE} = "${BUILD_CXXFLAGS}"

export AWS_LC_SYS_CMAKE_BUILDER = "1"

# Compile NASM instead of using prebuilt (packaged?) versions https://crane.dev/faq/cross-compiling-aws-lc-sys.html 
# export AWS_LC_SYS_PREBUILT_NASM = "0"

do_configure:prepend() {
    cat > ${WORKDIR}/oe-with-pthread.cmake << EOF
# Pull in everything Yocto already knows about this target
include("${STAGING_DATADIR_NATIVE}/cmake/OEToolchainConfig.cmake")

set(CMAKE_SYSTEM_PROCESSOR "${TARGET_ARCH}" CACHE STRING "" FORCE)

# Don't try and execute cross compiled pthead, mark as already avail and skip check
set(CMAKE_HAVE_LIBC_PTHREAD 0 CACHE BOOL "" FORCE)
set(CMAKE_THREAD_LIBS_INIT "-lpthread" CACHE STRING "" FORCE)
set(THREADS_PTHREAD_ARG "2" CACHE STRING "" FORCE)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wno-unused-command-line-argument -ffile-prefix-map=${WORKDIR}/sources/cargo_home=/usr/src/debug/${PN}/${PV}" CACHE STRING "" FORCE)
EOF
}

export CMAKE_TOOLCHAIN_FILE = "${WORKDIR}/oe-with-pthread.cmake"


DEPENDS += " \
    glib-2.0 \
    cmake-native \
    nasm-native \
    pkgconfig-native \
    protobuf-c-native \
    libstd-rs \
    nlohmann-json \
    libwebsockets \
    python3 \
    bzip2 \
    zstd \
    openssl \
    openssl-native \
"

RDEPENDS:${FOXGLOVE_LIB_PREFIX}-c = " \
    nlohmann-json \
    libwebsockets \
    python3 \
    bzip2 \
    zstd \
"



DEPENDS += "libwebrtc-rs"
export LK_CUSTOM_WEBRTC = "${STAGING_LIBDIR}/livekit-webrtc"


export PYO3_CROSS_PYTHON_VERSION = "${PYTHON_BASEVERSION}"
export PYO3_CROSS_LIB_DIR = "${STAGING_LIBDIR}"

# Yocto doesn't prefix-map cargo registry cache (used by cc crate)
CFLAGS:append = " -ffile-prefix-map=${WORKDIR}/sources/cargo_home=/usr/src/debug/${PN}/${PV}"
CXXFLAGS:append = " -ffile-prefix-map=${WORKDIR}/sources/cargo_home=/usr/src/debug/${PN}/${PV}"

# foxglove_proto_gen embeds its CARGO_MANIFEST_DIR via env!()
# into a const string literal
INSANE_SKIP:foxglove-sdk += "buildpaths"

do_install:append() {
    # shared lib
    install -d ${D}${libdir}
    install -m 0755 ${B}/target/${CARGO_TARGET_SUBDIR}/libfoxglove.so ${D}${libdir}/libfoxglove.so

    # python lib
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    install -m 0755 ${B}/target/${CARGO_TARGET_SUBDIR}/libfoxglove_py.so \
        ${D}${PYTHON_SITEPACKAGES_DIR}/libfoxglove_py.so

    # c api headers
    install -d ${D}${includedir}/foxglove-c
    install -m 0644 ${S}/c/include/foxglove-c/foxglove-c.h ${D}${includedir}/foxglove-c/

    # cxx api headers
    install -d ${D}${includedir}/foxglove
    cp -r ${S}/cpp/foxglove/include/foxglove/. ${D}${includedir}/foxglove/
    install -d ${D}${includedir}/foxglove_data_loader
    cp -r ${S}/cpp/foxglove_data_loader/include/foxglove_data_loader/. \
        ${D}${includedir}/foxglove_data_loader/
}

# set rdepends for child packages in this recipe
RDEPENDS:foxglove-sdk-examples = "${FOXGLOVE_LIB_PREFIX}-c"
RDEPENDS:${FOXGLOVE_LIB_PREFIX}-python = "${FOXGLOVE_LIB_PREFIX}-c python3"
RDEPENDS:${FOXGLOVE_LIB_PREFIX}-cxx = "${FOXGLOVE_LIB_PREFIX}-c"