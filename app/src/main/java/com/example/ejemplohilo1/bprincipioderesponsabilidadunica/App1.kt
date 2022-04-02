package com.example.ejemplohilo1.bprincipioderesponsabilidadunica

fun main(){

    var lista: ArrayList<HiloPropioPRU> = ArrayList()
    var hilo = HiloPropioPRU()

    for (i in 1..5) {
        hilo.crearHilo(i, 2000)
        println("$hilo")
    }

    for (i in 1..5){
        lista.add(hilo)
        println("$i hilos agregados")
    }







    /*
    var hilo1 = HiloPropioPRU()
    hilo1.crearHilo(1,5000)

    var hilo2 = HiloPropioPRU()
    hilo2.crearHilo(2,7000)
     */
}