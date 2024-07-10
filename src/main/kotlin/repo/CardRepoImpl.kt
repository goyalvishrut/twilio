package org.example.repo

import org.example.database.LocalDataSource
import org.example.models.Card

class CardRepoImpl(
    private val localDataSource: LocalDataSource,
    private val itemRepoImpl: ItemRepoImpl
) : CardRepo {
    private val cards = localDataSource.cards

    override fun addItemToCard(cardId: String, itemId: String) {
        cards[cardId]?.items?.add(itemId)
    }

    override fun removeItemFromCard(itemId: String) {
        val cardId = localDataSource.items[itemId]?.cardId
        cards[cardId]?.items?.remove(itemId)
    }

    override fun deleteCard(cardId: String): String? {
        val boardId = localDataSource.cards[cardId]?.boardId
        localDataSource.cards[cardId]?.items?.forEach { itemRepoImpl.deleteItem(it) }
        localDataSource.cards.remove(cardId)
        return boardId
    }

    override fun addCard(card: Card) {
        cards[card.id] = card
    }
}