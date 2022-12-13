fun main() {
    print(
        solution(
            mutableListOf(
                mutableListOf(1, 3, 2, 5, 4, 6, 9, 8, 7),
                mutableListOf(4, 6, 5, 8, 7, 9, 3, 2, 1),
                mutableListOf(7, 9, 8, 2, 1, 3, 6, 5, 4),
                mutableListOf(9, 2, 1, 4, 3, 5, 8, 7, 6),
                mutableListOf(3, 5, 4, 7, 6, 8, 2, 1, 9),
                mutableListOf(6, 8, 7, 1, 9, 2, 5, 4, 3),
                mutableListOf(5, 7, 6, 9, 8, 1, 4, 3, 2),
                mutableListOf(2, 4, 3, 6, 5, 7, 1, 9, 8),
                mutableListOf(8, 1, 9, 3, 2, 4, 7, 6, 5)
            )
        )
    )
}

fun solution(grid: MutableList<MutableList<Int>>): Boolean {
    for (i in 0 until grid.size step 3) {
        for (j in 0 until grid.size step 3) {
            var sum = 0
            for (k in i until (i + 3)) {
                for (l in j until (j + 3)) {
                    sum += grid[k][l]
                }
            }
            if (sum != 45)
                return false
        }
    }
    for (i in 0 until grid.size) {
        if (grid[i].all { it == 5 })
            return false
        if (grid[i].sum() != 45)
            return false
    }
    for (i in 0 until grid.size) {
        if (grid.sumOf {
                it[i]
            } != 45)
            return false
    }
    return true
}