# SUMMARY = "TBD"
DESCRIPTION = "rcl package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = "\
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