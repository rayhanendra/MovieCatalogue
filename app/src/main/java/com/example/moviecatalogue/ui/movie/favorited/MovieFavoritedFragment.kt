package com.example.moviecatalogue.ui.movie.favorited

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.databinding.FragmentMoviesFavoritedBinding
import com.example.moviecatalogue.ui.movie.MovieAdapter
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class MovieFavoritedFragment : Fragment() {

    private lateinit var binding: FragmentMoviesFavoritedBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewModel: MovieFavoritedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesFavoritedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieFavoritedViewModel::class.java]

            movieAdapter = MovieAdapter()

            binding.progressBar.visibility = View.VISIBLE

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    binding.progressBar.visibility = View.GONE
                    movieAdapter.submitList(movies)
                    movieAdapter.notifyDataSetChanged()
                    binding.rvMovie.adapter = movieAdapter
                    Log.d("ini nendra movies",movies.toString())

                }
            })

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
            }

//            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
//                if (movies != null) {
//                    when (movies.status) {
//                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
//                        Status.SUCCESS -> {
//                            binding.progressBar.visibility = View.GONE
//                            adapter.submitList(movies.data)
//                        }
//                        Status.ERROR -> {
//                            binding.progressBar.visibility = View.GONE
//                            Toast.makeText(context, "Something is error", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//            })
//            with(binding.rvMovie) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                this.adapter = adapter
//            }
        }
    }

}