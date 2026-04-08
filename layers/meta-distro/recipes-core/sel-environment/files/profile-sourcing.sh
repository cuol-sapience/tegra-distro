#!/bin/sh


if [ -z "$__SEL_PROFILE_SOURCED" ]; then
    if [ -d /etc/profile.d ]; then
      for i in /etc/profile.d/*.sh; do
        [ -r "$i" ] && . "$i"
      done
      unset i
    fi
    export __SEL_PROFILE_SOURCED=true
fi