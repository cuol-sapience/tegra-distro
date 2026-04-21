# SUMMARY = "TBD"
DESCRIPTION = "package group of software commonly used with ros"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = "\
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