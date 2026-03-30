# recipes-graphics/xorg-xserver/xserver-xorg_%.bbappend
# or drop a file via your image recipe

do_install:append() {
    install -d ${D}${sysconfdir}/X11/xorg.conf.d
    cat > ${D}${sysconfdir}/X11/xorg.conf.d/70-nvidia-socket.conf << EOF
Section "Device"
    Identifier  "Tegra0"
    Driver      "nvidia"
    Option      "AllowEmptyInitialConfiguration" "true"
    Option         "ConnectToAcpid" "false"
    Option      "SidebandSocketPath" "/var/run/nvidia-xdriver/"
EndSection
EOF
}
