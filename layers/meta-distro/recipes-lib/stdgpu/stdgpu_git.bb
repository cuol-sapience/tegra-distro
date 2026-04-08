DESCRIPTION = "stdgpu is an open-source library providing generic GPU data structures for fast and reliable data management."
HOMEPAGE = "https://github.com/stotko/stdgpu"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"


# Latest at 2026-04-08T07:58:39+0000
SRCREV = "d1e6232406a1726051201686ff7661552330276d"
SRC_URI = "git://github.com/stotko/stdgpu.git;branch=master;protocol=https"

inherit cmake cuda


PV = "1.3.0"

EXTRA_OECMAKE += " -DSTDGPU_BUILD_TESTS=OFF -DSTDGPU_BUILD_BENCHMARKS=OFF"

# TODO: use OpenMP backend when CUDA not available?...