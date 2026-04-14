# SUMMARY = "TBD"
DESCRIPTION = "rosdep package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = "\
	python-rosdep-data \
	python3-rosdep \
	python3-rosdistro \
	python3-rospkg \
"