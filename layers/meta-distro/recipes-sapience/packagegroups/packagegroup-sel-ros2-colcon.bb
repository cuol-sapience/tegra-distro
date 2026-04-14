# SUMMARY = "TBD"
DESCRIPTION = "colcon package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = "\
	python3-colcon-bash \
	python3-colcon-cd \
	python3-colcon-cmake \
	python3-colcon-common-extensions \
	python3-colcon-core \
	python3-colcon-defaults \
	python3-colcon-devtools \
	python3-colcon-library-path \
	python3-colcon-metadata \
	python3-colcon-output \
	python3-colcon-package-information \
	python3-colcon-package-selection \
	python3-colcon-parallel-executor \
	python3-colcon-pkg-config \
	python3-colcon-python-setup-py \
	python3-colcon-recursive-crawl \
	python3-colcon-ros \
	python3-colcon-test-result \
"