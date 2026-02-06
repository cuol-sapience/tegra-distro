# Add your custom field to the generated os-release file
OS_RELEASE_FIELDS:append = " VERSION_SHA"

# Install vendor file to /usr/lib/os-release (nonarch_libdir) and
# make /etc/os-release a relative symlink to it.
do_install:append () {
    # If the base recipe already installed /etc/os-release as a regular file,
    # remove it so we can replace it with the symlink.
    rm -f ${D}${sysconfdir}/os-release

    # Ensure the vendor location exists (usually /usr/lib)
    install -d ${D}${nonarch_libdir}

    # Move the generated file from /etc to /usr/lib if needed.
    # (If your base recipe already installs to nonarch_libdir, this mv is harmless.)
    if [ -f ${D}${sysconfdir}/os-release ]; then
        mv ${D}${sysconfdir}/os-release ${D}${nonarch_libdir}/os-release
    fi

    # Create /etc/os-release -> ../usr/lib/os-release (relative)
    install -d ${D}${sysconfdir}
    ln -rs ${D}${nonarch_libdir}/os-release ${D}${sysconfdir}/os-release
}

# Make sure the package owns both the vendor file and the /etc symlink
FILES:${PN}:append = " ${nonarch_libdir}/os-release ${sysconfdir}/os-release"
