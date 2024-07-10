package org.example.repo

import org.example.database.LocalDataSource
import org.example.models.Board
import org.example.models.Privacy
import java.util.*

class BoardRepoImpl(
    private val localDataSource: LocalDataSource,
    private val cardRepo: CardRepo
) : BoardRepo {
    private val board = localDataSource.board

    override fun createBoard(name: String): String {
        val boardId = UUID.randomUUID().toString()
        val newBoard = Board(
            id = boardId,
            name = name,
            cards = mutableListOf(),
            members = mutableListOf()
        )
        board[boardId] = newBoard
        return boardId
    }

    override fun deleteBoard(boardId: String) {
        val cards = board[boardId]?.cards
        cards?.forEach { cardRepo.deleteCard(it) }
        board.remove(boardId)
    }

    override fun modifyBoardNameOrPrivacy(boardId: String, name: String, privacy: Privacy) {
        board[boardId]?.name = name
        board[boardId]?.privacy = privacy
    }

    override fun addUserToBoard(boardId: String, userId: String) {
        board[boardId]?.members?.add(userId)
    }

    override fun deleteUserFromBoard(boardId: String, user: String) {
        board[boardId]?.members?.remove(user)
    }

    override fun addCardToBoard(boardId: String, cardId: String) {
        board[boardId]?.cards?.add(cardId)
    }

    override fun deleteCardFromBoard(cardId: String) {
        val boardId = localDataSource.cards[cardId]?.boardId
        board[boardId]?.cards?.remove(cardId)
    }
}