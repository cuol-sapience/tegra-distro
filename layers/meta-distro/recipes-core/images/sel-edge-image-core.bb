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
    useradd -p '' -s /usr/bin/bash sapience; \
    usermod -a -G input,video,sudo sapience; \
    usermod -s /usr/bin/bash root; \
    "

# sudo extra config: https://stackoverflow.com/a/42615560

update_sudoers(){
    sed -i 's/# %sudo/%sudo/' ${IMAGE_ROOTFS}/etc/sudoers
}



# Generate en_GB.UTF-8 locale — required by gnome-terminal and other GNOME apps
IMAGE_LINGUAS = "en-gb"
GLIBC_GENERATE_LOCALES = "en_GB.UTF-8"
IMAGE_INSTALL:append = " locale-base-en-gb"

# Set system locale to UTF-8
set_system_locale() {
    mkdir -p ${IMAGE_ROOTFS}/etc
    echo "LANG=en_GB.UTF-8" > ${IMAGE_ROOTFS}/etc/locale.conf
}

# Ensure ROS environment is available in login shells by default.
set_ros_profile() {
    install -d ${IMAGE_ROOTFS}${sysconfdir}/profile.d
    cat > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/ros.sh << EOF
# Auto-source ROS setup for interactive shells
if [ -n "\$PS1" ]; then
    if [ -f /opt/ros/${ROS_DISTRO}/setup.sh ]; then
        . /opt/ros/${ROS_DISTRO}/setup.sh
    elif [ -f /opt/ros/${ROS_DISTRO}/setup.bash ]; then
        . /opt/ros/${ROS_DISTRO}/setup.bash
    fi
fi
EOF
    chmod 0644 ${IMAGE_ROOTFS}${sysconfdir}/profile.d/ros.sh
}


ROOTFS_POSTPROCESS_COMMAND += "update_sudoers;set_system_locale;set_ros_profile;"

SYSTEMD_DEFAULT_TARGET = "multi-user.target"