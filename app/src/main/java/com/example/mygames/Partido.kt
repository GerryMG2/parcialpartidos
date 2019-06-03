package com.example.mygames

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "PARTIDOS")
class Partido(@ColumnInfo(name = "nameEquipo1") val nameEquipo1: String,
              @ColumnInfo(name = "nameEquipo2")  val nameEquipo2: String,
              @ColumnInfo(name = "fecha")  val fecha: String) : Parcelable {




    @PrimaryKey(autoGenerate = true)
    var id: Int = 0;

    @ColumnInfo(name = "puntos_tres_equipo1")
    var puntos_tres_equipo1: Int = 0;

    @ColumnInfo(name = "puntos_dos_equipo1")
    var puntos_dos_equipo1: Int = 0;

    @ColumnInfo(name = "puntos_uno_equipo1")
    var puntos_uno_equipo1: Int = 0;

    @ColumnInfo(name = "puntos_tres_equipo2")
    var puntos_tres_equipo2: Int = 0;

    @ColumnInfo(name = "puntos_dos_equipo2")
    var puntos_dos_equipo2: Int = 0;

    @ColumnInfo(name = "puntos_uno_equipo2")
    var puntos_uno_equipo2: Int = 0;

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        TODO("fecha")
    ) {
        puntos_tres_equipo1 = parcel.readInt()
        puntos_dos_equipo1 = parcel.readInt()
        puntos_uno_equipo1 = parcel.readInt()
        puntos_tres_equipo2 = parcel.readInt()
        puntos_dos_equipo2 = parcel.readInt()
        puntos_uno_equipo2 = parcel.readInt()
    }


    fun total_equipo1(): Int {
        return (puntos_tres_equipo1 * 3) + (puntos_dos_equipo1 * 2 ) + puntos_uno_equipo1
    }

    fun add3_equipo1() {
        puntos_tres_equipo1 += 1
    }

    fun add2_equipo1() {
        puntos_dos_equipo1 += 1
    }

    fun add1_equipo1() {
        puntos_uno_equipo1 += 1
    }

    fun rest3_equipo1() {
        puntos_tres_equipo1 -= 1
    }
    fun rest2_equipo1() {
        puntos_dos_equipo1 -= 1
    }
    fun rest1_equipo1() {
        puntos_uno_equipo1 -= 1
    }






    fun total_equipo2(): Int {
        return (puntos_tres_equipo2 * 3) + (puntos_dos_equipo2 * 2 ) + puntos_uno_equipo2
    }

    fun add3_equipo2() {
        puntos_tres_equipo2 += 1
    }

    fun add2_equipo2() {
        puntos_dos_equipo2 += 1
    }

    fun add1_equipo2() {
        puntos_uno_equipo2 += 1
    }

    fun rest3_equipo2() {
        puntos_tres_equipo2 -= 1
    }
    fun rest2_equipo2() {
        puntos_dos_equipo2 -= 1
    }
    fun rest1_equipo2() {
        puntos_uno_equipo2 -= 1
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nameEquipo1)
        parcel.writeString(nameEquipo2)
        parcel.writeInt(puntos_tres_equipo1)
        parcel.writeInt(puntos_dos_equipo1)
        parcel.writeInt(puntos_uno_equipo1)
        parcel.writeInt(puntos_tres_equipo2)
        parcel.writeInt(puntos_dos_equipo2)
        parcel.writeInt(puntos_uno_equipo2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Partido> {
        override fun createFromParcel(parcel: Parcel): Partido {
            return Partido(parcel)
        }

        override fun newArray(size: Int): Array<Partido?> {
            return arrayOfNulls(size)
        }
    }
}