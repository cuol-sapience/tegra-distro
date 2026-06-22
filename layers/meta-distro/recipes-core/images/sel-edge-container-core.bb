require sel-edge-image-core.bb

SUMMARY = "Core SEL container"

IMAGE_FSTYPES = "container oci"

inherit image
inherit image-oci

OCI_IMAGE_AUTHOR = "Sapience"
OCI_IMAGE_TAG = "latest"
OCI_IMAGE_RUNTIME_UID = "1000"
OCI_IMAGE_CMD = "/usr/bin/bash"
OCI_IMAGE_WORKINGDIR = "/home/sapience"

PREFERRED_PROVIDER_virtual/kernel = "linux-dummy"

# Don't build QEMU as we want an OCI container
EXTRA_IMAGEDEPENDS:remove = "qemu-native qemu-helper-native"

fix_lib64_symlink() {
    if [ ! -e ${IMAGE_ROOTFS}/lib64 ]; then
        ln -sf usr/lib ${IMAGE_ROOTFS}/lib64
    fi
}
ROOTFS_POSTPROCESS_COMMAND:append = " fix_lib64_symlink;"