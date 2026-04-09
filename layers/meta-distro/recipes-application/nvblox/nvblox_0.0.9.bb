DESCRIPTION = "nvblox is a library for real-time 3D reconstruction, designed for robotic applications."
HOMEPAGE = "https://github.com/nvidia-isaac/nvblox"

# nvblox is Apache 2; voxblox is BSD-3-Clause
# https://github.com/nvidia-isaac/nvblox/blob/public/LICENSE.md
# https://github.com/ethz-asl/voxblox/blob/master/LICENSE
LICENSE = "Apache-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=8d8c50db3bb79d824bdd7276d6a50bc1"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "3f42b210df9ad7a2099f00fcf324049d97342cb0"
SRC_URI = " \
    git://github.com/nvidia-isaac/nvblox.git;branch=public;protocol=https \
    file://0001-cmake-find-sqlite3.patch \
    file://0002-eigen3-int-instead-of-sizet.patch \
"


inherit cmake cuda

NVBLOX_EXEC_DEPENDS = " \
    gflags \
    sqlite3 \
    libeigen \
    glog \
    stdgpu \
    pytorch \
"

NVBLOX_TEST_DEPENDS = " \
    googletest \
    google-benchmark \
"

NVBLOX_BUILD_DEPENDS = " \
    jq \
    gnupg \
"

# sudo apt-get update && sudo apt-get install cmake git jq gnupg apt-utils software-properties-common build-essential sudo python3-pip wget sudo git python3-dev git-lfs
DEPENDS += " \
    ${NVBLOX_BUILD_DEPENDS} \
    ${NVBLOX_EXEC_DEPENDS} \
    ${NVBLOX_TEST_DEPENDS} \
"

RDEPENDS:${PN} += " \
    ${NVBLOX_EXEC_DEPENDS} \
"

# use system packages instead of downloading in configure
EXTRA_OECMAKE:append  = " \
    -DUSE_SYSTEM_BENCHMARK=ON \
    -DUSE_SYSTEM_EIGEN=ON \
    -DUSE_SYSTEM_GFLAGS=ON \
    -DUSE_SYSTEM_GLOG=ON \
    -DUSE_SYSTEM_GTEST=ON \
    -DUSE_SYSTEM_SQLITE3=ON \
    -DUSE_SYSTEM_STDGPU=ON \
    -DCMAKE_CUDA_IMPLICIT_INCLUDE_DIRECTORIES=${RECIPE_SYSROOT}${libdir} \
"

# Set cuda arch since we may not be compiling on target hardware
# 87 (8.7) is orin nano's compute capability, (this opt may include forward compat. stuff)
# 87-real means generate for  this hardware *exactly* (may not work on future cap. versions)
EXTRA_OECMAKE:jetson-orin-nano-devkit:append = " -DCMAKE_CUDA_ARCHITECTURES=87-real "

TARGET_CXXFLAGS:append = " -Wno-template-body "

do_configure:append() {
    # Fix CMake alias fallback by faking the nvblox_stdgpu library
    
    if [ -e "${RECIPE_SYSROOT}${libdir}/libstdgpu.so" ]; then
        bbnote "Creating nvblox_stdgpu.so symlink for linker"
        ln -sf ${RECIPE_SYSROOT}${libdir}/libstdgpu.so ${RECIPE_SYSROOT}${libdir}/libnvblox_stdgpu.so
    fi
    
    if [ -e "${RECIPE_SYSROOT}${libdir}/libstdgpu.a" ]; then
        bbnote "Creating nvblox_stdgpu.a symlink for linker"
        ln -sf ${RECIPE_SYSROOT}${libdir}/libstdgpu.a ${RECIPE_SYSROOT}${libdir}/libnvblox_stdgpu.a
    fi
}