import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import java.io.File

private const val INPUT_FILE_PATH = "src/test/resources/Day1Input.txt"

class Day1Part1Test : StringSpec({

    "to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2" {
        forall(
            row(12, 2),
            row(14, 2),
            row(1969, 654),
            row(100756, 33583)
        ) { mass, fuelRequired ->
            Day1.getFuelRequiredForMass(mass) shouldBe fuelRequired
        }
    }

    "sum of test input" {
        val totalFuelRequired = readFileAsLines(INPUT_FILE_PATH)
            .map { it.toInt() }
            .sumBy { Day1.getFuelRequiredForMass(it) }

        totalFuelRequired shouldBe 3399947
    }
})

class Day1Part2Test : StringSpec({

    "include fuel needed to carry the fuel" {
        forall(
            row(12, 2),
            row(14, 2),
            row(1969, 966),
            row(100756, 50346)
        ) { mass, fuelRequired ->
            Day1.getFuelRequiredForMassIncludingFuel(mass) shouldBe fuelRequired
        }
    }

    "sum of test input" {
        val totalFuelRequired = readFileAsLines(INPUT_FILE_PATH)
            .map { it.toInt() }
            .sumBy { Day1.getFuelRequiredForMassIncludingFuel(it) }

        totalFuelRequired shouldBe 5097039
    }
})

fun readFileAsLines(fileName: String): List<String>
    = File(fileName).useLines { it.toList() }
