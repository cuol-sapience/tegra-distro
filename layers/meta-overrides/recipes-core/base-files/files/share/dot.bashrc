# ~/.bashrc: executed by bash(1) for non-login shells.

# Source system-wide profile.d scripts for non-login shells (e.g. SSH terminal, desktop terminal)
if [ -f /etc/bash.bashrc ]; then
    . /etc/bash.bashrc
fi

export PS1='\u@\h:\w\$ '
umask 022
