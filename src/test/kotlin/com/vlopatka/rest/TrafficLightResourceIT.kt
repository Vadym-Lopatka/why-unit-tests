package com.vlopatka.rest

import com.vlopatka.domain.DeviceStateType
import com.vlopatka.helper.TestDataHelper.buildTrafficLightDto
import com.vlopatka.rest.TrafficLightResource.Companion.TRAFFIC_LIGHT_API_PATH
import com.vlopatka.rest.dto.TrafficLightDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrafficLightResourceIT {


    @Autowired
    private lateinit var restTemplate: TestRestTemplate


    @Test
    fun `should create a traffic light entity`() {
        // given
        val dto = buildTrafficLightDto(uuid = null, deviceUuid = null)

        // when
        val response = restTemplate.exchange(TRAFFIC_LIGHT_API_PATH, HttpMethod.POST, HttpEntity(dto), TrafficLightDto::class.java)

        // then
        assertThat(response.statusCode.is2xxSuccessful).isTrue()
        val createdDto = response.body!!

        assertThat(createdDto.uuid).isNotNull
        assertThat(createdDto.deviceUuid).isNull()
        assertThat(dto.deviceState).isEqualTo(createdDto.deviceState)
        assertThat(dto.indicationState).isEqualTo(createdDto.indicationState)
        assertThat(dto.address).isEqualTo(createdDto.address)

    }

}