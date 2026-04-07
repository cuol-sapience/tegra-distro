DESCRIPTION = "gui package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


PACKAGES = "${PN}"

SEL_GUI_DE_RDEPENDS = "\
    packagegroup-gnome-desktop \
    packagegroup-gnome-apps \
    packagegroup-core-x11-xserver \
    xwayland \
    xauth \
    xrandr \
    xdpyinfo \
    gdm \
"

SEL_GUI_SOUND_RDEPENDS = "\
    pipewire \
    pipewire-pulse \
    pipewire-alsa \
    wireplumber \
    alsa-utils \
    alsa-plugins \
    alsa-ucm-conf \
    alsa-topology-conf \
    pavucontrol \
    pipewire-tools \
"

SEL_GUI_APPS_RDEPENDS = "\
    xeyes \
    mesa-demos \
    firefox \
    vlc \
"

RDEPENDS:${PN} = "\
    ${SEL_GUI_DE_RDEPENDS} \
    ${SEL_GUI_SOUND_RDEPENDS} \
    ${SEL_GUI_APPS_RDEPENDS} \
"