package com.br.natanfc.filmesflix.viewmode

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.api.MovieRestApiTask
import com.br.natanfc.filmesflix.model.Movie
import com.br.natanfc.filmesflix.repository.MovieRepository
import com.br.natanfc.filmesflix.repository.MovieRepository.Companion.TAG
//Regra de negocio
class MovieListViewModel : ViewModel(){

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

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



    private fun getAllMovies() {
        Thread {
            try {
                //prrenchendo nosso moviesList
                //postValues eh quando nao se sabe quando
                //ele vai retornar o valor
                //consulta api nao deve ser usada na tread principal
                _moviesList.postValue(movieRepository.getAllMovies())

            } catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }





}