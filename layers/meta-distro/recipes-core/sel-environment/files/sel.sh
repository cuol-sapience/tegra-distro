#!/bin/sh

export ROS_DISTRO=humble

# Source ROS setup for all shells (login, SSH, interactive, non-interactive)
if [ -f /usr/bin/ros_setup.sh ]; then
    . /usr/bin/ros_setup.sh
elif [ -f /opt/ros/${ROS_DISTRO}/setup.sh ]; then
    . /opt/ros/${ROS_DISTRO}/setup.sh
elif [ -f /opt/ros/${ROS_DISTRO}/setup.bash ]; then
    . /opt/ros/${ROS_DISTRO}/setup.bash
fi

# Aliases only for interactive shells
case $- in
    *i*)
        alias sel-switch-desktop="sudo systemctl isolate graphical.target"
        alias sel-switch-cli="sudo systemctl isolate multi-user.target"
        ;;
esac