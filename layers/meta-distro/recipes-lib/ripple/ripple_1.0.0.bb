DESCRIPTION = "Ripple - QUIC-based transport library."
HOMEPAGE = "https://github.com/jcxldn/ripple"

LICENSE = "CLOSED"

SRCREV = "7966e594f50ea7f5c4e7acc84269c057243dbe2c" # v1.0.0 24/06/26
SRC_URI = " \
    git://github.com/jcxldn/ripple.git;branch=main;protocol=https \
"

inherit cmake

DEPENDS = " \
    msquic \
    boost \
    spdlog \
    fmt \
    cereal \
"

EXTRA_OECMAKE += " \
    -DRIPPLE_USE_EXTERNAL_MSQUIC=ON \
    -DRIPPLE_USE_EXTERNAL_BOOST=ON \
    -DRIPPLE_USE_EXTERNAL_SPDLOG=ON \
    -DRIPPLE_USE_EXTERNAL_CEREAL=ON \
    -DRIPPLE_BUILD_SHARED=ON \
    -DRIPPLE_BUILD_TEST=OFF \
    -DRIPPLE_BUILD_DEMO=OFF \
"

FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${libdir}/*.so \
    ${libdir}/ripple_demo \
"