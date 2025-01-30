package com.effectivemobile.feature_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.effectivemobile.core.openLink
import com.effectivemobile.core.toast
import com.effectivemobile.feature_main.databinding.FragmentMainBinding
import com.effectivemobile.feature_main.generalAdapter.MainAdapter
import com.effectivemobile.feature_main.models.MainScreenViews
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private var binding: FragmentMainBinding? = null
    private var mainAdapter: MainAdapter? = null

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
        viewModel.mainScreenElements.observe(viewLifecycleOwner) { screenElements ->
            initAdapter(screenElements)
        }
    }

    private fun initAdapter(items: List<MainScreenViews>) {
        binding?.run {
            generalRecycleView.layoutManager = LinearLayoutManager(requireContext())
            mainAdapter = MainAdapter(
                onClickOffers = { link: String ->
                    requireContext().openLink(link)
                },
                onClickVacancy = { id ->
                    TODO()
                },
                onFavoriteClickVacancy = { isFavorite ->
                    TODO()
                },
                showAllVacancies = { isShow ->
                    viewModel.setIsShowAllVacancies(isShow)
                }
            ).also {
                generalRecycleView.adapter = it
            }
            mainAdapter?.setItems(items)
        }
    }
}