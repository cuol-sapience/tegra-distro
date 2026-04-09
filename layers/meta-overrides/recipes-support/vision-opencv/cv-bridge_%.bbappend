inherit cuda
DEPENDS:append = " opencv"
DEPENDS:append:jetson-orin-nano-devkit = " cuda-toolkit"

RDEPENDS:${PN}:append:jetson-orin-nano-devkit = " cuda-toolkit"