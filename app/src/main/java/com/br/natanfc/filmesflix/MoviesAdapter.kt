package com.br.natanfc.filmesflix

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.br.natanfc.filmesflix.model.Movie
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MoviesAdapter(private val moviesList:List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        // Maneira burra de fazer
    // holder.itemView.movieTitle.text = moviesList[position].titulo
        //maneira inteligente
        holder.itemView.apply {
            movieTitle.text = moviesList[position].titulo
            //para pegar imagem
            movieImage.load(moviesList[position].imagem){
                //enquanto renderiza a imagem
                //ele mostra outra imagem
                placeholder(R.drawable.ic_baseline_image_24)
                //se caso ela falhar
                fallback(R.drawable.ic_baseline_image_24)


            }
        }

    }
    //quando so tem uma linha e esta eh um retorno
    //podemos fazer isso
    override fun getItemCount(): Int =  moviesList.size

}