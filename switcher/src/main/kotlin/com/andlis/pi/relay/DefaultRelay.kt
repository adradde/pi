package com.andlis.pi.relay

import com.andlis.pi.GPIO
import com.andlis.pi.relay.State.OFF
import com.andlis.pi.relay.State.ON
import org.springframework.stereotype.Component

@Component
open class DefaultRelay(val config: RelayConfig, val gpio: GPIO) : PinnedRelay(config) {

    private var state: State = OFF


    override fun turnOn(): State = state.also { this.state = ON; gpio.high() }

    override fun turnOff(): State = state.also { this.state = OFF; gpio.low() }

    override fun turnOn(delayInMillis: Long): State {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun turnOff(delayInMillis: Long): State {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun switch() = state.also { this.state = if (this.state == ON) OFF else ON; gpio.toggle() }

    override fun update(state: State): State {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getState() = state
}