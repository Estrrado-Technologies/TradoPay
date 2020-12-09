package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.estrrado.tradopay.activity.HomeDetailedActivity
import com.estrrado.tradopay.adapter.*
import com.estrrado.tradopay.helpers.ItemOffsetDecoration
import com.estrrado.tradopay.listener.OnItemSelectedlistner
import com.example.tradopay.R
import kotlinx.android.synthetic.main.fragment_homedetail_child.view.*
import kotlinx.android.synthetic.main.layout_home_banner.view.*
import me.huseyinozer.TooltipIndicator
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeItemDetailChildFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeItemDetailChildFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    var vpBannerSlider: ViewPager? = null
    var griditems: RecyclerView? = null
    var rcvofferList: RecyclerView? = null
    var rcvTrendingList: RecyclerView? = null
    var itemList: RecyclerView? = null
    var rcvAds: RecyclerView? = null
    var images = intArrayOf(
        R.drawable.puttu,
        R.drawable.prawns_biriyani,
        R.drawable.burger,
        R.drawable.alcohol,
        R.drawable.puttu
    )
    var imagAds = intArrayOf(R.drawable.chat, R.drawable.scty)
    var headings_cusin =
        arrayOf(" South Indian", "Biriyani", "Burger", "Bevereges", " South Indian")
    var headings_ads = arrayOf("Booking Appoinments Made Easy", "Order Anything From Anywhere")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
          //  mParam1 = arguments!!.getString(ARG_PARAM1)
          //  mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_homedetail_child, container, false)
        val adapter = BannerViewPagerAdapter(requireActivity())
        vpBannerSlider = view.findViewById(R.id.vpBannerSlider)
        val txtAdHead = view.findViewById<TextView>(R.id.txtAdHead)
        griditems = view.findViewById(R.id.griditems)
        rcvofferList = view.findViewById(R.id.rcvofferList)
        rcvAds = view.findViewById(R.id.rcvAds)
        rcvTrendingList = view.findViewById(R.id.rcvTrendingList)
        itemList = view.findViewById(R.id.itemList)
        txtAdHead.text = ""
        txtAdHead.visibility = View.GONE
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val linearLayoutManager_rcvOffers =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val linearLayoutManager_trending =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val linearLayoutManager_ads = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val linearLayoutManagerMain = LinearLayoutManager(context)
        view.griditems.setLayoutManager(linearLayoutManager)
        view.griditems.addItemDecoration(ItemOffsetDecoration(2))
        view.rcvofferList.setLayoutManager(linearLayoutManager_rcvOffers)
        view.rcvTrendingList.setLayoutManager(linearLayoutManager_trending)
        view.itemList.setLayoutManager(linearLayoutManagerMain)
        view.rcvAds.setLayoutManager(linearLayoutManager_ads)
        view.rcvTrendingList.addItemDecoration(ItemOffsetDecoration(10))
        view.rcvAds.addItemDecoration(ItemOffsetDecoration(5))
        view.rcvofferList.addItemDecoration(ItemOffsetDecoration(10))
        view.rcvAds.setAdapter(HomeDetaildChildAdsAdapter(object : OnItemSelectedlistner {
            override fun onItemClick(`object`: Any?, position: Int) {}
        }, headings_ads, imagAds))
        val homeDetailOfferAdapter = HomeDetailOfferAdapter(object : OnItemSelectedlistner {
            override fun onItemClick(`object`: Any?, position: Int) {}
        })
        view.rcvofferList.setAdapter(homeDetailOfferAdapter)
        view.rcvTrendingList.setAdapter(homeDetailOfferAdapter)
        view.itemList.setAdapter(HomeItemDetailChildMainListAdapter(object : OnItemSelectedlistner {
            override fun onItemClick(`object`: Any?, position: Int) {}
        }))
        view.griditems.setAdapter(HomeItemsDetailAdapter(object : OnItemSelectedlistner {
            override fun onItemClick(`object`: Any?, position: Int) {}
        }, headings_cusin, images))
        //HomeDetailOfferAdapter
        view.vpBannerSlider.setAdapter(adapter)
        val indicator: TooltipIndicator = view.findViewById(R.id.tooltip_indicator)
        indicator.setupViewPager(vpBannerSlider)
        indicator.setToolTipDrawables(
            Arrays.asList(
                ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_top),
                ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_bottom),
                ContextCompat.getDrawable(requireActivity(), R.drawable.ic_launcher_background),
                ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_top),
                ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_bottom)
            )
        )
        val timer = Timer()
        val activity = activity as HomeDetailedActivity?
        timer.scheduleAtFixedRate(MyTimerTask(activity), 2000, 4000)
        return view
    }

    inner class MyTimerTask(var activity: HomeDetailedActivity?) : TimerTask() {
        override fun run() {
            activity?.runOnUiThread {
                if (vpBannerSlider!!.currentItem == 0) {
                    vpBannerSlider!!.currentItem = 1
                } else if (vpBannerSlider!!.currentItem == 1) {
                    vpBannerSlider!!.currentItem = 2
                } else {
                    vpBannerSlider!!.currentItem = 0
                }
            }
        }
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeItemDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): HomeItemDetailChildFragment {
            val fragment = HomeItemDetailChildFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}