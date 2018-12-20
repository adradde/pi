package com.andlis.pi.relay

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "relay")
class GpioConfig {
    var relayPin: Int = 0
    var speakerPin: Int = 0
    var enabled: Boolean = false
}