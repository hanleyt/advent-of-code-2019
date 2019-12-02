import Day2.calculateOutput
import io.kotlintest.data.forall
import io.kotlintest.matchers.collections.shouldContainExactly
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class Day2Test : StringSpec({

    val input = listOf(1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,1,19,6,23,2,13,23,27,1,27,13,31,1,9,31,35,1,35,9,39,1,39,5,43,2,6,43,47,1,47,6,51,2,51,9,55,2,55,13,59,1,59,6,63,1,10,63,67,2,67,9,71,2,6,71,75,1,75,5,79,2,79,10,83,1,5,83,87,2,9,87,91,1,5,91,95,2,13,95,99,1,99,10,103,1,103,2,107,1,107,6,0,99,2,14,0,0)


    "run with examples" {
        forall(
            row(listOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50), listOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50)),
            row(listOf(1, 0, 0, 0, 99), listOf(2, 0, 0, 0, 99)),
            row(listOf(2, 3, 0, 3, 99), listOf(2, 3, 0, 6, 99)),
            row(listOf(2, 4, 4, 5, 99, 0), listOf(2, 4, 4, 5, 99, 9801)),
            row(listOf(1, 1, 1, 4, 99, 5, 6, 0, 99), listOf(30, 1, 1, 4, 2, 5, 6, 0, 99))
        ) { input, expectedOutput ->
            calculateOutput(input) shouldContainExactly expectedOutput
        }
    }

    "part 1 - input is 12 and 2" {
        calculateOutput(input, 12, 2) shouldBe listOf(2842648, 12, 2, 2, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 10, 1, 48, 1, 19, 6, 50, 2, 13, 23, 250, 1, 27, 13, 255, 1, 9, 31, 258, 1, 35, 9, 261, 1, 39, 5, 262, 2, 6, 43, 524, 1, 47, 6, 526, 2, 51, 9, 1578, 2, 55, 13, 7890, 1, 59, 6, 7892, 1, 10, 63, 7896, 2, 67, 9, 23688, 2, 6, 71, 47376, 1, 75, 5, 47377, 2, 79, 10, 189508, 1, 5, 83, 189509, 2, 9, 87, 568527, 1, 5, 91, 568528, 2, 13, 95, 2842640, 1, 99, 10, 2842644, 1, 103, 2, 2842646, 1, 107, 6, 0, 99, 2, 14, 0, 0)
    }

    "part 2" {
        val result = Day2.findInputPairToGetResult(input)
        result shouldBe (90 to 74)

    }
})
