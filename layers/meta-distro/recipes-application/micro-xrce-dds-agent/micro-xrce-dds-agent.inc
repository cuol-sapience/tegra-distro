DESCRIPTION = "Implementation of the DDS-XRCE protocol."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"


FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

S = "${WORKDIR}/git"

# meta-ros2-humble ships with 'fastcdr' v1.0.24-2, we package v2.3.4 ourselves as 'fastcdr2'
# fastdds not packaged by meta-ros2-humble (kilted+ only)
DEPENDS = "fastcdr2 fastrtps fastdds libtinyxml2"

inherit cmake

# extra cmake args: https://github.com/eProsima/Micro-XRCE-DDS-Agent/issues/319#issuecomment-3414294637
# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE += "\
    -DUAGENT_SUPERBUILD=OFF \
    -DUAGENT_P2P_PROFILE=OFF \
    -DUAGENT_LOGGER_PROFILE=OFF \
    -DUAGENT_USE_SYSTEM_FASTCDR=TRUE \
    -DUAGENT_USE_SYSTEM_FASTDDS=TRUE \
    -Dfastcdr_DIR=${WORKDIR}/recipe-sysroot/usr/lib/cmake/fastcdr  \
    -Dfastrtps_DIR=${WORKDIR}/recipe-sysroot/opt/ros/humble/share/fastrtps/cmake \
    "


# package license file, cmake 
FILES:${PN}:append = " /usr/share/microxrcedds_agent/LICENSE /usr/share/microxrcedds_agent/cmake/*"

# may also be useful: 2022 packaging of micro-xrce-dds-agent: (permalink)
# https://github.com/antmicro/meta-antmicro/blob/278f986faf12694b3d0cce1997fafb071cd6de87/meta-microros/recipes-agent/microxrcedds-agent/microxrcedds-agent.bb