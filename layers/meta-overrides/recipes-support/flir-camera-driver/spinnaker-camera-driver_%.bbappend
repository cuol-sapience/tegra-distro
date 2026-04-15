LICENSE = "BSD-3-Clause"

CXXFLAGS:append = " -include cstdint -Wno-error=deprecated-declarations"

DEPENDS:append = " lsb-release-native spinnaker-sdk "

RDEPENDS:${PN} += "bash spinnaker-sdk-dev"