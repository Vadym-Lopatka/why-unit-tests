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
    @Column(name = "device_uuid", nullable = false)
    var deviceUuid: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "device_state", nullable = false)
    var deviceState: DeviceStateType = DeviceStateType.OFF,

    @Enumerated(EnumType.STRING)
    @Column(name = "indication_state", nullable = false)
    var indicationState: IndicationStateType = IndicationStateType.YELLOW,

    @Column(name = "address", nullable = false)
    var address: String,

    ) : Serializable {

    @Id
    var uuid: String = UUID.randomUUID().toString()
}

enum class IndicationStateType {
    GREEN, YELLOW, RED
}

enum class DeviceStateType {
    OFF, ON, BROKEN
}
