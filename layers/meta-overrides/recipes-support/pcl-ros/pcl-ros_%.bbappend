FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://0001-fix-usr-include-leakage.patch \
"

# Fix CMake exported targets containing recipe-sysroot paths
do_install:append:class-target() {
    # Strip recipe-sysroot from all CMake config files
    find ${D}/opt/ros/humble/share/pcl_ros/cmake/ -name "*.cmake" -type f -exec \
        sed -i \
        -e "s#${RECIPE_SYSROOT}##g" \
        -e "s#${TMPDIR}##g" \
        -e "s#${WORKDIR}##g" \
        -e "s#/usr/lib/lib[^;]*\.so##g" \
        -e "s#;/opt/ros/humble/lib/[^;]*\.so;\([^;]*\);\([^;]*\)#\1;\2#g" \
        -e "s#/usr/include/pcl[^;]*;;*/usr/include/eigen3[^;]*;;*/usr/include[^;]*;;*##g" \
        {} \;

    # Replace sysroot paths with ${_IMPORT_PREFIX} for proper relocation
    sed -i \
        -e "s#${RECIPE_SYSROOT}/usr#\${\$_IMPORT_PREFIX}/usr#g" \
        ${D}/opt/ros/humble/share/pcl_ros/cmake/export_pcl_rosExport.cmake || true
}