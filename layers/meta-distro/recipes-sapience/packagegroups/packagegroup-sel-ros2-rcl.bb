# SUMMARY = "TBD"
DESCRIPTION = "rcl package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_ROS2_RCL_PACKAGES = "\
	rcl-interfaces \
	rcl-logging-interface \
	rcl-logging-noop \
	rcl-logging-spdlog \
	rclcpp-action \
	rclcpp-components \
	rclcpp-lifecycle \
	rclcpp \
	rclpy \
	rcpputils \
	rcutils \
	rcl-yaml-param-parser \
	rcl \
"

RDEPENDS:${PN} = "${SEL_ROS2_RCL_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_ROS2_RCL_PACKAGES').split())}"
