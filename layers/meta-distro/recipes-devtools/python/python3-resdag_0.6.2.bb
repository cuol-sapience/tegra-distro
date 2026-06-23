SUMMARY = "PyTorch-native reservoir computing library with GPU acceleration"
HOMEPAGE = "https://pypi.org/project/resdag/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=80395d87fd5811e48c5deef071ba92be"

PYPI_PACKAGE = "resdag"

inherit pypi python_hatchling

SRC_URI[sha256sum] = "e0cca2ea0a02b2410694314238f601cc417f350716ec46d5be1e47e93dc14e9a"

# hpo: pulls in optuna for hyperparameter optimisation
PACKAGECONFIG ??= "hpo"
PACKAGECONFIG[hpo] = ",,, python3-optuna"

RDEPENDS:${PN} += " \
    python3-graphviz \
    python3-networkx \
    python3-numpy \
    python3-pytorch-symbolic \
    python3-scipy \
    pytorch \
"
