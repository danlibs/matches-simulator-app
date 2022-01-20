package com.danlibs.soccersimulator.ui

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.danlibs.soccersimulator.databinding.ActivityDetailBinding
import com.danlibs.soccersimulator.domain.Match
import java.lang.StringBuilder

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    object Extras {
        const val MATCH = "EXTRA_MATCH"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra() {
        intent?.extras?.getParcelable<Match>(Extras.MATCH)?.let {
            Glide.with(this).load(it.place.image).into(binding.ivPlace)
            supportActionBar?.title = it.place.name
            binding.tvDescription.text = it.description

            Glide.with(this).load(it.homeTeam.image).into(binding.ivHomeTeam)
            binding.tvHomeTeamName.text = it.homeTeam.name
            binding.rbHomeTeamStars.rating = it.homeTeam.strength.toFloat()
            if (it.homeTeam.score != null) {
                binding.tvHomeTeamScore.text = it.homeTeam.score.toString()
            }
            val builderHome = SpannableStringBuilder()
            it.homeTeam.players.forEach { player -> builderHome.append(player + "\n") }
            binding.tvHomePlayers.text = builderHome

            Glide.with(this).load(it.awayTeam.image).into(binding.ivAwayTeam)
            binding.tvAwayTeamName.text = it.awayTeam.name
            binding.rbAwayTeamStars.rating = it.awayTeam.strength.toFloat()
            if (it.homeTeam.score != null) {
                binding.tvAwayTeamScore.text = it.awayTeam.score.toString()
            }
            val builderAway = SpannableStringBuilder()
            it.awayTeam.players.forEach { player -> builderAway.append(player + "\n") }
            binding.tvAwayPlayers.text = builderAway

        }
    }
}