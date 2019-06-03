package com.example.mygames

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class RepositoryPartido(private val partidoDao: PartidoDao) {
    val allPartidos: LiveData<List<Partido>> = partidoDao.getllPartidos();

    @WorkerThread
    suspend fun insert(partido: Partido){
        partidoDao.insert(partido);
    }

    @WorkerThread
    suspend fun delete(partido: Partido){
        partidoDao.delete(partido);
    }

    @WorkerThread
    suspend fun getPartido(id: Int) : Partido {
        return partidoDao.getPartido(id);
    }

    @WorkerThread
    suspend fun DeleteAll(){
        partidoDao.deleteall();
    }


}