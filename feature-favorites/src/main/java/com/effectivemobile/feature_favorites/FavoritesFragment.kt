package com.effectivemobile.feature_favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.effectivemobile.core.models.GeneralScreenViews
import com.effectivemobile.core.navigator.navigate
import com.effectivemobile.core.utils.toast
import com.effectivemobile.feature_favorites.mainAdapter.FavoriteMainAdapter
import com.effectivemobile.feature_favourites.databinding.FragmentFavoritesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment() {

    private val viewModel: FavoritesViewModel by viewModel()
    private var binding: FragmentFavoritesBinding? = null
    private var adapter: FavoriteMainAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
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
        viewModel.screenViews.observe(viewLifecycleOwner) { screenViews ->
            if (screenViews.isNotEmpty()) {
                initAdapter(screenViews)
            }
        }
    }

    private fun initAdapter(screenViews: List<GeneralScreenViews>) {
        binding?.run {
            favoriteRecycleView.layoutManager = LinearLayoutManager(requireContext())
            adapter = FavoriteMainAdapter(
                onClick = { id ->
                    this@FavoritesFragment.navigate().goToDetailsFromMain(id)
                },
                onFavoriteClick = { id, isFavorite ->
                    viewModel.addToFavorite(id, isFavorite)
                }
            ).also {
                favoriteRecycleView.adapter = it
            }
            adapter?.setItems(screenViews)
        }
    }
}