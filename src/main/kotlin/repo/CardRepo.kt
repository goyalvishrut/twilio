package org.example.repo

import org.example.models.Card

interface CardRepo {
    fun addItemToCard(cardId: String, itemId: String)

    fun removeItemFromCard(itemId: String)

    fun deleteCard(cardId: String): String?

    fun addCard(card: Card)
}