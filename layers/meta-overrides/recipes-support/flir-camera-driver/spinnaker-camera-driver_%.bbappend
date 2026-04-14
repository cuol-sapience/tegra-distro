LICENSE = "BSD-3-Clause"

CXXFLAGS:append = " -include cstdint -Wno-error=deprecated-declarations"

DEPENDS:append = " lsb-release-native spinnaker-sdk "

RDEPENDS:${PN} += "bash"

RDEPENDS:${PN}:append:class-target:x86-64 = " intel-oneapi-mkl intel-oneapi-dpcpp-cpp-runtime"
DEPENDS:append:class-target:x86-64 = " intel-oneapi-mkl intel-oneapi-dpcpp-cpp"