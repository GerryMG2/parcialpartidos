package com.example.mygames

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface PartidoDao {

    @Query(value = "SELECT * FROM PARTIDOS ORDER BY FECHA ASC")
    fun getllPartidos(): LiveData<List<Partido>>

    @Insert
    suspend fun insert(partido: Partido)

    @Delete
    suspend fun delete(partido: Partido)

    @Query("SELECT * FROM PARTIDOS WHERE ID = :id ")
    suspend fun getPartido(id: Int): Partido

    @Query("DELETE FROM PARTIDOS")
    suspend fun deleteall()

}