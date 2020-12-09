package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.estrrado.tradopay.activity.MainActivity
import com.estrrado.tradopay.adapter.BannerViewPagerAdapter
import com.estrrado.tradopay.adapter.HomeItemsListAdapter
import com.estrrado.tradopay.listener.OnItemSelectedlistner
import com.estrrado.tradopay.viewmodel.HomeViewModel
import com.example.tradopay.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_home_banner.*
import kotlinx.android.synthetic.main.layout_home_banner.view.*
import me.huseyinozer.TooltipIndicator
import java.util.*

class HomeFragment : BaseFragment() {

    //private var vpBannerSlider: ViewPager?= null;
    private var homeViewModel: HomeViewModel? = null
    var headings = arrayOf(arrayOf("Delivery At Your Doorsteps", "Restaurants,Bakery,Grocery,Household Items and many other items", "Order Now"), arrayOf("Book Your Appointments", "Doctors,Car/Bike Wash & Service centers,, Saloons,Spa/Parlors,Gyms and other services", "Book Now"), arrayOf("Cashbacks and Offers", "View Cashbacks and Offers", "View All"))
    var images = intArrayOf(R.drawable.scty_grl, R.drawable.appoinmt, R.drawable.sale)


    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        //vpBannerSlider= root.findViewById(R.id.vpBannerSlider)
        var indicator: TooltipIndicator?  = root.findViewById(R.id.tooltip_indicator)
        var txtAdHead: TextView? = root.findViewById(R.id.txtAdHead)
        val rcvHomeItems: RecyclerView = root.findViewById(R.id.rcvHomeItems)
        rcvHomeItems.layoutManager = LinearLayoutManager(activity)
        if (txtAdHead != null) {
            txtAdHead.setText("Today's Top Deals")
        }
        val adapter = BannerViewPagerAdapter(requireActivity())
        root.vpBannerSlider.setAdapter(adapter)

        if (indicator != null) {
            indicator.setupViewPager(vpBannerSlider)
            indicator.setToolTipDrawables(Arrays.asList(
                    ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_top),
                    ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_bottom),
                    ContextCompat.getDrawable(requireActivity(), R.drawable.ic_launcher_background),
                    ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_top),
                    ContextCompat.getDrawable(requireActivity(), R.drawable.ic_login_bottom)
            ))
        }

        return root

    }

    override fun initListeners(view: View) {
        rcvHomeItems.adapter = HomeItemsListAdapter(object : OnItemSelectedlistner {
            override fun onItemClick(`object`: Any?, position: Int) {
                //  NavController controller = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

                //controller.navigate(R.id.action_home);
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, HomeListItemDetailFragment()).commit()
            }
        }, headings, images)

    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        Log.e("getActivity=", "" + activity)
        val activity = activity as MainActivity?
        val timer = Timer()
        timer.scheduleAtFixedRate(MyTimerTask(activity), 2000, 4000)
    }

    inner class MyTimerTask(var activity: MainActivity?) : TimerTask() {
        override fun run() {
            activity!!.runOnUiThread {
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
}