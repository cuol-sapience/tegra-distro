DESCRIPTION = "Prebuilt libwebrtc for LiveKit"
HOMEPAGE = "https://github.com/livekit/rust-sdks/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"


PV = "144.0+7af9351"

WEBRTC_TAG = "webrtc-7af9351"

WEBRTC_ARCH = "${@'arm64' if d.getVar('TARGET_ARCH') == 'aarch64' else 'x64'}"
WEBRTC_TRIPLE = "linux-${WEBRTC_ARCH}-release"

SRC_URI += "https://github.com/livekit/rust-sdks/releases/download/${WEBRTC_TAG}/webrtc-${WEBRTC_TRIPLE}.zip;name=webrtc-prebuilt;subdir=webrtc-prebuilt"

WEBRTC_PREBUILT_SHA256:aarch64 = "4e8cad5b00c75c0a19717b28bc96c17da852c7dbbe9163bd5ab32ae150304665"
WEBRTC_PREBUILT_SHA256 = ""

SRC_URI[webrtc-prebuilt.sha256sum] = "${WEBRTC_PREBUILT_SHA256}"

do_configure[noexec] = "1"
do_compile[noexec]   = "1"


S = "${UNPACKDIR}"

do_install() {
    install -d "${D}${libdir}/livekit-webrtc/lib"
    install -m 0644 \
        "${UNPACKDIR}/webrtc-prebuilt/${WEBRTC_TRIPLE}/lib/libwebrtc.a" \
        "${D}${libdir}/livekit-webrtc/lib/"

    for f in webrtc.ninja desktop_capture.ninja; do
        [ -f "${UNPACKDIR}/webrtc-prebuilt/${WEBRTC_TRIPLE}/${f}" ] && \
        install -m 0644 \
            "${UNPACKDIR}/webrtc-prebuilt/${WEBRTC_TRIPLE}/${f}" \
            "${D}${libdir}/livekit-webrtc/"
    done

    # Copy headers for downstream cxx-build compilation
    cp -r "${UNPACKDIR}/webrtc-prebuilt/${WEBRTC_TRIPLE}/include" \
          "${D}${libdir}/livekit-webrtc/"
}

FILES:${PN}-dev = "\
    ${libdir}/livekit-webrtc/include/ \
    ${libdir}/livekit-webrtc/webrtc.ninja \
    ${libdir}/livekit-webrtc/desktop_capture.ninja \
"

FILES:${PN}-staticdev = "\
    ${libdir}/livekit-webrtc/lib/ \
"

ALLOW_EMPTY:${PN} = "1"