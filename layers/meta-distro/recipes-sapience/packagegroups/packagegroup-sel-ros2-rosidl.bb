# SUMMARY = "TBD"
DESCRIPTION = "rosidl package group"

PV = "1.0.0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN} ${PN}-staticdev"

SEL_ROS2_ROSIDL_PACKAGES = "\
	rosidl-adapter \
	rosidl-cli \
	rosidl-cmake \
	rosidl-generator-c \
	rosidl-generator-cpp \
	rosidl-parser \
	rosidl-runtime-c \
	rosidl-runtime-cpp \
	rosidl-typesupport-interface \
	rosidl-typesupport-introspection-c \
	rosidl-typesupport-introspection-cpp \
	rosidl-generator-dds-idl \
	rosidl-default-generators \
	rosidl-default-runtime \
	rosidl-generator-py \
	rosidl-runtime-py \
	rosidl-typesupport-c \
	rosidl-typesupport-cpp \
	fastrtps-cmake-module \
	rosidl-typesupport-fastrtps-c \
	rosidl-typesupport-fastrtps-cpp \
"

RDEPENDS:${PN} = "${SEL_ROS2_ROSIDL_PACKAGES}"

RRECOMMENDS:${PN}-staticdev = "${@' '.join(p + '-staticdev' for p in d.getVar('SEL_ROS2_ROSIDL_PACKAGES').split())}"
