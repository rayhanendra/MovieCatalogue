package com.example.moviecatalogue.ui.menu.ui.favorited

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.moviecatalogue.databinding.FragmentFavoritedBinding
import com.google.android.material.tabs.TabLayout

class FavoritedFragment : Fragment() {

    private var _binding: FragmentFavoritedBinding? = null
    private lateinit var pager: ViewPager
    private lateinit var tabs: TabLayout

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFavoritedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val fragmentManager = requireActivity().supportFragmentManager
        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), fragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pager = binding.viewPager
        tabs = binding.tabs

        val fragmentManager = requireActivity().supportFragmentManager
        val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), fragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}