package com.example.demo.models.entities

import java.math.BigDecimal
import java.sql.Timestamp

data class CheckIn(
    val userId : Long,
    val venueId : String,
    val venueCategoryId : String,
    val venueCategory : String,
    val latitude : BigDecimal,
    val longitude : BigDecimal,
    val utcTimestamp : Timestamp,
)
