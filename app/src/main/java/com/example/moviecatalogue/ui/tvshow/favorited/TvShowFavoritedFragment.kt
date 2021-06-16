package com.example.moviecatalogue.ui.tvshow.favorited

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.FragmentTvShowsFavoritedBinding
import com.example.moviecatalogue.ui.tvshow.TvShowAdapter
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class TvShowFavoritedFragment : Fragment() {

    private lateinit var binding: FragmentTvShowsFavoritedBinding
    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var viewModel: TvShowFavoritedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowsFavoritedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowFavoritedViewModel::class.java]

            tvShowAdapter = TvShowAdapter()

            binding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    binding.progressBar.visibility = View.GONE
                    tvShowAdapter.submitList(tvShows)
                    Log.d("ini nendra tvshows",tvShows.toString())
                }
            })
            with(binding.rvTvshow) {
                layoutManager = LinearLayoutManager(context)
                this.adapter = tvShowAdapter
            }
        }
    }

}