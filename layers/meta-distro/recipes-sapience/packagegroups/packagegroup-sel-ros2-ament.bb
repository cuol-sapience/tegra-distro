# SUMMARY = "TBD"
DESCRIPTION = "ament package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"


RDEPENDS:${PN} = "\
    ament-cmake-auto \
	ament-cmake-core \
	ament-cmake-export-definitions \
	ament-cmake-export-dependencies \
	ament-cmake-export-include-directories \
	ament-cmake-export-interfaces \
	ament-cmake-export-libraries \
	ament-cmake-export-link-flags \
	ament-cmake-export-targets \
	ament-cmake-gen-version-h \
	ament-cmake-gmock \
	ament-cmake-google-benchmark \
	ament-cmake-gtest \
	ament-cmake-include-directories \
	ament-cmake-libraries \
	ament-cmake-nose \
	ament-cmake-pytest \
	ament-cmake-python \
	ament-cmake-target-dependencies \
	ament-cmake-test \
	ament-cmake-version \
	ament-cmake \
	ament-cmake-catch2 \
	ament-cmake-ros \
	ament-download \
	ament-index-cpp \
	ament-index-python \
	ament-cmake-copyright \
	ament-cmake-cppcheck \
	ament-cmake-cpplint \
	ament-cmake-flake8 \
	ament-cmake-lint-cmake \
	ament-cmake-mypy \
	ament-cmake-pclint \
	ament-cmake-pep257 \
	ament-cmake-pycodestyle \
	ament-cmake-pyflakes \
	ament-cmake-xmllint \
	ament-copyright \
	ament-cppcheck \
	ament-cpplint \
	ament-flake8 \
	ament-lint-auto \
	ament-mypy \
	ament-pclint \
	ament-pep257 \
	ament-pyflakes \
	ament-xmllint \
	ament-nodl \
	ament-package \
"