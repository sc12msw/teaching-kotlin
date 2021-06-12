package uk.tojourn

class Practice {
    fun checkPattern(input: String): Boolean {
        return !input.contains("ba")
    }

    // First try 0, 1, 0, 0, 1
    fun processList(numberList: MutableList<Int>): MutableList<Int> {
        var counter = 0
        val first = numberList[0]
        var expected = 0
        if (first == 0) {
            expected = 1
        }

        for( i in 1 until numberList.size){
            if (numberList[i] != expected) {
                println("switch")
                counter++
                numberList[i] = expected
                expected = flip(expected)
            }
        }
        print("Total flips $counter")
        return numberList

    }


    private fun flip(num: Int): Int {
        return if (num == 1) 0 else 1
    }
}






