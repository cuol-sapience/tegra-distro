inherit cuda
DEPENDS:append = " opencv"
DEPENDS:append:jetson-orin-nano-devkit = " cuda-toolkit"

RDEPENDS:${PN}:jetson-orin-nano-devkit:append = " cuda-toolkit"