package com.example.ejemplohilo1.eactivity

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.ejemplohilo1.R

private const val TAG = "ESTADO"

class MainActivity : AppCompatActivity() {

    lateinit var txtHilo1: TextView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btnIniciarHiloBloqueado:Button = findViewById(R.id.btnIniciar)
        var btnHiloSegundoPlano:Button = findViewById(R.id.btnIniciar2)
        var btnIniciarHiloSecundarioPlanoUI:Button = findViewById(R.id.btnIniciarHiloSecundarioPlanoUI)
        var btnIniciarHiloSecundarioPlanoAsynTask:Button = findViewById(R.id.btnIniciarHiloSecundarioPlanoAsyncTask)
         progressBar = findViewById(R.id.progressBar)
            txtHilo1 = findViewById(R.id.txtHilo1)

        btnIniciarHiloBloqueado.setOnClickListener {
            bloquearHilo()
        }

        btnHiloSegundoPlano.setOnClickListener {
            creaHiloSecundario()
        }

        btnIniciarHiloSecundarioPlanoUI.setOnClickListener {
            crearHiloSecundarioUI()
        }

        btnIniciarHiloSecundarioPlanoAsynTask.setOnClickListener {
            var hilo = Hilo()
            hilo.execute()
        }
    }



    //Simula una carga pesada en la actividad
    fun bloquearHilo(){
        for (i in 0..20){
            Thread.sleep(1000)
            Log.e("trabajo hilo", "Iteración: $i")
        }
    }

    //hilo secundario - simular un error en la interfaz
    fun creaHiloSecundario(){
        var h = Thread(Runnable {
            for (i in 0..20){
                Thread.sleep(1000)
                Log.e("trabajo hilo secundario", "Iteración: $i")
                Toast.makeText(this, "Iteración: $i ", Toast.LENGTH_SHORT).show()

            }
        })
        h.start()
    }

    //hilo secundario - con comunicación UI
    private fun crearHiloSecundarioUI() {
        var h = Thread(Runnable {
            for (i in 0..20){
                Thread.sleep(1000)
                Log.e("trabajo hilo secundario", "Iteración: $i")
                runOnUiThread(Runnable {
                    Toast.makeText(this, "Iteración: $i ", Toast.LENGTH_SHORT).show()
                })
            }
        })
        h.start()
    }

    inner class Hilo:AsyncTask<Int, Int, String>(){
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Int?): String {
            txtHilo1.text = "Hilo inicia..."
            publishProgress()
            return ""
        }

        override fun onProgressUpdate(vararg values: Int?) {
            progressBar.visibility = View.VISIBLE
            Thread.sleep(10000)
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            progressBar.visibility = View.GONE
            Toast.makeText(applicationContext, "Completado", Toast.LENGTH_SHORT).show()
            super.onPostExecute(result)
        }

    }

}