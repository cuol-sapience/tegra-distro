# GCC 15 is stricter about const qualifiers; upstream uses -Werror
CFLAGS += "-Wno-error=discarded-qualifiers"