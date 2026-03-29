do_install:append() {
    ln -sf libglxserver_nvidia.so  \
        ${D}${libdir}/xorg/modules/extensions/libglx.so
}