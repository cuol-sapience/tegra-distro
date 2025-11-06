DESCRIPTION = "CDR serialization library"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

# package license file
FILES:${PN}:append = " /usr/share/fastcdr/LICENSE"

S = "${WORKDIR}/git"

inherit cmake