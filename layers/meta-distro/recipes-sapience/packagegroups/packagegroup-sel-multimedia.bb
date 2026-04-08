# SUMMARY = "TBD"
DESCRIPTION = "Multimedia package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = " \
    v4l-utils \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-ugly \
    vim-xxd \
"


# gstreamer1.0-plugins-tegra is a metapackage for all tegra gstreamer plugins
RDEPENDS:${PN}:jetson-orin-nano-devkit:append  = " \
    tegra-argus-daemon \
    tegra-mmapi \
    tegra-libraries-camera \
    gstreamer1.0-plugins-tegra \
    ar0234-mipi-nvidia \
"