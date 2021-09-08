package com.br.natanfc.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.natanfc.filmesflix.model.Movie
import com.br.natanfc.filmesflix.viewmode.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*
        //correspondente aos componentes visuais
class MainActivity : AppCompatActivity() {
    //oi

    private lateinit var movieListViewModel: MovieListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadingVisibility(true)

    }
    //a lista ta vindo de moviesList
    private fun initObserver(){
        movieListViewModel.moviesList.observe(this,  { list ->
            if(list.isNotEmpty()){
                loadingVisibility(false)
                populateList(list)
            }



        })
    }
    //ta falando que todos os itens do movie
    //list tem o mesmo tamanho
    //e que o adapter recebe aquilo
    private fun populateList(list: List<Movie>){
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)

        }
    }

    private fun loadingVisibility(isLoading:Boolean){
        progress_bar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }



}