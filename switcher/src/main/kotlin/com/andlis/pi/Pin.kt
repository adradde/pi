package com.andlis.pi

import com.andlis.pi.relay.GpioConfig
import com.pi4j.io.gpio.*
import org.springframework.stereotype.Component
import javax.annotation.PreDestroy

@Component
open class GPIO(val config: GpioConfig) {
    private lateinit var gpio: GpioController
    private lateinit var relayPin: GpioPinDigitalOutput
    private lateinit var speakerPin: GpioPinDigitalOutput

    init {
        if (config.enabled) {
            gpio = GpioFactory.getInstance()
            speakerPin = gpio.provisionDigitalOutputPin(getRelayPinNumber(config.speakerPin), "Relay", PinState.LOW)
            relayPin = gpio.provisionDigitalOutputPin(getRelayPinNumber(config.relayPin), "Relay", PinState.LOW)
            relayPin.setShutdownOptions(true, PinState.LOW)
        }
    }

    fun startUp() {
        speakerPin.blink(300, 2000)
    }

    private fun getRelayPinNumber(pinNumber: Int): Pin = RaspiPin.getPinByAddress(pinNumber) ?: throw IllegalAccessException("Cant initialize pin with address: $pinNumber")

    @PreDestroy
    private fun shutdown() {
        if (config.enabled) {
            gpio.shutdown()
        }
    }

    fun high() {
        if (config.enabled) {
            relayPin.high()
        }
    }

    fun low() {
        if (config.enabled) {
            relayPin.low()
        }
    }

    fun toggle() {
        if (config.enabled) {
            relayPin.toggle()
        }
    }
}