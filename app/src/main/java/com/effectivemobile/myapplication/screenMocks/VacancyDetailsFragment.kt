package com.effectivemobile.myapplication.screenMocks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.effectivemobile.myapplication.R
import com.effectivemobile.myapplication.databinding.FragmentVacancyDetailsBinding

class VacancyDetailsFragment : Fragment() {

    private val arguments: VacancyDetailsFragmentArgs by navArgs()
    private var binding: FragmentVacancyDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVacancyDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.detailsTitle?.text = getString(R.string.details_fragment_title, arguments.id)
    }
}