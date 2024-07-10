package org.example

import org.example.database.LocalDataSource
import org.example.models.Board
import org.example.models.Card
import org.example.repo.BoardRepo
import org.example.repo.CardRepo
import org.example.repo.ItemRepo

class MainInteractor(
    private val boardRepo: BoardRepo,
    private val cardRepo: CardRepo,
    private val itemRepo: ItemRepo,
    private val localDataSource: LocalDataSource
) {

    fun createBoard(name: String): String {
        return boardRepo.createBoard(name)
    }

    fun deleteBoard(boardId: String) {
        boardRepo.deleteBoard(boardId)
    }

    fun deleteCard(cardId: String) {
        boardRepo.deleteCardFromBoard(cardId)
        cardRepo.deleteCard(cardId)
    }

    fun deleteItem(itemId: String) {
        cardRepo.removeItemFromCard(itemId)
        itemRepo.deleteItem(itemId)
    }

    fun moveCard(cardId: String, newBoardId: String) {
        val oldBoardId = boardRepo.deleteCardFromBoard(cardId)
        boardRepo.addCardToBoard(newBoardId, cardId)
    }

    fun moveItem(itemId: String, newCardId: String) {
        cardRepo.removeItemFromCard(itemId)
        cardRepo.addItemToCard(newCardId, itemId)
    }

    fun assignUserToCard(cardId: String, userId: String) {
        val user = localDataSource.users[userId]
        itemRepo.changeUser(cardId, user = user)
    }

    fun unassignToCard(cardId: String) {
        itemRepo.changeUser(cardId, null)
    }

    fun showList(listId: String? = null): List<Card> {
        return if (listId.isNullOrBlank()) {
            localDataSource.cards.values.toList()
        } else {
            val result = localDataSource.cards[listId]
            result?.let { listOf(it) }.orEmpty()
        }
    }

    fun showBoards(boardId: String? = null): List<Board> {
        return if (boardId.isNullOrBlank()) {
            localDataSource.board.values.toList()
        } else {
            localDataSource.board[boardId]?.let { listOf(it) }.orEmpty()
        }
    }

    fun addMemberToBoard(boardId: String, userId: String) {
        boardRepo.addUserToBoard(boardId, userId)
    }

    fun deleteMemberFromBoard(boardId: String, userId: String) {
        boardRepo.deleteUserFromBoard(boardId, userId)
    }
}
