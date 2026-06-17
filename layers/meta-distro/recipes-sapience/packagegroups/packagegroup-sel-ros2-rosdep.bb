# SUMMARY = "TBD"
DESCRIPTION = "rosdep package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_ROS2_ROSDEP_PACKAGES = "\
	python-rosdep-data \
	python3-rosdep \
	python3-rosdistro \
	python3-rospkg \
"

RDEPENDS:${PN} = "${SEL_ROS2_ROSDEP_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_ROS2_ROSDEP_PACKAGES').split())}"
