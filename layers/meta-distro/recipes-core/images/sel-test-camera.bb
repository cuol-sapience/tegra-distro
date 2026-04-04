
require ${COREBASE}/meta/recipes-core/images/core-image-minimal.bb


SUMMARY = "TEST IMAGE"
DESCRIPTION = "${SUMMARY}"
LICENSE = "MIT"

IMAGE_INSTALL:append = "\
    ${MACHINE_EXTRA_RRECOMMENDS} \
    networkmanager-nmcli \
    packagegroup-sel-utils \
    v4l-utils \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-nvvidconv \
    vim-xxd \
    tegra-argus-daemon \
    tegra-mmapi \
    tegra-libraries-camera \
    gstreamer1.0-plugins-tegra \
    ar0234-mipi-nvidia \
    "