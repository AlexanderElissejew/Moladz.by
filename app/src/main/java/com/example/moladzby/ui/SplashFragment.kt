package com.example.moladzby.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moladzby.R
import com.example.moladzby.databinding.FragmentDeatailsBinding
import com.example.moladzby.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {


    private var _binding: FragmentSplashBinding? = null
    private val mBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

}