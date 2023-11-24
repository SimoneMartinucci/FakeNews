package it.itsacademy.fakenews.ui.newspage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.itsacademy.fakenews.R
import it.itsacademy.fakenews.databinding.FragmentNewsPageBinding

class NewsPageFragment : Fragment() {

    private lateinit var binding : FragmentNewsPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsPageBinding.inflate(layoutInflater)
        return binding.root
    }

}