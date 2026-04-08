FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-Guard-SYS_SECCOMP-define-against-system-header-enum-conflict.patch"