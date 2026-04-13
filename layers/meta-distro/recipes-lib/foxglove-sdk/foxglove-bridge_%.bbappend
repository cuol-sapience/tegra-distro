# patch to use foxglove-sdk recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/foxglove-bridge:"

SRC_URI += "file://0001-use-installed-sdk.patch"

DEPENDS += "foxglove-sdk zstd"

EXTRA_OECMAKE += "-DUSE_INSTALLED_SDK=ON"

# rosx-introspection
# CFLAGS += "-Wno-error=old-style-cast"
CXXFLAGS += "-Wno-error=old-style-cast"