# SUMMARY = "TBD"
DESCRIPTION = "ros2 package group"

PV = "1.0.0"

inherit packagegroup

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


ROS2_PKG_CLI = "\
     ros2cli-common-extensions \
     ros2bag \
"


RDEPENDS:${PN} = "\
     ros-core \
     ros-base \
     micro-xrce-dds-agent \
     fastrtps \
     cyclonedds \
     packagegroup-sel-ros2-ament \
     packagegroup-sel-ros2-colcon \
     packagegroup-sel-ros2-flir \
     packagegroup-sel-ros2-ouster \
     packagegroup-sel-ros2-rcl \
     packagegroup-sel-ros2-rosdep \
     packagegroup-sel-ros2-rosidl \
     foxglove-bridge \
     foxglove-msgs \
     common-interfaces \
     ros-environment \
     ros-workspace \
     topic-monitor \
     ${ROS2_PKG_CAMERA} \
     ${ROS2_PKG_CLI} \
"