do_install:append() {
    # Fix Exec/TryExec paths in gnome-xorg.desktop
    if [ -f ${D}${datadir}/xsessions/gnome-xorg.desktop ]; then
        sed -i \
            -e 's|^Exec=/usr/bin/gnome-session|Exec=/bin/gnome-session|' \
            -e 's|^TryExec=/usr/bin/gnome-session|TryExec=/bin/gnome-session|' \
            ${D}${datadir}/xsessions/gnome-xorg.desktop
    fi
}