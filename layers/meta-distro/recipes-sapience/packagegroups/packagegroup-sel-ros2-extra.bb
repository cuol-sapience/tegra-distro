# SUMMARY = "TBD"
DESCRIPTION = "package group of software commonly used with ros"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_ROS2_EXTRA_PACKAGES = "\
	python3-distlib \
	python3-empy \
	python3-flake8 \
	python3-ifcfg \
	python3-lark-parser \
	python3-nose-yanc \
	python3-pyassimp \
	python3-pydocstyle \
	python3-pygraphviz \
	python3-pyproj \
	python3-pytest-cov \
	python3-pytest-mock \
	foonathan-memory \
	python3-construct \
	python3-whichcraft \
	python-cmake-module \
	topic-monitor \
	topic-statistics-demo \
	examples-rclcpp-minimal-publisher \
	examples-rclcpp-minimal-subscriber \
	topic-tools \
"

RDEPENDS:${PN} = "${SEL_ROS2_EXTRA_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_ROS2_EXTRA_PACKAGES').split())}"
