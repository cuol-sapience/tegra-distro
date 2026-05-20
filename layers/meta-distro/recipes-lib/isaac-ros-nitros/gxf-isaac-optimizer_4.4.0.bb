require isaac-ros-nitros.inc

DESCRIPTION = "GXF Isaac optimizer extension (graph optimization for NITROS)"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nitros"

ROS_CN = "gxf-isaac-optimizer"
ROS_BPN = "gxf_isaac_optimizer"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0003-optimizer-cross-compile.patch;patchdir=${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_gxf_extensions/gxf_isaac_optimizer"

S = "${UNPACKDIR}/git/isaac_ros_nitros/isaac_ros_gxf_extensions/gxf_isaac_optimizer"

ROS_BUILD_DEPENDS = " \
    isaac-ros-gxf \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-auto-native \
"

ROS_EXEC_DEPENDS = " \
    isaac-ros-gxf \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${libdir}/lib*${SOLIBSDEV} \
"

INSANE_SKIP:${PN} += "buildpaths libdir file-rdeps"
INSANE_SKIP:${PN}-dev += "buildpaths dev-elf"
EXCLUDE_FROM_SHLIBS = "1"
