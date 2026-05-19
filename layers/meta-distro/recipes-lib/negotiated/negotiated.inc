# Shared settings for packages from osrf/negotiated repo (no release tags)

SRCREV = "eac198b55dcd052af5988f0f174902913c5f20e7"
SRC_URI = "git://github.com/osrf/negotiated.git;branch=master;protocol=https;destsuffix=git/negotiated"

inherit ros_distro_humble

PV = "0.1.0+git"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

EXTRA_OECMAKE += "-DCMAKE_NO_SYSTEM_FROM_IMPORTED=ON"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-dbg += "buildpaths"
