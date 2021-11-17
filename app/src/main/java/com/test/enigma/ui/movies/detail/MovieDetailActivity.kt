package com.test.enigma.ui.movies.detail

import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.test.enigma.base.BaseKoinActivityBinding
import com.test.enigma.base.loadImageUrl
import com.test.enigma.base.setGone
import com.test.enigma.base.setVisible
import com.test.enigma.databinding.ActivityMovieDetailBinding
import com.test.enigma.util.ID_ARGS
import com.test.enigma.util.ViewStateModel
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.activity_movie_list.progressBarMovieList
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MovieDetailActivity : BaseKoinActivityBinding<ActivityMovieDetailBinding>() {
    private val movieDetailViewModel: MovieDetailViewModel by inject {
        parametersOf(this)
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMovieDetailBinding
        get() = ActivityMovieDetailBinding::inflate

    override fun setupView(binding: ActivityMovieDetailBinding) {
        setupYoutubePlayer(binding)

        initEvent(binding)
        initObserver(binding)

        movieDetailViewModel.getMovieDetail(intent.getIntExtra(ID_ARGS, 0))
        movieDetailViewModel.getMovieVideo(intent.getIntExtra(ID_ARGS, 0))
    }

    private fun initObserver(binding: ActivityMovieDetailBinding) {
        movieDetailViewModel.movieDetailLiveData.observe(this@MovieDetailActivity)
        {
            binding.imageViewMovieDetailPoster.loadImageUrl(it.posterPath, this@MovieDetailActivity)
            binding.textViewMovieDetailName.text = it.title
            binding.textViewMovieDetailGenres.text = it.genres.toString()
            binding.textViewMovieDetailOverview.text= it.overview
            binding.textViewMovieDetailReleaseDate.text= it.releaseDate
            binding.textViewMovieDetailRuntime.text= "${it.runtime} Minutes"
        }

        movieDetailViewModel.movieVideoLiveData.observe(this@MovieDetailActivity)
        {
            youtubePlayerView.getYouTubePlayerWhenReady(object : YouTubePlayerCallback {
                override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                    val videoId = it.results[0].key
                    youTubePlayer.loadVideo(videoId, 0f)
                }

            })
        }

        movieDetailViewModel.viewStateLiveData.observe(this@MovieDetailActivity)
        {
            when (it) {
                ViewStateModel.LOADING -> {
                    progressBarMovieList.setVisible()
                }
                ViewStateModel.FAILED -> {
                    progressBarMovieList.setGone()
                }
                ViewStateModel.SUCCESS -> {
                    progressBarMovieList.setGone()
                }
            }
        }
    }

    private fun initEvent(binding: ActivityMovieDetailBinding) {

    }
}