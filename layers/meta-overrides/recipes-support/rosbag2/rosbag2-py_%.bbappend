# https://github.com/ros/meta-ros/issues/1428#issuecomment-3008615073

do_install:append() {
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}

    for f in $(find ${D}${PYTHON_SITEPACKAGES_DIR} -name "*x86_64*"); do
        new_f=$(echo "$f" | sed 's/x86_64/aarch64/')
        install -D "$f" "$new_f"
        rm "$f"
    done
}