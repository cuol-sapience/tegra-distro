require recipes-core/images/ros-image-core.bb

SUMMARY = "Core SEL image (no GUI)"

# Use networkmanager instead of systemd-networkd (allows us to use simpler nmcli instead of low level iw commands)
NETWORK_MANAGER = "networkmanager"

# note: MACHINE_EXTRA_RRECOMMENDS adds rtl88x2ce from nvidia
IMAGE_INSTALL:append = "\
    ${MACHINE_EXTRA_RRECOMMENDS} \
    packagegroup-sel-core \
"

EXTRA_IMAGE_FEATURES:append = " ros-implicit-workspace"

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