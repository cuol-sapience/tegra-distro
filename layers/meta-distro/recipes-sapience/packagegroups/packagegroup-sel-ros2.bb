# SUMMARY = "TBD"
DESCRIPTION = "ros2 package group"

PV = "1.0.0"

inherit packagegroup

require conf/ros-distro/include/humble/ros-sdk.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"


PACKAGES = "${PN}"

ROS2_PKG_CAMERA_CALIBRATION = "\
     camera-calibration \
     launch-testing-ament-cmake \
     image-pipeline \
"

ROS2_PKG_CAMERA = "\
     gscam2 \
     ${ROS2_PKG_CAMERA_CALIBRATION} \
     aruco-pose-estimator \
"

RDEPENDS:${PN} = "\
     ros-core \
     micro-xrce-dds-agent \
     cyclonedds \
     packagegroup-sel-ros2-flir \
     packagegroup-sel-ros2-ouster \
     python3-colcon-common-extensions \
     python3-rosdep \
     python3-rosdistro \
     python3-rospkg \
     ${ROS2_PKG_CAMERA} \
     ${ROS_SDK_TARGET_PACKAGES} \
"