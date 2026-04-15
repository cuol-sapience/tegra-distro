# based on repos/meta-openembedded/meta-oe/recipes-support/spdlog/spdlog_1.17.0.bb

DESCRIPTION = "Very fast, header only, C++ logging library."
HOMEPAGE = "https://github.com/gabime/spdlog/wiki"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bd5cc7fa6ff5ee46fc1047f0f0c895b7"

SRCREV = "eb3220622e73a4889eee355ffa37972b3cac3df5"
SRC_URI = "git://github.com/gabime/spdlog.git;protocol=https;branch=v1.x;tag=v${PV}"

inherit cmake

# no need to build example & tests & benchmarks on pure yocto
EXTRA_OECMAKE += "\
    -DCMAKE_INSTALL_PREFIX=/opt/${PN}/${PV} \
    -DSPDLOG_INSTALL=on \
    -DSPDLOG_BUILD_SHARED=on \
    -DSPDLOG_BUILD_EXAMPLE=off \
    -DSPDLOG_FMT_EXTERNAL=off \
"

BBCLASSEXTEND = "native"


SYSROOT_DIRS += "/opt/${PN}/${PV}"

FILES:${PN} = "\
    /opt/${PN}/${PV}/lib/libspdlog.so.* \
"

FILES:${PN}-dev = "\
    /opt/${PN}/${PV}/lib/libspdlog.so \
    /opt/${PN}/${PV}/lib/cmake \ 
    /opt/${PN}/${PV}/lib/pkgconfig \
    /opt/${PN}/${PV}/include/ \
"

FILES:${PN}-staticdev = ""
