package org.example.repo

import models.Item
import org.example.models.User

interface ItemRepo {
    fun deleteItem(itemID: String)

    fun addItem(item: Item)

    fun modifyItem(itemId: String, item: Item)

    fun changeUser(itemId: String, user: User?)
}