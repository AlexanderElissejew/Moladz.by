package com.example.moladzby.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moladzby.R
import com.example.moladzby.databinding.FragmentDeatailsBinding
import com.example.moladzby.model.Article


class DeatailsFragment : Fragment() {

    private var _binding: FragmentDeatailsBinding? = null
    private val mBinding get() = _binding!!
    private val bundleArgs: DeatailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeatailsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val articleArguments = bundleArgs.article

        articleArguments.let {
           article ->
            article.urlToImage.let {
                Glide.with(this).load(article.urlToImage).into(mBinding.photoCardInside)
            }
            mBinding.photoCardInside.clipToOutline = true
            mBinding.articleDetailTitle.text = article.title
            mBinding.articleDetailText.text = article.description

            mBinding.sourceDetailed.setOnClickListener{
                try {
                    Intent()
                        .setAction(Intent.ACTION_VIEW)
                        .addCategory(Intent.CATEGORY_BROWSABLE)
                        .setData(Uri.parse(takeIf { URLUtil.isValidUrl(article.url)}
                            ?.let {
                            article.url } ?: "https://google.com"))
                                .let {
                                ContextCompat.startActivity(requireContext(), it, null)
                                }
                } catch (e: Exception){
                    Toast.makeText(context, "Отсутствует браузер", Toast.LENGTH_SHORT)
                }
            }
            _binding?.iconBack?.setOnClickListener {
                view.findNavController().navigate(
                    R.id.action_deatailsFragment_to_mainFragment,
                )
            }

            _binding?.iconShare?.setOnClickListener {
                val shareData = article.url
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareData)
                startActivity(Intent.createChooser(shareIntent, "Share url via"))

            }
        }

    }
}