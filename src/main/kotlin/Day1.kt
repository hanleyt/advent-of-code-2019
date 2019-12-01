object Day1 {

    fun getFuelRequiredForMass(mass: Int): Int {
        return (mass / 3) - 2
    }

    fun getFuelRequiredForMassIncludingFuel(mass: Int): Int {
        val fuelRequiredForMass = getFuelRequiredForMass(mass)
        return if (fuelRequiredForMass <= 0) {
            0
        } else {
            fuelRequiredForMass + getFuelRequiredForMassIncludingFuel(fuelRequiredForMass)
        }
    }
}
