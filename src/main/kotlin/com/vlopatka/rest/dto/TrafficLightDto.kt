package com.vlopatka.rest.dto

import com.vlopatka.domain.DeviceStateType
import com.vlopatka.domain.IndicationStateType
import java.io.Serializable
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class TrafficLightDto(
    val uuid: String? = null,

    val deviceUuid: String? = null,

    @get: NotNull
    val deviceState: DeviceStateType = DeviceStateType.BROKEN,

    @get: NotNull
    val indicationState: IndicationStateType = IndicationStateType.RED,

    @get: NotNull
    @get: NotEmpty
    val address: String
) : Serializable