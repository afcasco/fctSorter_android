package com.example.fctsorter

import Empresa
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

const val ADDRESS = 2;
const val NAME = 0;
const val CITY = 4;
const val ZIP_CODE = 3;
const val PHONE = 5;

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cpStart = "172"

        val data = application.assets.open("empreses.csv").bufferedReader().use { it.readLines() }
        val result: Number;
        val pattern = Pattern.compile("-?\\d+(\\.\\d+)?")

        data.map { row->row.split(",") }
            .filter { row -> pattern.matcher(row[3]).matches() }
            .filter { row -> row[3].startsWith(cpStart) }
            .map { row -> Empresa(row[NAME],row[CITY],row[ZIP_CODE],row[PHONE],row[ADDRESS]) }
            .forEach(System.out::println)

        val btnZipCode: Button = findViewById(R.id.btnZipCode)
        btnZipCode.setOnClickListener {
            val li: LayoutInflater = LayoutInflater.from(this)
            val promptsView: View = li.inflate(R.layout.zip_prompt,null)

            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            alertDialogBuilder.setView(promptsView)

            //val userInput: EditText = findViewById(R.id.editTextDialogUserInput)

            alertDialogBuilder.setCancelable(true)
                .setPositiveButton("OK") { dialog, which -> setContentView(R.layout.activity_list) }

            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()

        }

        val btnCity: Button = findViewById(R.id.btnCity)
        btnCity.setOnClickListener {
            val li: LayoutInflater = LayoutInflater.from(this)
            val promptsView: View = li.inflate(R.layout.city_prompt,null)

            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            alertDialogBuilder.setView(promptsView)

          //  val userInput: EditText =  findViewById(R.id.editCity)


            alertDialogBuilder.setCancelable(true)
                .setPositiveButton("OK") { dialog, which ->
                    run {
                        val intent = Intent(this,ListActivity::class.java)
                        intent.putExtra("hola",0)
                        startActivity(intent)
                    }
                }

            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()



        }




    }
}