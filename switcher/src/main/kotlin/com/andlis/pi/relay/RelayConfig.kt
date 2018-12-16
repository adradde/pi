package com.andlis.pi.relay

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "relay")
class RelayConfig {
    var sourcePin: Int = 11
    var enabled: Boolean = false
}