package com.arjunlalith.buildingthemonolith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Week4Fragment : Fragment() {
    private lateinit var daysPagerAdapter: DaysPagerAdapter
    private lateinit var viewPager: ViewPager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_week4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        daysPagerAdapter = DaysPagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.days_pager)
        viewPager.adapter = daysPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.tabLayout)
        tabs.setupWithViewPager(viewPager)
    }
    inner class DaysPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            when(position) {
                0 -> {
                    return Week4MondayFragment()
                }
                1 -> {
                    return Week4WednesdayFragment()
                }
                2 -> {
                    return Week4FridayFragment()
                }
                else -> return null
            }
        }
        override fun getCount(): Int {
            return 3
        }
        override fun getPageTitle(position: Int): CharSequence? {
           when(position) {
               0-> return "Monday"
               1-> return "Wednesday"
               2-> return "Friday"
           }
           return null
        }
    }
}