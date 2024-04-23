package com.example.demo

import com.example.demo.models.tictactoe.Cell
import com.example.demo.models.tictactoe.TicTacGrid
import com.example.demo.models.tictactoe.Piece
import com.example.demo.models.tictactoe.Player
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.stream.Stream
import kotlin.math.abs

class TicTakToe {

    private val boardSize = 3
    private var isGameFinished = false
    private val bReader = BufferedReader(InputStreamReader(System.`in`))
    fun init() {
        val cells = Array(boardSize) {
            Array(boardSize) {
                Cell(null)
            }
        }

        val ticTacGrid = TicTacGrid(Math.random().toLong(), boardSize, cells)

        val piece1 = Piece(Math.random().toLong(), 'X')
        val piece2 = Piece(Math.random().toLong(), 'O')

        val user1 = Player(Math.random().toLong(), "P1", piece1)
        val user2 = Player(Math.random().toLong(), "P2", piece2)

        val queueOfPlayers: Queue<Player> = LinkedList()
        queueOfPlayers.add(user1)
        queueOfPlayers.add(user2)

        printBoard(ticTacGrid)
        startGame(queueOfPlayers, ticTacGrid)
    }

    private fun startGame(queueOfPlayers: Queue<Player>, ticTacGrid: TicTacGrid) {
        val size = ticTacGrid.cells.size

        while (!isGameFinished) {
            val currentPlayer = queueOfPlayers.poll()

            val inputs: List<String> = Stream.of(bReader.readLine().trim().split(" ")).toList().flatten()
            val m = Integer.parseInt(inputs[0])
            val n = Integer.parseInt(inputs[1])

            if (m < 0 || n < 0 || m > size || n > size) {
                println("Invalid")
                continue
            }

            val cell = ticTacGrid.cells[m][n]

            if(!ifGivenCellIsEmpty(m, n, cell)) {
                println("Invalid")
                continue
            }

            // assign piece on empty cell
            cell.piece = currentPlayer.piece
            currentPlayer.allPositions.addLast(m to n)


            printBoard(ticTacGrid)


            if (currentPlayerWon(currentPlayer, m, n)) {
                isGameFinished = true

                println("${currentPlayer.name} won")
                break;
            }

            queueOfPlayers.add(currentPlayer)
        }
    }

    private fun printBoard(ticTacGrid: TicTacGrid) {
        ticTacGrid.cells.map { row ->
            row.map { cell ->
                val char: Char? = cell.piece?.character

                if (char == null) {
                    print('_')
                } else {
                    print(char)
                }
            }
            println()
        }
    }

    private fun currentPlayerWon(currentPlayer: Player, m: Int, n: Int): Boolean {
        val threePieceInOneRow: Boolean = currentPlayer.allPositions.map { it.first }
            .groupBy { it }.any { it.value.size == boardSize }

        val threePieceInOneCol: Boolean = currentPlayer.allPositions.map { it.second }
            .groupBy { it }.any { it.value.size == boardSize }

        val cornerCells = listOf(0 to 0, 0 to boardSize - 1, boardSize - 1 to 0, boardSize - 1 to boardSize - 1)
        val midCell = listOf((boardSize - 1) / 2 to (boardSize - 1) / 2)

        val midCellPresent = currentPlayer.allPositions.any { midCell.contains(it) }
        val twoCornerOppositeCells = currentPlayer.allPositions.filter { cornerCells.contains(it) }
            .flatMap {pair1 ->
                currentPlayer.allPositions.map {pair2 ->
                    abs(pair1.first - pair2.first) == boardSize - 1 &&
                    abs(pair1.second - pair2.second) == boardSize - 1
                }
            }.contains(true)

        val threePieceInDiagonal = midCellPresent && twoCornerOppositeCells


        return threePieceInOneCol || threePieceInOneRow || threePieceInDiagonal
    }

    private fun ifGivenCellIsEmpty(m: Int, n: Int, cell: Cell) : Boolean {
        return cell.piece == null
    }

}

/**
 * 00
 * 11
 * 22
 * 02
 * 12
 *
 *
 *
 * 02
 * 11
 * 20
 *
 *
 * invalid
 * 00
 * 11
 * 20
 *
 * */
