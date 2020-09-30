package com.vlopatka.helper

import com.vlopatka.domain.DeviceStateType
import com.vlopatka.domain.IndicationStateType
import com.vlopatka.rest.dto.TrafficLightDto
import java.util.UUID

object TestDataHelper {

    fun buildTrafficLightDto(
        uuid: String? = UUID.randomUUID().toString(),
        deviceUuid: String? = UUID.randomUUID().toString(),
        deviceState: DeviceStateType = DeviceStateType.OFF,
        indicationState: IndicationStateType = IndicationStateType.YELLOW,
        address: String = "test address"
    ) = TrafficLightDto(
        uuid = uuid,
        deviceUuid = deviceUuid,
        deviceState = deviceState,
        indicationState = indicationState,
        address = address
    )
}