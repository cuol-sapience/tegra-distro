DESCRIPTION = "NVBlox ROS 2 interface — 3D reconstruction for robotic applications"
HOMEPAGE = "https://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nvblox"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit ros_distro_humble
inherit cuda-available

ROS_CN = "nvblox-ros"
ROS_BPN = "nvblox_ros"

PV = "4.4.0"

# Tag v4.4-0 in the upstream repo
SRCREV = "e3fbaea70d34ec60830f77322cda5b4b269f7b1c"
SRC_URI = " \
    git://github.com/NVIDIA-ISAAC-ROS/isaac_ros_nvblox.git;branch=main;protocol=https;nobranch=1;destsuffix=git/isaac_ros_nvblox \
    file://0001-use-system-nvblox.patch;patchdir=${UNPACKDIR}/git/isaac_ros_nvblox/nvblox_ros \
"

# nvblox_ros lives in a subdirectory of the monorepo
S = "${UNPACKDIR}/git/isaac_ros_nvblox/nvblox_ros"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    gflags \
    glog \
    isaac-ros-common \
    isaac-ros-gxf \
    isaac-ros-managed-nitros \
    isaac-ros-nitros-camera-info-type \
    isaac-ros-nitros-image-type \
    libstatistics-collector \
    message-filters \
    nav-msgs \
    nvblox \
    nvblox-msgs \
    nvblox-ros-common \
    rclcpp \
    rclcpp-components \
    rosbag2-cpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-eigen \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    isaac-ros-gxf \
    isaac-ros-managed-nitros \
    libstatistics-collector \
    message-filters \
    nav-msgs \
    nvblox \
    nvblox-msgs \
    nvblox-ros-common \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-eigen \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    isaac-ros-gxf \
    isaac-ros-managed-nitros \
    libstatistics-collector \
    message-filters \
    nav-msgs \
    nvblox \
    nvblox-msgs \
    nvblox-ros-common \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-eigen \
    tf2-ros \
    visualization-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

EXTRA_OECMAKE += " \
    -DCMAKE_NO_SYSTEM_FROM_IMPORTED=ON \
"

TARGET_CXXFLAGS:append = " -Wno-template-body "

FILES:${PN} += " \
    /opt/ros/humble/lib/*.so \
    /opt/ros/humble/lib/${ROS_BPN}/* \
"

FILES:${PN}-dev = " \
    /opt/ros/humble/include/* \
    /opt/ros/humble/share/${ROS_BPN}/cmake/* \
"

INSANE_SKIP:${PN} += "buildpaths"
INSANE_SKIP:${PN}-dev += "buildpaths"
INSANE_SKIP:${PN}-dbg += "buildpaths"
