SUMMARY = "Teledyne FLIR Spinnaker SDK"
HOMEPAGE = "https://www.teledynevisionsolutions.com/products/spinnaker-sdk/"
SECTION = "libs"


LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial_spinnaker"

COMPATIBLE_HOST = "(aarch64|arm|x86_64).*-linux"
PACKAGE_ARCH = "${TUNE_PKGARCH}"

SPINNAKER_ARCH:x86-64 = "amd64"
SPINNAKER_ARCH:aarch64 = "arm64"
SPINNAKER_ARCH:arm = "armhf"

SRC_URI = "https://sapience-pkg.csg.ac/spinnaker/spinnaker-${PV}-${SPINNAKER_ARCH}-${SPINNAKER_OS_VERSION}-pkg.tar.gz"
SRC_URI[sha256sum] = "${SPINNAKER_SHA256}"

S = "${UNPACKDIR}/spinnaker-${PV}-${SPINNAKER_ARCH}"

DEPENDS += "dpkg-native"
DEPENDS:append:x86-64 = " intel-oneapi-mkl"

RDEPENDS:${PN} += "libusb1"

INSANE_SKIP:${PN} += "ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install() {
    rm -rf ${UNPACKDIR}/pkgroot
    install -d ${UNPACKDIR}/pkgroot

    for deb in ${S}/*.deb; do
        ${STAGING_BINDIR_NATIVE}/dpkg-deb --fsys-tarfile $deb | \
            tar --no-same-owner -xf - -C ${UNPACKDIR}/pkgroot
    done

    install -d ${D}${libdir}
    install -d ${D}${includedir}/spinnaker
    install -d ${D}${datadir}/spinnaker

    cp -a ${UNPACKDIR}/pkgroot/opt/spinnaker/include/. ${D}${includedir}/spinnaker/

    find ${UNPACKDIR}/pkgroot/opt/spinnaker/lib -maxdepth 1 -type f,l \
        \( -name 'libSpinnaker*.so*' -o \
           -name 'libG*.so*' -o \
           -name 'lib*Parser*.so*' -o \
           -name 'libLog*.so*' -o \
           -name 'libNodeMapData*.so*' \) \
        -exec cp -a {} ${D}${libdir}/ \;

    if [ -d ${UNPACKDIR}/pkgroot/opt/spinnaker/lib/spinnaker-gentl ]; then
        cp -a ${UNPACKDIR}/pkgroot/opt/spinnaker/lib/spinnaker-gentl ${D}${datadir}/spinnaker/
    fi

    chown -R root:root ${D}${libdir} ${D}${includedir}/spinnaker ${D}${datadir}/spinnaker
}

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES:${PN} += " \
    ${libdir}/libSpinnaker*.so.* \
    ${libdir}/libGCBase_*.so \
    ${libdir}/libGenApi_*.so \
    ${libdir}/libLog_*.so \
    ${libdir}/lib*Parser_*.so \
    ${libdir}/libNodeMapData_*.so \
    ${datadir}/spinnaker \
"

FILES:${PN}-dev += " \
    ${libdir}/libSpinnaker*.so \
    ${includedir}/spinnaker \
"

RDEPENDS:${PN}-dev += "${PN} (= ${EXTENDPKGV})"
