# (ros)-recipes-core | this requires core-image-minimal
require sapience-image-minimal.bb

SUMMARY = "Sapience Image with GNOME"

#EXTRA_IMAGE_FEATURES:append = " x11-base"

IMAGE_INSTALL:append = " packagegroup-gnome-desktop gdm"