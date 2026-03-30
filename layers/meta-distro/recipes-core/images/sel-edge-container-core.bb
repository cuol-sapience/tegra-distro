require sel-edge-image-core.bb

include container-base.bb

SUMMARY = "Core SEL container"

# entrypoint
CONTAINER_APP_CMD ?= "/usr/bin/bash"

# packages
CONTAINER_APP ?= "bash"

OCI_IMAGE_ENTRYPOINT = "${CONTAINER_APP_CMD}"
IMAGE_INSTALL:append = " ${CONTAINER_APP}"

OCI_IMAGE_USER = "sapience"