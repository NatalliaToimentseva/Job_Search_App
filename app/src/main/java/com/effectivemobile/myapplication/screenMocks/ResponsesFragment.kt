package com.effectivemobile.myapplication.screenMocks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.effectivemobile.myapplication.databinding.FragmentResponsesBinding

class ResponsesFragment : Fragment() {

    private var binding: FragmentResponsesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResponsesBinding.inflate(inflater, container, false)
        return binding?.root
    }
}