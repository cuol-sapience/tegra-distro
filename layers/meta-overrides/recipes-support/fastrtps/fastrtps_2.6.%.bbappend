# https://github.com/eProsima/Fast-DDS/issues/5726

# relies on deprecated/remove asio functions, backport available in 2.14.x/3.2.x or force own asio
EXTRA_OECMAKE += " -DTHIRDPARTY_Asio=FORCE"