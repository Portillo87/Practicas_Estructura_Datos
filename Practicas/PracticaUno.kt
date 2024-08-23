fun main() {
    println("Ingrese el primer número:")
    val numeroUno = readLine()?.toDoubleOrNull()

    println("Ingrese el segundo número:")
    val numeroDos = readLine()?.toDoubleOrNull()

    println("Ingrese la operación (+, -, *, /, ^):")
    val operacion = readLine()

    if (numeroUno == null || numeroDos == null || operacion.isNullOrBlank()) {
        println("Error: Ingrese números válidos y una operación válida.")
        return
    }

    val resultado = when (operacion) {
        "+" -> numeroUno + numeroDos
        "-" -> numeroUno - numeroDos
        "*" -> numeroUno * numeroDos
        "/" -> {
            if (numeroDos == 0.0) {
                println("Error: División por cero no permitida.")
                return
            }
            numeroUno / numeroDos
        }
        "^" -> Math.pow(numeroUno, numeroDos)
        else -> {
            println("Operación no reconocida.")
            return
        }
    }
    println("El resultado de la operación $numeroUno $operacion $numeroDos es $resultado")
}