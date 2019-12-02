object Day2 {

    fun findInputPairToGetResult(input: List<Int>): Pair<Int, Int>? {
        return sequence {
            for (i in input.indices) {
                for (j in input.indices) {
                    yield(i to j)
                }
            }
        }.find { calculateOutput(input, it.first, it.second)[0] == 19690720 }
    }

    fun calculateOutput(input: List<Int>, overwrite1: Int? = null, overwrite2: Int? = null): List<Int> {
        val output = input.toMutableList()

        if (overwrite1 != null) output[1] = overwrite1
        if (overwrite2 != null) output[2] = overwrite2

        output.asSequence().windowed(4, 4, true).forEach { program ->

            val opCode = getOpCode(program[0])
            if (opCode == Opcode.FINISHED || opCode == Opcode.ERROR) {
                return@forEach
            }
            val inputIndex1 = program[1]
            val inputIndex2 = program[2]
            val outputIndex = program[3]
            when (opCode) {
                Opcode.ADD -> output[outputIndex] = output[inputIndex1] + output[inputIndex2]
                Opcode.MULTIPLY -> output[outputIndex] = output[inputIndex1] * output[inputIndex2]
                else -> return@forEach
            }
        }
        return output
    }

    private fun getOpCode(opcodeInt: Int): Opcode =
        when (opcodeInt) {
            1 -> Opcode.ADD
            2 -> Opcode.MULTIPLY
            99 -> Opcode.FINISHED
            else -> Opcode.ERROR
        }

    enum class Opcode { ADD, MULTIPLY, FINISHED, ERROR }
}
