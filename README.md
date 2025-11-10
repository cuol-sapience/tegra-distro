# tegra-distro

## Dependencies (Ubuntu)

```bash
sudo apt-get update
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm zstd lz4 cpio file iptables -y

git submodule update --init

source repos/poky/oe-init-build-env build
```

## Building

```
bitbake mc:arm64-qemu:sapience-image-minimal
bitbake mc:arm64-qemu:sapience-image-gui
```

---


GUI: `core-image-sato-dev`

Minimal (no gui): ~~`core-image-full-cmdline`~~ `core-image-minimal-dev`

## Testing in QEMU

### Devcontainer Host setup

```
xhost local:root
```

### Launch

```
runqemu mc:arm64-qemu:sapience-image-gui ext4 publicvnc qemuparams="-m 4096"
```