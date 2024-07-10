package org.example.models


data class Board(
    val id: String,
    var name: String,
    var privacy: Privacy = Privacy.PUBLIC,
    val cards: MutableList<String>,
    val members: MutableList<String>
) {
    val url: String = id
}
