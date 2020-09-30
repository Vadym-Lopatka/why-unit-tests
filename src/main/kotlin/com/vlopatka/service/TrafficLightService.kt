package com.vlopatka.service

import com.vlopatka.domain.TrafficLight
import com.vlopatka.repository.TrafficLightRepository
import com.vlopatka.rest.dto.TrafficLightDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class TrafficLightService(
    private val repository: TrafficLightRepository
) {

    fun upsert(dto: TrafficLightDto): TrafficLightDto {
        return repository.save(dto.toCreateEntity()).toDto()
    }

}

private fun TrafficLight.toDto()=TrafficLightDto(
    uuid = uuid,
    deviceUuid = deviceUuid,
    deviceState = deviceState,
    indicationState = indicationState,
    address = address
)

private fun TrafficLightDto.toCreateEntity() = TrafficLight(
    deviceUuid = deviceUuid,
    deviceState = deviceState,
    indicationState = indicationState,
    address = address
)

private fun TrafficLightDto.toEntity() = TrafficLight(
//    uuid = uuid,
    deviceUuid = deviceUuid,
    deviceState = deviceState,
    indicationState = indicationState,
    address = address
)
