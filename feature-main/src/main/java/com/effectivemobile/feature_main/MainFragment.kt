package com.effectivemobile.feature_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.effectivemobile.core.openLink
import com.effectivemobile.core.toast
import com.effectivemobile.domain.models.OfferModel
import com.effectivemobile.domain.models.VacancyModel
import com.effectivemobile.feature_main.databinding.FragmentMainBinding
import com.effectivemobile.feature_main.rececleView.offers.OffersAdapter
import com.effectivemobile.feature_main.rececleView.vacancies.VacancyAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private var binding: FragmentMainBinding? = null
    private var offersAdapter: OffersAdapter? = null
    private var vacancyAdapter: VacancyAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.error = { message ->
            requireContext().toast(message)
        }
        viewModel.isInProgress.observe(viewLifecycleOwner) { isLoad ->
            binding?.run {
                if (isLoad) {
                    progressBar.visibility = View.VISIBLE
                } else progressBar.visibility = View.GONE
            }
        }
        viewModel.jobState.observe(viewLifecycleOwner) { jobSate ->
            if (jobSate.offers.isNotEmpty()) {
                binding?.offersRecycleView?.visibility = View.VISIBLE
                initRecommendationAdapter(jobSate.offers)
            } else binding?.offersRecycleView?.visibility = View.GONE
            initVacancyAdapter(jobSate.vacancies)
        }
    }

    private fun initRecommendationAdapter(items: List<OfferModel>) {
        binding?.run {
            offersRecycleView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            offersAdapter = OffersAdapter { link: String ->
                requireContext().openLink(link)
            }.also {
                offersRecycleView.adapter = it
            }
            offersAdapter?.submitList(items)
        }
    }

    private fun initVacancyAdapter(items: List<VacancyModel>) {
        binding?.run {
            vacancyRecycleView.layoutManager = LinearLayoutManager(requireContext())
            vacancyAdapter = VacancyAdapter(
                onFavoriteClick = { isFavorite ->
                    TODO()
                },
                onClick = { id ->
                    TODO()
                }
            ).also {
                vacancyRecycleView.adapter = it
            }
            vacancyAdapter?.submitList(items)
        }
    }
}