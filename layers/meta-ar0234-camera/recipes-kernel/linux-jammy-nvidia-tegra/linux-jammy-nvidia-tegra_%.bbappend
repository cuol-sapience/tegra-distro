# D upstream AR0234 sensor driver
KERNEL_EXTRA_CONFIGS += "CONFIG_VIDEO_AR0234=n"

# Required V4L2 subdev infrastructure (usually already on in meta-tegra)
KERNEL_EXTRA_CONFIGS += "CONFIG_VIDEO_V4L2_SUBDEV_API=y"
KERNEL_EXTRA_CONFIGS += "CONFIG_MEDIA_CONTROLLER=y"