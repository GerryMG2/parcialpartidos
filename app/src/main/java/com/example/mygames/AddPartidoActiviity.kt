package com.example.mygames


import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.text.SimpleDateFormat


class AddPartidoActiviity : AppCompatActivity(){

    private lateinit var btnadd3_1: Button
    private lateinit var btnrest3_1: Button
    private lateinit var btnadd2_1: Button
    private lateinit var btnrest2_1: Button
    private lateinit var btnadd1_1 : Button
    private lateinit var btnrest1_1: Button

    private lateinit var btnadd3_2: Button
    private lateinit var btnrest3_2: Button
    private lateinit var btnadd2_2: Button
    private lateinit var btnrest2_2: Button
    private lateinit var btnadd1_2 : Button
    private lateinit var btnrest1_2: Button

    private lateinit var total1 : TextView
    private lateinit var total2: TextView

    private lateinit var tres_1: TextView;
    private lateinit var dos_1: TextView
    private lateinit var uno_1: TextView
    private lateinit var tres_2: TextView;
    private lateinit var dos_2: TextView
    private lateinit var uno_2: TextView

    private lateinit var fechap : DatePicker
    private lateinit var fecha: TextView
    private lateinit var btnadd: Button

    private lateinit var partido: Partido

    private lateinit var nameequipo1: TextView
    private lateinit var nameequipo2: TextView


    private var total3_equipo1: Int = 0
    private var total2_equipo1: Int = 0
    private var total1_equipo1: Int = 0
    private var total3_equipo2: Int = 0
    private var total2_equipo2: Int = 0
    private var total1_equipo2: Int = 0

    private var total1_number: Int = 0
    private var total2_number: Int = 0


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addpartido)
        nameequipo1 = findViewById(R.id.EquipoName1p)
        nameequipo2 = findViewById(R.id.EquipoName2p)

        total1 = findViewById(R.id.totalEquipo1p)
        total2 = findViewById(R.id.totalEquipo2p)

        tres_1 = findViewById(R.id.puntos_tres_equipo1p)
        tres_2 = findViewById(R.id.puntos_tres_equipo2p)
        dos_1 = findViewById(R.id.puntos_dos_equipo1p)
        dos_2 = findViewById(R.id.puntos_dos_equipo2p)
        uno_1 = findViewById(R.id.puntos_uno_equipo1p)
        uno_2 = findViewById(R.id.puntos_uno_equipo2p)

        fechap = findViewById(R.id.fechapi)
        fecha = findViewById(R.id.fechagamep)

        btnadd3_1 = findViewById(R.id.puntos3_add_equipo1)
        btnadd3_1.setOnClickListener {
            total3_equipo1 += 1;
            tres_1.text = total3_equipo1.toString();
            total1_number += 3;
            total1.text = total1_number.toString();

        }

        btnadd3_2 = findViewById(R.id.puntos3_add_equipo2)
        btnadd3_2.setOnClickListener {
            total3_equipo2 += 1;
            tres_2.text = total3_equipo2.toString()
            total2_number += 3
            total2.text = total2_number.toString()
        }
        btnadd2_1 = findViewById(R.id.puntos2_add_equipo1)
        btnadd2_1.setOnClickListener {
            total2_equipo1 += 1
            dos_1.text = total2_equipo1.toString()
            total1_number += 2;
            total1.text = total1_number.toString()
        }
        btnadd2_2 = findViewById(R.id.puntos2_add_equipo2)
        btnadd2_2.setOnClickListener {
            total2_equipo2 += 1;
            dos_2.text = total2_equipo2.toString()
            total2_number += 2;
            total2.text = total2_number.toString()
        }
        btnadd1_1 = findViewById(R.id.puntos1_add_equipo1)
        btnadd1_1.setOnClickListener {
            total1_equipo1 += 1
            uno_1.text = total1_equipo1.toString()
            total1_number += 1;
            total1.text = total1_number.toString();
        }
        btnadd1_2 = findViewById(R.id.puntos1_add_equipo2)
        btnadd1_2.setOnClickListener {
            total1_equipo2 += 1;
            uno_2.text = total1_equipo2.toString()
            total2_number += 1;
            total2.text = total2_number.toString()
        }
        btnrest3_1 = findViewById(R.id.puntos3_rest_equipo1)
        btnrest3_1.setOnClickListener {
            total3_equipo1 -= 1;
            tres_1.text = total3_equipo1.toString();
            total1_number -= 3;
            total1.text = total1_number.toString();

        }
        btnrest3_2 = findViewById(R.id.puntos3_rest_equipo2)
        btnrest3_2.setOnClickListener {
            total3_equipo2 -= 1;
            tres_2.text = total3_equipo2.toString()
            total2_number -= 3
            total2.text = total2_number.toString()
        }
        btnrest2_1 = findViewById(R.id.puntos2_rest_equipo1)
        btnrest2_1.setOnClickListener {
            total2_equipo1 -= 1
            dos_1.text = total2_equipo1.toString()
            total1_number -= 2;
            total1.text = total1_number.toString()
        }
        btnrest2_2 = findViewById(R.id.puntos2_rest_equipo2)
        btnrest2_2.setOnClickListener{
            total2_equipo2 -= 1;
            dos_2.text = total2_equipo2.toString()
            total2_number -= 2;
            total2.text = total2_number.toString()
        }
        btnrest1_1 = findViewById(R.id.puntos1_rest_equipo1)
        btnrest1_1.setOnClickListener{
            total1_equipo1 -= 1
            uno_1.text = total1_equipo1.toString()
            total1_number -= 1;
            total1.text = total1_number.toString();
        }
        btnrest1_2 = findViewById(R.id.puntos1_rest_equipo2)
        btnrest1_2.setOnClickListener{
            total1_equipo2 -= 1;
            uno_2.text = total1_equipo2.toString()
            total2_number -= 1;
            total2.text = total2_number.toString()
        }




        btnadd = findViewById(R.id.addbtn)

        btnadd.setOnClickListener {
            val day = fechap.getDayOfMonth()
            val month = fechap.getMonth()
            val year = fechap.getYear()
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)

            val sdf = SimpleDateFormat("dd-MM-yyyy")
            val formatedDate = sdf.format(calendar.time)
            val date = sdf.parse(formatedDate).toString()
            val replyIntent = Intent()
            partido = Partido(nameequipo1.text.toString(),nameequipo2.text.toString(),date)

            this.partido.puntos_tres_equipo1 = total3_equipo1
            this.partido.puntos_tres_equipo2 = total3_equipo2
            this.partido.puntos_dos_equipo1 = total2_equipo1
            this.partido.puntos_dos_equipo2 = total2_equipo2
            this.partido.puntos_uno_equipo1 = total1_equipo1
            this.partido.puntos_uno_equipo2 = total1_equipo2


            replyIntent.putExtra(EXTRA_REPLY, this.partido)
            setResult(Activity.RESULT_OK, replyIntent)
            finish()

        }





    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

}