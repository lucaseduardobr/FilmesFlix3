package com.br.natanfc.filmesflix.repository

import android.util.Log
import com.br.natanfc.filmesflix.api.MovieRestApiTask
import com.br.natanfc.filmesflix.model.Movie


//porta de acesso a nossa api ou nosso servidor de banco de dados
class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()


    fun getAllMovies(): List<Movie> {
        //chmando a funcao que estancia o retrofit
        //depois pegamos a rota (getAllMovies() )
        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()
        //checkand se deu tudo errado ou nao
        if (request.isSuccessful) {
            //body retorna a lista de filme
            request.body()?.let {
                //add a lista do body pro movieList
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }

        return movieList
    }


}