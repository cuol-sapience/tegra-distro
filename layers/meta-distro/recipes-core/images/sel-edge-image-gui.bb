require sel-edge-image-core.bb

SUMMARY = "SEL image with GNOME"

IMAGE_INSTALL:append = " packagegroup-sel-gui"

SYSTEMD_DEFAULT_TARGET = "graphical.target"
