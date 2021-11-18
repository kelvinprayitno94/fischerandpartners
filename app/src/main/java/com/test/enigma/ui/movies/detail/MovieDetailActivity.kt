package com.test.enigma.ui.movies.detail

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import com.test.enigma.base.BaseKoinActivityBinding
import com.test.enigma.base.loadImageUrl
import com.test.enigma.base.setGone
import com.test.enigma.base.setVisible
import com.test.enigma.databinding.ActivityMovieDetailBinding
import com.test.enigma.util.ID_ARGS
import com.test.enigma.util.ScrollViewExt
import com.test.enigma.util.ScrollViewListener
import com.test.enigma.util.ViewStateModel
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_list.progressBarMovieList
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MovieDetailActivity : BaseKoinActivityBinding<ActivityMovieDetailBinding>(),
    ScrollViewListener {
    private val movieDetailViewModel: MovieDetailViewModel by inject {
        parametersOf(this)
    }

    private val movieReviewAdapter: MovieReviewAdapter by inject {
        parametersOf(this)
    }

    private var page = 1
    val id = 0

    override val bindingInflater: (LayoutInflater) -> ActivityMovieDetailBinding
        get() = ActivityMovieDetailBinding::inflate

    override fun setupView(binding: ActivityMovieDetailBinding) {
        setupYoutubePlayer(binding)

        initEvent(binding)
        initObserver(binding)

        recyclerViewMovieReview.run {
            adapter = movieReviewAdapter
            layoutManager =
                GridLayoutManager(this@MovieDetailActivity, 2, LinearLayoutManager.VERTICAL, false)
        }

        nestedScrollViewMovieDetail.setScrollViewListener(this)

        val id = intent.getIntExtra(ID_ARGS, 0)

        movieDetailViewModel.getMovieDetail(id)
        movieDetailViewModel.getMovieVideo(id)
        movieDetailViewModel.getMovieReview(page, id)
    }

    private fun initObserver(binding: ActivityMovieDetailBinding) {
        movieDetailViewModel.movieDetailLiveData.observe(this@MovieDetailActivity)
        {
            binding.imageViewMovieDetailPoster.loadImageUrl(it.posterPath, this@MovieDetailActivity)
            binding.textViewMovieDetailName.text = it.title
            binding.textViewMovieDetailGenres.text = it.genres.toString()
            binding.textViewMovieDetailOverview.text = it.overview
            binding.textViewMovieDetailReleaseDate.text = it.releaseDate
            binding.textViewMovieDetailRuntime.text = "${it.runtime} Minutes"
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

        movieDetailViewModel.movieReviewLiveData.observe(this@MovieDetailActivity)
        {
            if (page > 1) {
                movieReviewAdapter.addList(it.results)
            } else
                movieReviewAdapter.updateList(it.results)

            page += 1
        }

        movieDetailViewModel.viewStateLiveData.observe(this@MovieDetailActivity)
        {
            when (it) {
                ViewStateModel.LOADING -> {
                    progressBarMovieList.setVisible()
                }
                ViewStateModel.FAILED -> {
                    progressBarMovieList.setGone()

                    Toast.makeText(
                        this@MovieDetailActivity,
                        "Informasi film tidak tersedia",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()
                }
                ViewStateModel.SUCCESS -> {
                    progressBarMovieList.setGone()
                }
            }
        }
    }

    private fun initEvent(binding: ActivityMovieDetailBinding) {

    }

    override fun onScrollChanged(scrollView: ScrollViewExt?, x: Int, y: Int, oldx: Int, oldy: Int) {
        val view = scrollView?.getChildAt(scrollView.childCount - 1) as View
        val diff = view.bottom - (scrollView.height + scrollView.scrollY)

        if (diff == 0) {
            movieDetailViewModel.getMovieReview(page, id)
        }
    }
}