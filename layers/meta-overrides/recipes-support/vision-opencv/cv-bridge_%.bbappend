inherit cuda
DEPENDS:append:jetson-orin-nano-devkit = " cuda-toolkit"

RDEPENDS:${PN}:append:jetson-orin-nano-devkit = " cuda-toolkit"