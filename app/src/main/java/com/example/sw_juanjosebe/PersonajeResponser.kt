package com.example.sw_juanjosebe

data class PersonajeResponser(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)