package com.example.ejemplohilo1.dinterfaces



class HiloPropioPRU3(var pelicula: String):ListenerDescarga2 {

    fun descargarPelicula(){
        var hilo = Thread(Runnable {
            println("Descargando película $pelicula")
            println("Esperando descarga de $pelicula")
            mientrasSeDescarga()
            Thread.sleep(5000)
            descargaFinalizada()
        })
        hilo.start()
    }

    override fun descargaFinalizada() {
        println("Descarga $pelicula finalizada")
        println("Puede darle play a la  $pelicula")
    }

    override fun mientrasSeDescarga() {
        println("Cargando...")
    }
}