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
     rosbag2 \
     rosbag2-compression \
     rosbag2-compression-zstd \
     rosbag2-cpp \
     rosbag2-interfaces \
     rosbag2-performance-benchmarking \
     rosbag2-py \
     rosbag2-storage \
     rosbag2-storage-broll \
     rosbag2-storage-default-plugins \
     rosbag2-storage-mcap \
     rosbag2-storage-mcap-testdata \
     rosbag2-test-common \
     rosbag2-tests \
     rosbag2-to-video \
     rosbag2-transport \
     rosbag2rawlog \
"


RDEPENDS:${PN} = "\
     ros-core \
     ros-base \
     micro-xrce-dds-agent \
     fastdds \
     fastrtps \
     cyclonedds \
     packagegroup-sel-ros2-ament \
     packagegroup-sel-ros2-colcon \
     packagegroup-sel-ros2-extra \
     packagegroup-sel-ros2-flir \
     packagegroup-sel-ros2-msgs \
     packagegroup-sel-ros2-ouster \
     packagegroup-sel-ros2-rcl \
     packagegroup-sel-ros2-rosdep \
     packagegroup-sel-ros2-rosidl \
     foxglove-bridge \
     foxglove-msgs \
     ros-environment \
     ros-workspace \
     ${ROS2_PKG_CAMERA} \
     ${ROS2_PKG_CLI} \
"