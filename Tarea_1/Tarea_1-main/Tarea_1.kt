// Tarea
// Crear un ejercicio, implementaras un sistema en Kotlin que clasifica y manipula números enteros
// dentro de un rango especificado. El objetivo es identificar números primos, pares e impares, y
// realizar operaciones específicas sobre cada tipo de número utilizando clases e interfaces.

interface IBaseNumber {
    val value: Int
    fun printValue()
}

class PrimeNumber(override val value: Int) : IBaseNumber {
    override fun printValue() {
        println("Prime number: $value")
    }
}

class OddNumber(override val value: Int) : IBaseNumber {
    val divisors: List<Int> = findDivisors(value)

    override fun printValue() {
        println("Odd number: $value, Divisors: $divisors")
    }

    private fun findDivisors(num: Int): List<Int> {
        return (1..num).filter { num % it == 0 }
    }
}

class EvenNumber(override val value: Int) : IBaseNumber {
    val divisors: List<Int> = findDivisors(value)

    override fun printValue() {
        println("Even number: $value, Divisors: $divisors")
    }

    private fun findDivisors(num: Int): List<Int> {
        return (1..num).filter { num % it == 0 }
    }
}

class PrimeNumberProcessor(private val range: IntRange) {
    private val primes = mutableListOf<PrimeNumber>()
    private val odds = mutableListOf<OddNumber>()
    private val evens = mutableListOf<EvenNumber>()

    fun processNumbers() {
        for (number in range) {
            when {
                isPrime(number) -> primes.add(PrimeNumber(number))
                number % 2 == 0 -> evens.add(EvenNumber(number))
                else -> odds.add(OddNumber(number))
            }
        }
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }

    fun printResults() {
        primes.forEach { it.printValue() }
        evens.forEach { it.printValue() }
        odds.forEach { it.printValue() }
    }
}

fun main() {
    val processor = PrimeNumberProcessor(1..50)
    processor.processNumbers()
    processor.printResults()
}
