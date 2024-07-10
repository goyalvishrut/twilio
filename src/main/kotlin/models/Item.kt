package models

import org.example.models.User

data class Item(
    val id: String,
    val name: String,
    val description: String,
    var user: User? = null,
    val cardId: String
)
