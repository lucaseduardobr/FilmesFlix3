package com.br.natanfc.filmesflix.viewmode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.model.Movie

class MovieListViewModel : ViewModel(){

    private val listOfMovies = arrayListOf(
        Movie(
            0,
            "Titanic",
            null,
            null,
            null

        ),
        Movie(
            1,
            "Velozes e furiosos",
            null,
            null,
            null

        )
    )
    //lista de de movies que eh um dataclasse
    //que eh uma classe de dados que fornece
    //a estrutura para criar objetos (olhar dataclass Movie)

    //preciso proteger meus dados
    private var _moviesList = MutableLiveData<List<Movie>>()
    //mas tenho que observa-lo
    //por isso eu observo somente o livedata
    //se ele mudar o mutablelivedata mudou
    //e eu posso buscar o valor da lista no
    //mutablelivedata
    val  moviesList : LiveData<List<Movie>>
    get() = _moviesList

    fun init(){

        getAllMovies()

    }

    private fun getAllMovies(){
        //prrenchendo nosso moviesList
        _moviesList.value = listOfMovies

    }

}