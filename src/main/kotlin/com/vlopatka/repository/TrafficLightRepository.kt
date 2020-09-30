package com.vlopatka.repository

import com.vlopatka.domain.TrafficLight
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrafficLightRepository : JpaRepository<TrafficLight, String> {
}