inherit cuda-available

do_install:append() {
    # Find the OpenCVConfig.cmake file in the installation directory
    CONFIG_FILE="${D}${libdir}/cmake/opencv4/OpenCVConfig.cmake"

    sed -i 's/^\([[:space:]]*\)find_package(CUDA/\1# find_package(CUDA/g' "$CONFIG_FILE"
    sed -i 's/^\([[:space:]]*\)find_host_package(CUDA/\1# find_host_package(CUDA/g' "$CONFIG_FILE"
}

