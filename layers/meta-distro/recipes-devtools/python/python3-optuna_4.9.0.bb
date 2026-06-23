SUMMARY = "A hyperparameter optimization framework"
HOMEPAGE = "https://pypi.org/project/optuna/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=67c2fc2ce50dfba96a2c5c1efdf60c2f"

PYPI_PACKAGE = "optuna"

inherit pypi setuptools3

SRC_URI[sha256sum] = "b322e5cbdf1655fb84c37646c4a7a1f391de1b47806bbe222e015825d0a82b87"

RDEPENDS:${PN} += " \
    python3-alembic \
    python3-colorlog \
    python3-numpy \
    python3-packaging \
    python3-pyyaml \
    python3-sqlalchemy \
    python3-tqdm \
"
