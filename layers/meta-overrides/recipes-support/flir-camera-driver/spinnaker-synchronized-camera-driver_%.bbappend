# upstream is just "Apache-2"
LICENSE = "Apache-2.0"

CXXFLAGS:append = " -include cstdint -include functional -Wno-error=deprecated-declarations"