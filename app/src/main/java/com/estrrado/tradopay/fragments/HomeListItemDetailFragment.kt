package com.estrrado.tradopay.fragments

import com.example.tradopay.R
import android.os.Bundle
import com.estrrado.tradopay.fragments.HomeListItemDetailFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.estrrado.tradopay.helpers.ItemOffsetDecoration
import com.estrrado.tradopay.adapter.HomeDetailedrRoundItemAdapter
import com.estrrado.tradopay.listener.OnItemSelectedlistner
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import com.estrrado.tradopay.activity.HomeDetailedActivity
import com.estrrado.tradopay.adapter.HomeItemsListAdapter
import kotlinx.android.synthetic.main.fragment_home_item_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeListItemDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeListItemDetailFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    var images_detail = intArrayOf(R.drawable.rest, R.drawable.bak, R.drawable.groc,
            R.drawable.frut, R.drawable.book, R.drawable.cloth, R.drawable.elec, R.drawable.medi)
    var headings_detail = arrayOf("Restaurants", "Bakery", "Groceries", "Fruits &\nVegetables",
            "Books", "Cloths", "Electronics", "Medicines")
    var headings = arrayOf(arrayOf("Delivery At Your Doorsteps", "Restaurants,Bakery,Grocery," +
            "Household Items and many other items", "Order Now"), arrayOf("Book Your Appointments",
            "Doctors,Car/Bike Wash & Service centers,, Saloons,Spa/Parlors,Gyms and other services",
            "Book Now"), arrayOf("Cashbacks and Offers", "View Cashbacks and Offers", "View All"))
    var images = intArrayOf(R.drawable.scty_grl, R.drawable.appoinmt, R.drawable.sale)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
          /*  mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)*/
        }
    }

    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        val view = inflater.inflate(R.layout.fragment_home_detail, container, false)
        val rcvItems: RecyclerView = view.findViewById(R.id.rcvItems)
        val rcvHomeItems: RecyclerView = view.findViewById(R.id.rcvHomeItemsDetail)
        rcvItems.layoutManager = GridLayoutManager(activity, 4)
        rcvHomeItems.layoutManager = LinearLayoutManager(activity)
        rcvItems.addItemDecoration(ItemOffsetDecoration(2))
        rcvItems.adapter = HomeDetailedrRoundItemAdapter(object : OnItemSelectedlistner {
            override fun onItemClick(`object`: Any?, position: Int) {
                startActivity(Intent(activity, HomeDetailedActivity::class.java))
            }
        }, headings_detail, images_detail)

        return view
    }

    override fun initListeners(view: View) {
        rcvHomeItems.adapter = HomeItemsListAdapter(object : OnItemSelectedlistner {
            override fun onItemClick(`object`: Any?, position: Int) {
                // Toast.makeText(getContext(),"Clicked",Toast.LENGTH_LONG).show();
                // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeItemDetailChildFragment()).commit();
            }
        }, headings, images)
    }

    override fun initObservers() {
        TODO("Not yet implemented")
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
        fun newInstance(param1: String?, param2: String?): HomeListItemDetailFragment {
            val fragment = HomeListItemDetailFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}