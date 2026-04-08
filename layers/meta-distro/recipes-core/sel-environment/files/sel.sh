#!/bin/sh

# Set env vars
export ROS_DISTRO=humble

# Set aliases
alias sel-switch-desktop="sudo systemctl isolate graphical.target"
alias sel-switch-cli="sudo systemctl isolate multi-user.target"

# Auto-source ROS setup for interactive shells
if [ -n "$PS1" ]; then
    # Try ros-workspace package script first
    if [ -f /usr/bin/ros_setup.sh ]; then
        . /usr/bin/ros_setup.sh
    # falling back to DISTRO
    elif [ -f /opt/ros/${ROS_DISTRO}/setup.sh ]; then
        . /opt/ros/${ROS_DISTRO}/setup.sh
    elif [ -f /opt/ros/${ROS_DISTRO}/setup.bash ]; then
        . /opt/ros/${ROS_DISTRO}/setup.bash
    fi
fi