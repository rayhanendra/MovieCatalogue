package com.example.moviecatalogue.ui.menu.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.moviecatalogue.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        clearFragmentStack()
//        pager = binding.viewPager
//        tabs = binding.tabs
        val sectionsPagerAdapter = SectionsPagerAdapter(this, childFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        clearFragmentStack()
        pager = binding.viewPager
        tabs = binding.tabs
        val sectionsPagerAdapter = SectionsPagerAdapter(this, childFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }

//    private fun clearFragmentStack(){
//        val fm = this.childFragmentManager
//        for ( i in 0..fm.backStackEntryCount){
//            fm.popBackStack()
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    override fun onResume() {
//        super.onResume()
//        clearFragmentStack()
//        binding.viewPager.adapter = SectionsPagerAdapter(this, childFragmentManager)
//        binding.tabs.setupWithViewPager(binding.viewPager)
//    }
}