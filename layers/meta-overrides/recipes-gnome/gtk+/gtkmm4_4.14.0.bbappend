FILESEXTRAPATHS:prepend := "${THISDIR}/gtkmm4:"

SRC_URI:append = " file://gtkmm4-fix-iconpaintable-conflict.patch"