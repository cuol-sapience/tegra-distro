inherit cuda
DEPENDS:append:jetson-orin-nano-devkit = " cuda-toolkit"

# rosidl_runtime_cpp throws deprecated declarations error on gcc 15+
CXXFLAGS:append = " -Wno-error=deprecated-declarations"

# workaround for tmpdir/workdir in .cmake files causing package QA to fail
do_install:append() {
    sed -i "s:${WORKDIR}::g" ${D}/opt/ros/humble/share/camera_ros/cmake/*.cmake || true
    sed -i "s:${TMPDIR}::g" ${D}/opt/ros/humble/share/camera_ros/cmake/*.cmake || true
}
