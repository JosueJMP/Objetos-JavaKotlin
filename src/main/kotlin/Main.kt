package org.example

import java.util.Scanner
import kotlin.math.PI
import kotlin.math.pow
import kotlin.random.Random

fun main() {
    val sc = Scanner(System.`in`)
    var opcion: Int

    do {
        println("\nMenú:")
        for (i in 1..14) {
            println("$i. Ejercicio $i")
        }
        println("0. Salir")
        print("Elige una opción: ")
        opcion = sc.nextInt()
        sc.nextLine()  // Limpiar el buffer

        when (opcion) {
            1 -> ejercicio1(sc)
            2 -> ejercicio2(sc)
            3 -> ejercicio3(sc)
            4 -> ejercicio4(sc)
            5 -> ejercicio5(sc)
            6 -> ejercicio6()
            7 -> ejercicio7(sc)
            8 -> ejercicio8(sc)
            9 -> ejercicio9(sc)
            10 -> ejercicio10(sc)
            11 -> ejercicio11(sc)
            12 -> ejercicio12(sc)
            13 -> ejercicio13(sc)
            14 -> ejercicio14(sc)
            0 -> println("Hasta la vista ....")
            else -> println("Opción no válida.")
        }
    } while (opcion != 0)
}

fun ejercicio1(sc: Scanner) {
    print("Ingresa tu nombre: ")
    val nombre = sc.nextLine()
    println("¡Hola, $nombre!")
}

fun ejercicio2(sc: Scanner) {
    print("Ingresa un número: ")
    val numero = sc.nextInt()
    if (numero % 2 == 0) {
        println("El número es par.")
    } else {
        println("El número es impar.")
    }
}

fun ejercicio3(sc: Scanner) {
    print("Ingresa el radio del círculo: ")
    val radio = sc.nextDouble()
    val area = PI * radio.pow(2)
    println("El área del círculo es: $area")
}

fun ejercicio4(sc: Scanner) {
    val rand = Random.Default
    val numeroAleatorio = rand.nextInt(1, 101)
    var intento: Int

    do {
        print("Adivina el número (entre 1 y 100): ")
        intento = sc.nextInt()
        when {
            intento < numeroAleatorio -> println("El número es mayor.")
            intento > numeroAleatorio -> println("El número es menor.")
        }
    } while (intento != numeroAleatorio)

    println("¡Correcto! El número era $numeroAleatorio")
}

fun ejercicio5(sc: Scanner) {
    print("Ingresa un número: ")
    val numero = sc.nextInt()

    for (i in 1..10) {
        println("$numero x $i = ${numero * i}")
    }
}

fun ejercicio6() {
    val suma = (1..100).sum()
    println("La suma de los números del 1 al 100 es: $suma")
}

fun ejercicio7(sc: Scanner) {
    print("Ingresa una cadena: ")
    val cadena = sc.nextLine()
    val reverso = cadena.reversed()
    println("El reverso de la cadena es: $reverso")
}

fun ejercicio8(sc: Scanner) {
    print("Ingresa una frase: ")
    val frase = sc.nextLine().lowercase()
    val contador = frase.count { it in "aeiou" }
    println("La frase contiene $contador vocales.")
}

fun ejercicio9(sc: Scanner) {
    print("Introduce un número: ")
    val numero = sc.nextInt()
    val esPrimo = numero > 1 && (2..Math.sqrt(numero.toDouble()).toInt()).none { numero % it == 0 }
    if (esPrimo) {
        println("$numero es un número primo.")
    } else {
        println("$numero no es un número primo.")
    }
}

fun ejercicio10(sc: Scanner) {
    var opcion: Int
    do {
        println("Qué conversor quiere utilizar:")
        println("1. De Celsius a Fahrenheit")
        println("2. De Fahrenheit a Celsius")
        println("3. Salir")
        print("Elige una opción: ")
        opcion = sc.nextInt()
        sc.nextLine()  // Limpiar el buffer

        when (opcion) {
            1 -> aFahrenheit(sc)
            2 -> aCelsius(sc)
            3 -> println("Saliendo...")
            else -> println("Opción no válida. Intente nuevamente.")
        }
    } while (opcion != 3)
}

fun aFahrenheit(sc: Scanner) {
    print("Ingrese temperatura en Celsius: ")
    val celsius = sc.nextDouble()
    val fahrenheit = (celsius * 9 / 5) + 32
    println("Temperatura en Fahrenheit: $fahrenheit")
}

fun aCelsius(sc: Scanner) {
    print("Ingrese temperatura en Fahrenheit: ")
    val fahrenheit = sc.nextDouble()
    val celsius = (fahrenheit - 32) * 5 / 9
    println("Temperatura en Celsius: $celsius")
}

fun ejercicio11(sc: Scanner) {
    print("Ingresa el número N para la secuencia de Fibonacci: ")
    val n = sc.nextInt()

    if (n <= 0) {
        println("Por favor, ingrese un número positivo.")
    } else {
        println("Los primeros $n números de la secuencia de Fibonacci son:")
        var a = 0
        var b = 1
        print("$a ")
        for (i in 1 until n) {
            print("$b ")
            val temp = a
            a = b
            b += temp
        }
        println()
    }
}

fun ejercicio12(sc: Scanner) {
    print("Introduce un número de más de 2 dígitos: ")
    val numero = sc.nextInt()
    println("Su número invertido es: ${numero.toString().reversed()}")
}

fun ejercicio13(sc: Scanner) {
    println("Procedemos a crear un Objeto tipo Anime")
    print("Introduce el nombre del anime: ")
    val nombre = sc.nextLine()
    print("Introduce el número de episodios: ")
    val numeroEpisodios = sc.nextInt()
    sc.nextLine()
    print("Introduce el género del anime: ")
    val genero = sc.nextLine()
    val anime1 = Anime(nombre, numeroEpisodios, genero)
    println("Se ha creado exitosamente el anime: $anime1")
}

fun ejercicio14(sc: Scanner) {
    val inventario = mutableListOf<Videojuego>()
    var opcion: Int

    do {
        println("\nMenú de Inventario de Videojuegos:")
        println("1. Añadir videojuego")
        println("2. Eliminar videojuego")
        println("3. Mostrar inventario")
        println("4. Salir del inventario")
        print("Elige una opción: ")
        opcion = sc.nextInt()
        sc.nextLine()  // Limpiar el buffer

        when (opcion) {
            1 -> {
                print("Introduce el título del videojuego: ")
                val titulo = sc.nextLine()
                print("Introduce la plataforma del videojuego: ")
                val plataforma = sc.nextLine()
                print("Introduce las horas jugadas: ")
                val horasJugadas = sc.nextInt()
                sc.nextLine()

                inventario.add(Videojuego(titulo, plataforma, horasJugadas))
                println("Videojuego añadido con éxito.")
            }
            2 -> {
                print("Introduce el título del videojuego a eliminar: ")
                val tituloEliminar = sc.nextLine()
                val eliminado = inventario.removeIf { it.titulo.equals(tituloEliminar, ignoreCase = true) }
                if (eliminado) {
                    println("Videojuego eliminado con éxito.")
                } else {
                    println("No se encontró un videojuego con ese título.")
                }
            }
            3 -> {
                if (inventario.isEmpty()) {
                    println("El inventario está vacío.")
                } else {
                    println("Inventario de Videojuegos:")
                    inventario.forEach { println(it) }
                }
            }
            4 -> println("Saliendo del inventario...")
            else -> println("Opción no válida.")
        }
    } while (opcion != 4)
}


