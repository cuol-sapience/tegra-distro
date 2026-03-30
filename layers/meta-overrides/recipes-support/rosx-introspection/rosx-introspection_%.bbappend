DEPENDS += " rosidl-adapter rapidjson"

CPM_VERSION = "0.40.0"
CPM_HASH = "7b354f3a5976c4626c876850c93944e52c83ec59a159ae5de5be7983f0e17a2a"


SRC_URI += "https://github.com/cpm-cmake/CPM.cmake/releases/download/v${CPM_VERSION}/CPM.cmake;subdir=cpm_download;downloadfilename=CPM_${CPM_VERSION}.cmake"

SRC_URI[sha256sum] = "${CPM_HASH}"


CPM_CACHE_DIR = "${UNPACKDIR}/cpm_cache"

do_configure:prepend() {
    mkdir -p ${CPM_CACHE_DIR}/cpm
    cp ${UNPACKDIR}/cpm_download/CPM_${CPM_VERSION}.cmake ${CPM_CACHE_DIR}/cpm/CPM_${CPM_VERSION}.cmake
}

EXTRA_OECMAKE += "-DCPM_SOURCE_CACHE=${CPM_CACHE_DIR}"