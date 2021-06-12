package uk.tojourn

import java.lang.Exception

class Practice {
    fun checkPattern(input: String): Boolean {
        return !input.contains("ba")
    }

    // First try 0, 1, 0, 0, 1
    fun processList(numberList: MutableList<Int>): MutableList<Int> {
        validateList(numberList)
        var counter = 0

        for( i in 1 until numberList.size){
            if (numberList[i - 1] == numberList[i]) {
                counter++
                numberList[i] = flip(numberList[i])
            }
        }
        print("Total flips $counter")
        return numberList

    }


    private fun flip(num: Int): Int {
        return if (num == 1) 0 else 1
    }

    private fun validateList(numList: MutableList<Int>) {
        numList.forEach {
            if (it != 1 && it != 0) {
                throw Exception("number is not 0 or 1")
            }
        }
    }
}






