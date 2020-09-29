package com.vlopatka.domain

import java.io.Serializable
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "traffic_light")
data class TrafficLight(
    @Column(name = "address", nullable = false)
    val address: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    var state: StateType = StateType.OFF,

    @Enumerated(EnumType.STRING)
    @Column(name = "indicator", nullable = false)
    var indicator: IndicatorType = IndicatorType.YELLOW,

    ) : Serializable {

    @Id
    var uuid: String = UUID.randomUUID().toString()
}

enum class IndicatorType {
    GREEN, YELLOW, RED
}

enum class StateType {
    OFF, ON, BROKEN
}
