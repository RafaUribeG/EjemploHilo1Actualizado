package com.example.ejemplohilo1.abasico

fun main(){

    /*
    for (i in 1.. 5){
        var seg:Long = 5000
        var time = seg/1000
        crearHilo(i, time)
    }
    */

    for(i in 1..5) {
        var hilo = Thread(Runnable {
            println("HILO SECUNDARIO $i")
            println("HILO SECUNDARIO $i DORMIDO POR 5 SEGUNDOS")
            Thread.sleep(5000)
            println("HILO SECUNDARIO $i HA TERMINADO")
        })
        hilo.start()
    }

}





/*hilo principal
    println("HILO PRINCIPAL")
    println("ESPERANDO 3 SEGUNDOS EL HILO PRINCIPAL")
    Thread.sleep(3000)//SIMULACION DE UNA DESCARGA DE IMAGEN DE 10MB
    println("TERMINÓ EL HILO PRINCIPAL")
    hilo principal*/

/*
crearHilo(1,2000)//descargar una pelicula
crearHilo(2, 5000)//descargar las imagenes de la interfaz
crearHilo(3,3000)//leyendo las palabras y subrayandolas con rojo
 */


/*
fun crearHilo(num:Int, dormir:Long){

    for(i in 1..5) {
        var hilo = Thread(Runnable {
            println("HILO SECUNDARIO $i")
            println("HILO SECUNDARIO $i DORMIDO POR $dormir SEGUNDOS")
            Thread.sleep(dormir)
            println("HILO SECUNDARIO $i HA TERMINADO")
        })
        hilo.start()
    }
}

 */