package org.example

class Videojuego (
    val titulo: String,
    val plataforma: String,
    val horasJugadas: Int
){
    override fun toString(): String {
        return "Videojuego(titulo='$titulo', plataforma='$plataforma', horasJugadas=$horasJugadas)"
    }
}