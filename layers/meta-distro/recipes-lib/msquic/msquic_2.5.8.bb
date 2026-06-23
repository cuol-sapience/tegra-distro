DESCRIPTION = "Microsoft's cross-platform, open-source implementation of the IETF QUIC protocol."
HOMEPAGE = "https://github.com/microsoft/msquic"

# msquic: MIT; bundled quictls: Apache-2.0
LICENSE = "MIT & Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02 \
    file://submodules/quictls/LICENSE.txt;md5=c75985e733726beaba57bc5253e96d04 \
"

SRC_URI = " \
    git://github.com/microsoft/msquic.git;branch=release/2.5;protocol=https;name=msquic;destsuffix=git/msquic \
    git://github.com/quictls/openssl.git;protocol=https;nobranch=1;name=quictls;destsuffix=git/msquic/submodules/quictls \
"

S = "${UNPACKDIR}/git/msquic"

SRCREV_FORMAT = "msquic_quictls"
SRCREV_msquic = "801b0e958f3e33e9998766c3371c1ca348254650"
SRCREV_quictls = "ff36838bb69801cad56823159a036977bcbe5c75"

PV = "2.5.8"

inherit cmake

# quictls bundles its own static libssl/libcrypto via the classic perl Configure + make
DEPENDS = " \
    perl-native \
"

EXTRA_OECMAKE += " \
    -DQUIC_TLS_LIB=quictls \
    -DCX_PLATFORM=linux \
    -DQUIC_BUILD_TOOLS=OFF \
    -DQUIC_BUILD_TEST=OFF \
    -DQUIC_BUILD_PERF=OFF \
    -DQUIC_ENABLE_LOGGING=OFF \
"

EXTRA_OECMAKE:append:aarch64 = " -DCMAKE_TARGET_ARCHITECTURE=arm64"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-dbg += "buildpaths"
