SUMMARY = "Symbolic API for model creation in PyTorch"
HOMEPAGE = "https://pypi.org/project/pytorch-symbolic/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0b59d2f5816361ac96e666fa9f7fa024"

PYPI_PACKAGE = "pytorch_symbolic"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "c21d696436bebad2ca5f079ea8ed797df96d9f942875c55ffc97dce246360940"

RDEPENDS:${PN} += "pytorch"
