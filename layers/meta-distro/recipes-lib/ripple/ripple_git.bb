DESCRIPTION = "Ripple - QUIC-based transport library."
HOMEPAGE = "https://github.com/jcxldn/ripple"

LICENSE = "CLOSED"

SRCREV = "bfa35726dc7de8e04d89ca029b8d64e299742ee9"
SRC_URI = " \
    git://github.com/jcxldn/ripple.git;branch=main;protocol=https \
"

PV = "0.0.1+git"

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
    -DSPDLOG_FMT_EXTERNAL=ON \
"

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"
