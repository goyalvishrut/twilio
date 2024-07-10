package org.example

import org.example.repo.BoardRepoImpl
import org.example.repo.ItemRepoImpl
import org.example.repo.CardRepoImpl
import org.example.database.LocalDataSource

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val localDataSource = LocalDataSource()
    val itemRepo = ItemRepoImpl(localDataSource)
    val cardRepo = CardRepoImpl(localDataSource, itemRepo)
    val boardRepo = BoardRepoImpl(localDataSource, cardRepo)

    val mainInteractor = MainInteractor(boardRepo, cardRepo, itemRepo, localDataSource)

    val id1 = mainInteractor.createBoard("work tech")
    mainInteractor.createBoard("work tech")
    println(mainInteractor.showBoards(id1))
    println(mainInteractor.showBoards())
}