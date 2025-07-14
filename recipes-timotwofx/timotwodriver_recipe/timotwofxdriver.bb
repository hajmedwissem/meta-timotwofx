SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "CLOSED"


inherit module

SRC_URI = "git://github.com/hajmedwissem/timotwofx_driver.git;protocol=https;branch=main"
SRCREV = "bf914d89ed5ca0cf5d05d5e2f1692216ca61b5b2"



DEPENDS += "virtual/kernel"
S = "${WORKDIR}/git"


EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR} M=${S}"


do_compile() {
    
    oe_runmake KERNELDIR=${STAGING_KERNEL_DIR} M=${S} 

}

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 timotwofxdriver.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/

}



INSANE_SKIP:timotwofxdriver-dbg = "buildpaths"
