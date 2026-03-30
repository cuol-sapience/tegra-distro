DESCRIPTION = "gui package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    packagegroup-gnome-desktop \
    packagegroup-gnome-apps \
    packagegroup-core-x11-xserver \
    xwayland \
    xauth \
    xrandr \
    xdpyinfo \
    gdm \
"