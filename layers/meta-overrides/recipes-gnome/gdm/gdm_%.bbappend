USERADD_PARAM:${PN} = "--system --groups video,render --home ${localstatedir}/lib/gdm gdm"
GROUPADD_PARAM:${PN} = "-r render"

