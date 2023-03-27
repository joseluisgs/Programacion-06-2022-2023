package secuencias

fun main() {
    // creación de secuencias
    val sec1 = sequenceOf(1, 2, 3, 4, 5)
    sec1.forEach { println(it) }

    val sec2 = listOf(1, 2, 3, 4, 5).asSequence()

    val sec3 = generateSequence(1) { it + 1 }
    sec3.take(5).forEach { println(it) }

    // todos los numeros de fibonacci
    val fib = generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }
    fib.take(10).toList().forEach { println(it) }

    // todos los numeros pares
    val pares = generateSequence(0) { it + 2 }
    pares.take(10).forEach { println(it) }

    // todos los numeros primos
    val primos = generateSequence(2) {
        var n = it + 1
        while (!isPrime(n)) {
            n++
        }
        n
    }
    primos.take(10).forEach { println(it) }

    // yield / yieldAll
    // supende la ejecución de la secuencia hasta que se vuelva a llamar
    val sec4 = sequence {
        yield(1)
        yieldAll(listOf(2, 3, 4, 5))
        yieldAll(generateSequence(6) { it + 1 })
    }

    sec4.take(10).forEach { println(it) }

    val fibonacci = sequence {
        var terms = Pair(0, 1)
        while (true) {
            yield(terms.first)
            terms = Pair(terms.second, terms.first + terms.second)
        }
    }
    println(fibonacci.take(10).toList())

    val primes = sequence {
        var number = 2
        while (true) {
            if (isPrime(number)) yield(number)
            number++
        }
    }
    println(primes.take(10).toList())
}

fun isPrime(n: Int): Boolean {
    for (i in 2..n / 2) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}
