package org.example.database

import models.Item
import org.example.models.Board
import org.example.models.Card
import org.example.models.User

class LocalDataSource {

    val users: MutableMap<String, User> = mutableMapOf(
        Pair("1", User("1", "user1", "")),
        Pair("2", User("2", "user2", "")),
    )

    val board: MutableMap<String, Board> = mutableMapOf()

    val cards: MutableMap<String, Card> = mutableMapOf()

    val items: MutableMap<String, Item> = mutableMapOf()
}