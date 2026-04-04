# SPDX-License-Identifier: GPL-2.0-only

obj-m := nv_ar0234.o

all modules:
	$(MAKE) -C $(KDIR) M=$(PWD) modules

clean:
	$(MAKE) -C $(KDIR) M=$(PWD) clean