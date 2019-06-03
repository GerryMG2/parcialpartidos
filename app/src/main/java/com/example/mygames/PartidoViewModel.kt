package com.example.mygames

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch

class PartidoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RepositoryPartido;

    val allPartidos: LiveData<List<Partido>>;

    init {
        val partidoDao = RoomPartido.getDatabase(application).getPartidoDao();
        repository = RepositoryPartido(partidoDao);
        allPartidos = repository.allPartidos;
    }

    fun insert(partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido);
    }

    fun delete(partido: Partido) = viewModelScope.launch(Dispatchers.IO)  {
        repository.delete(partido);
    }

    fun deleteall() = viewModelScope.launch(Dispatchers.IO){
        repository.DeleteAll();
    }

    suspend fun getPartidoById(id: Int): Partido  {
        return repository.getPartido(id)
    }



}