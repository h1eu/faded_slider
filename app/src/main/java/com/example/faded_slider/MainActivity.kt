package com.example.faded_slider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SnapHelper
import com.example.faded_slider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var obAdapter: OnBoardingAdapter? = null

    private var snapHelper: SnapHelper? = null

    private var obList = listOf<OnBoardingModel>()

    private var isScroll = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setWindowInsetListener()
        initData()
        initRvObListImage()
    }

    private fun initRvObListImage() {
        binding.rvOnBoarding.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = obAdapter
            snapHelper?.attachToRecyclerView(this)
            obAdapter?.submitList(obList)
//            val halfSc = resources.displayMetrics.widthPixels / 3
//            this.setOnScrollChangeListener { view, _, _, _, _ ->
//                val offset = this.computeHorizontalScrollOffset()
//                val range = this.computeHorizontalScrollRange()/ obList.size
//                if (offset % range == 0) {
//                    view.alpha = 1f
//                } else {
//                    view.alpha = 0.5f
//                }
//            }
        }
    }

    private fun addFadeAnimScroll() {


    }

    private fun initData() {
        obAdapter = OnBoardingAdapter()
        snapHelper = SlowSnapHelper(this, 150f)
        obList = listOf(
            OnBoardingModel(
                index = INDEX_START,
                ivResource = R.drawable.ic_ob_start,
                title = getString(R.string.text_title_1),
                description = getString(R.string.text_description_1),
            ),
            OnBoardingModel(
                index = INDEX_MID,
                ivResource = R.drawable.ic_ob_start,
                title = getString(R.string.text_title_2),
                description = getString(R.string.text_description_2),
            ),
            OnBoardingModel(
                index = INDEX_END,
                ivResource = R.drawable.ic_ob_start,
                title = getString(R.string.text_title_3),
                description = getString(R.string.text_description_3),
            )
        )
    }

    private fun setWindowInsetListener() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    companion object {
        const val INDEX_START = 0
        const val INDEX_MID = 1
        const val INDEX_END = 2
    }

}