TOOLCHAIN = "clang"
TOOLCHAIN_NATIVE = "clang"


inherit cargo pkgconfig
# cuda-available

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


# Setup a toolchain for rust to compile eg. aws-lc with 
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


# Yocto doesn't prefix-map cargo registry cache (used by cc crate)
CFLAGS:append = " -ffile-prefix-map=${WORKDIR}/sources/cargo_home=/usr/src/debug/${PN}/${PV}"
CXXFLAGS:append = " -ffile-prefix-map=${WORKDIR}/sources/cargo_home=/usr/src/debug/${PN}/${PV}"