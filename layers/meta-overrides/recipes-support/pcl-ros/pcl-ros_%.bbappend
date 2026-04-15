FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://0001-fix-usr-include-leakage.patch \
"

do_install:append:class-target() {
    local cmake_dir="${D}/opt/ros/humble/share/pcl_ros/cmake"

    find "${cmake_dir}" -name "*.cmake" -type f -exec \
        sed -i -E \
            -e 's#'"${UNPACKDIR}"'[^;"'\'' ]*;?##g' \
            -e 's#'"${RECIPE_SYSROOT}"'[^;"'\'' ]*;?##g' \
            -e 's#'"${TMPDIR}"'[^;"'\'' ]*;?##g' \
            -e 's#'"${WORKDIR}"'/sources/[^;"'\'' ]*;?##g' \
            {} \;

}