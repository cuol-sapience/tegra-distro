# SUMMARY = "TBD"
DESCRIPTION = "Multimedia package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"

SEL_MULTIMEDIA_PACKAGES = " \
    v4l-utils \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    vim-xxd \
"

RDEPENDS:${PN} = "${SEL_MULTIMEDIA_PACKAGES}"

RDEPENDS:${PN}-staticdev = "\
    gstreamer1.0-plugins-base-staticdev \
    gstreamer1.0-plugins-ugly-staticdev \
    gstreamer1.0-plugins-bad-staticdev \
    gstreamer1.0-plugins-good-staticdev \
"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_MULTIMEDIA_PACKAGES').split())}"

# gstreamer1.0-plugins-tegra is a metapackage for all tegra gstreamer plugins
RDEPENDS:${PN}:append:jetson-orin-nano-devkit = " \
    tegra-argus-daemon \
    tegra-mmapi \
    tegra-libraries-camera \
    gstreamer1.0-plugins-tegra \
    ar0234-mipi-nvidia \
"