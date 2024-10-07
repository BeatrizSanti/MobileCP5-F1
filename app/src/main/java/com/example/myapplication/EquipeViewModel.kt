package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EquipeViewModel : ViewModel() {
    val equipeList: MutableLiveData<MutableList<Equipe>> = MutableLiveData(mutableListOf())

    fun addEquipe(equipe: Equipe) {
        val currentList = equipeList.value?.toMutableList() ?: mutableListOf()
        currentList.add(equipe)
        equipeList.value = currentList
    }

    fun removeEquipe(equipe: Equipe) {
        val currentList = equipeList.value?.toMutableList() ?: mutableListOf()
        currentList.remove(equipe)
        equipeList.value = currentList
    }
}

data class Equipe(val nome: String, val piloto1: String, val numeroPiloto1: String, val piloto2: String,val numeroPiloto2: String) {
    val nomeEquipes: CharSequence? = null
}