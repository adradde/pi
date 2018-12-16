package com.andlis.pi.relay

/**
 * Created by andrii on 16.12.2018.
 */
interface Relay {

    fun turnOn(): State
    fun turnOff(): State
    fun turnOn(delayInMillis: Long): State
    fun turnOff(delayInMillis: Long): State
    fun switch(): State

    fun update(state: State): State
    fun getState(): State


}