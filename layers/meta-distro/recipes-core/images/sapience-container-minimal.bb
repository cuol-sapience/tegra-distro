# (ros)-recipes-core | this requires core-image-minimal
require sapience-image-minimal.bb

include container-base.bb

SUMMARY = "Sapience Minimal Container"

# entrypoint
CONTAINER_APP_CMD ?= "/usr/bin/bash"

# packages
CONTAINER_APP ?= "bash"

OCI_IMAGE_ENTRYPOINT = "${CONTAINER_APP_CMD}"
IMAGE_INSTALL:append = " ${CONTAINER_APP}"
