require sel-edge-image-core.bb

SUMMARY = "SEL image with GNOME"

IMAGE_INSTALL:append = " packagegroup-sel-gui"

# use 'sel-switch-desktop' alias command to jump to graphical target 
# SYSTEMD_DEFAULT_TARGET = "graphical.target"
