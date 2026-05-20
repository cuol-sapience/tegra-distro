require isaac-ros-nitros.inc

DESCRIPTION = "Isaac ROS GXF framework integration"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros"

ROS_CN = "isaac-ros-gxf"
ROS_BPN = "isaac_ros_gxf"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-fix-cross-compile-arch-detection.patch;patchdir=${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_gxf"

S = "${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_gxf"

ROS_BUILD_DEPENDS = " \
    isaac-ros-common \
    magic-enum \
    ucx \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-auto-native \
"

ROS_EXEC_DEPENDS = " \
    magic-enum \
    ucx \
    numactl \
    python3 \
    cuda-cudart \
    libnpp \
    libcublas \
    tegra-libraries-nvsci \
    cuda-nvtx \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

# Pre-built GXF .so files have no versioned soname — keep them in the main package
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${libdir}/lib*${SOLIBSDEV} \
"

# meta-tegra CUDA packages install to /usr/local/cuda-*/ and don't register
# in the OE shlibs database, so file-rdeps is a false negative here.
# GXF libs are also installed to both ${libdir} and share/.../gxf/lib/, causing
# duplicate shlib provider entries — exclude this package from shlibs tracking.
EXCLUDE_FROM_SHLIBS = "1"
INSANE_SKIP:${PN} += "file-rdeps"
INSANE_SKIP:${PN}-dev += "dev-elf"
