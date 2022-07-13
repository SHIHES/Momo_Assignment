package com.example.android.momo_assignment.logic.model.animal

data class Result(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Animal>,
    val sort: String
)