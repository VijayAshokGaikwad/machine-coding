package com.example.demo.models.tictactoe

data class TicTacGrid(
    val id: Long = 0,
    val size: Int,
    val cells: Array<Array<Cell>> = arrayOf(arrayOf())
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TicTacGrid

        if (id != other.id) return false
        if (size != other.size) return false
        if (!cells.contentDeepEquals(other.cells)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + size
        result = 31 * result + cells.contentDeepHashCode()
        return result
    }
}
