package org.example.repo

import org.example.models.Privacy

interface BoardRepo {
    fun createBoard(name: String): String

    fun deleteBoard(boardId: String)

    fun modifyBoardNameOrPrivacy(boardId: String, name: String, privacy: Privacy)

    fun addUserToBoard(boardId: String, userId: String)

    fun deleteUserFromBoard(boardId: String, user: String)

    fun addCardToBoard(boardId: String, cardId: String)

    fun deleteCardFromBoard(cardId: String)
}