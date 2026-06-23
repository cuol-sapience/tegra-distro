DESCRIPTION = "A header-only C++11 serialization library."
HOMEPAGE = "https://uscilab.github.io/cereal/"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4921372a1fb38469e667c38b17a1c4b3"

# d81e2f7 is the master commit pinned by ripple's lib/cereal.cmake (Mar 6, 2026)
SRCREV = "d81e2f7df7b334fee057e53017388d02e555a836"
SRC_URI = "git://github.com/USCiLab/cereal.git;branch=master;protocol=https"

PV = "1.3.2+git"

inherit cmake

DEPENDS = " \
    boost \
"

EXTRA_OECMAKE += " \
    -DCEREAL_INSTALL=ON \
    -DBUILD_SANDBOX=OFF \
    -DBUILD_DOC=OFF \
    -DBUILD_TESTS=OFF \
"

ALLOW_EMPTY:${PN} = "1"
