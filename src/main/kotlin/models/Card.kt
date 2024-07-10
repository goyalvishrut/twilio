package org.example.models

data class Card(
    val id: String,
    val name: String,
    val items: MutableList<String>,
    val boardId: String
)