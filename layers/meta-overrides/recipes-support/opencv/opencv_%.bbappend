inherit cuda-available

do_install:append() {
    # Find the OpenCVConfig.cmake file in the installation directory
    CONFIG_FILE="${D}${libdir}/cmake/opencv4/OpenCVConfig.cmake"

    if [ -f "$CONFIG_FILE" ]; then
        # Comment out the line that forces a CUDA search
        sed -i 's/^find_package(CUDA/ # find_package(CUDA/g' "$CONFIG_FILE"
        sed -i 's/^find_host_package(CUDA/ # find_host_package(CUDA/g' "$CONFIG_FILE"
    fi
}

