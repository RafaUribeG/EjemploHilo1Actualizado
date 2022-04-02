package com.example.ejemplohilo1.cinterfaces

class HiloPropioPRU2(var pelicula:String) {

    fun descargarPelicula(listener: ListenerDescarga){
        var hilo = Thread(Runnable {
            println("Descargando película $pelicula")
            listener.mientrasSeDescarga()
            //Thread.sleep(5000)
            listener.descargaFinalizada()
        })
        hilo.start()
    }

}