package com.vlopatka.rest

import com.vlopatka.rest.TrafficLightResource.Companion.TRAFFIC_LIGHT_API_PATH
import com.vlopatka.rest.dto.TrafficLightDto
import com.vlopatka.service.TrafficLightService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(TRAFFIC_LIGHT_API_PATH)
class TrafficLightResource(
    private val service: TrafficLightService
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun create(@Valid  @RequestBody dto: TrafficLightDto): TrafficLightDto {
        log.debug("API request to create TrafficLight by: $dto")
        return service.upsert(dto)
    }

    companion object {
        const val TRAFFIC_LIGHT_API_PATH = "/api/traffic-lights"
    }
}