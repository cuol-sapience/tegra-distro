require sel-edge-image-core.bb

inherit image-oci

SUMMARY = "Core SEL container"

# entrypoint
CONTAINER_APP_CMD ?= "/usr/bin/bash"

# packages
CONTAINER_APP ?= "bash"

PREFERRED_PROVIDER_virtual/kernel = "linux-dummy"

OCI_IMAGE_ENTRYPOINT = "${CONTAINER_APP_CMD}"
IMAGE_INSTALL:append = " ${CONTAINER_APP}"

OCI_IMAGE_USER = "sapience"

IMAGE_FSTYPES = "oci"

# Don't build QEMU as we want an OCI container
EXTRA_IMAGEDEPENDS:remove = "qemu-native qemu-helper-native"