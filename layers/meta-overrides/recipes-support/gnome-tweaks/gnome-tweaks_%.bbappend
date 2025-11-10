do_install:append() {
    find ${D} -type f -name "*.pyc" -print0 | xargs -0 sed -i "s:${TMPDIR}::g";
}