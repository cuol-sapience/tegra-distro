# Don't attempt to build with ROCm for nvidia SoC!
EXTRA_OECMAKE:append:jetson-orin-nano-devkit = " -DUSE_ROCM=OFF "