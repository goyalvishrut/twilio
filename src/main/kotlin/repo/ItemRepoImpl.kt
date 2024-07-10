package org.example.repo

import models.Item
import org.example.database.LocalDataSource
import org.example.models.User

class ItemRepoImpl(private val localDataSource: LocalDataSource) : ItemRepo {

    override fun deleteItem(itemID: String) {
        localDataSource.items.remove(itemID)
    }

    override fun addItem(item: Item) {
        localDataSource.items[item.id] = item
    }

    override fun modifyItem(itemId: String, item: Item) {
        localDataSource.items[itemId] = item
    }

    override fun changeUser(itemId: String, user: User?) {
        localDataSource.items[itemId]?.user = user
    }
}