EXTRA_OECMAKE += "-DCMAKE_POLICY_VERSION_MINIMUM=3.5"

do_install:append() {
    sed -i \
        -e 's#${S}/include#${includedir}#g' \
        -e 's#${WORKDIR}/sources/${BP}/include#${includedir}#g' \
        ${D}${libdir}/cmake/libtins/libtinsConfig.cmake
        
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${libdir}/cmake/libtins/libtinsConfig.cmake
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${libdir}/cmake/libtins/libtinsTargets.cmake
}