inherit cuda
DEPENDS:append:jetson-orin-nano-devkit = " cuda-toolkit"

# rosidl_runtime_cpp throws deprecated declarations error on gcc 15+
CXXFLAGS:append = " -Wno-error=deprecated-declarations"