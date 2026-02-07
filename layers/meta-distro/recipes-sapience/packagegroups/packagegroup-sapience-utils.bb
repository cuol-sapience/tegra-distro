# SUMMARY = "TBD"
DESCRIPTION = "Utility package group"

PV = "1.0.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
    bash \
    sudo \
    net-tools \
    iproute2 \
    os-release \
    usbutils \
    pciutils \
"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    useradd -p '' sapience; \
    usermod -a -G input,video,sudo sapience; \
    "

# sudo extra config: https://stackoverflow.com/a/42615560

update_sudoers(){
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}

ROOTFS_POSTPROCESS_COMMAND += "update_sudoers;"