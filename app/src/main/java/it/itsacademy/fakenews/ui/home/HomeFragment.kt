package it.itsacademy.fakenews.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.itsacademy.fakenews.R
import it.itsacademy.fakenews.core.viewmodel.HomeViewModel
import it.itsacademy.fakenews.databinding.FragmentHomeBinding
import it.itsacademy.fakenews.ui.home.adapter.HomeRowAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val homeViewModel : HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.postLiveData.observe(this){rowList ->
            with(binding){
                homeRecyclerview.run {
                    adapter = HomeRowAdapter(rowList)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.loadPost()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }


}