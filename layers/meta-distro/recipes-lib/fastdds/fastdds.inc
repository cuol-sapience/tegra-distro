DESCRIPTION = "CDR serialization library"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

# use our packaged fastcdr2
DEPENDS = " asio fastcdr2 foonathan-memory-vendor libtinyxml2 openssl python3"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DCOMPILE_TOOLS=OFF \
    "
