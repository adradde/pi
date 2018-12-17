package com.andlis.pi.web

import com.andlis.pi.relay.Relay
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
open class RelayController(val relay: Relay) {

    @GetMapping(value = *["/", "/switch"])
    fun getRelayControll(model: Model): String {
        model.addAttribute("relay", relay)
        return "relay"
    }

    @PostMapping("/switch")
    fun switchRelay(model: Model): String {
        relay.switch()
        model.addAttribute("state", relay.getState())
        return "relay"
    }


}