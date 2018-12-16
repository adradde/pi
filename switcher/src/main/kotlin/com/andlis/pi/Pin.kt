package com.andlis.pi

import com.andlis.pi.relay.RelayConfig
import com.pi4j.io.gpio.*
import org.springframework.stereotype.Component
import javax.annotation.PreDestroy

@Component
open class GPIO(val config: RelayConfig) {
    private lateinit var gpio: GpioController
    private lateinit var pin: GpioPinDigitalOutput

    init {
        if (config.enabled) {
            gpio = GpioFactory.getInstance()
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "Relay", PinState.LOW)
            pin.setShutdownOptions(true, PinState.LOW)
        }
    }

    @PreDestroy
    private fun shutdown() {
        if (config.enabled) {
            gpio.shutdown()
        }
    }

    fun high() {
        if (config.enabled) {
            pin.high()
        }
    }

    fun low() {
        if (config.enabled) {
            pin.low()
        }
    }

    fun toggle() {
        if (config.enabled) {
            pin.toggle()
        }
    }
}