package com.wmsswj.damnsinglebook.model.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wmsswj.damnsinglebook.controller.fragment.OneFragment
import com.wmsswj.damnsinglebook.controller.fragment.ThreeFragment
import com.wmsswj.damnsinglebook.controller.fragment.TowFragment

class MyPageAdapter(fm: FragmentManager, private val num: Int) : FragmentPagerAdapter(fm) {
    private val mFragmentHashMap = hashMapOf<Int, Fragment?>()

    override fun getItem(position: Int): Fragment? {

        return createFragment(position)
    }

    override fun getCount(): Int {
        return num
    }

    private fun createFragment(pos: Int): Fragment? {
        var fragment = mFragmentHashMap[pos]

        if (fragment == null) {
            when (pos) {
                0 -> {
                    fragment = OneFragment()
                }
                1 -> {
                    fragment = TowFragment()
                }
                2 -> {
                    fragment = ThreeFragment()
                }
            }
            mFragmentHashMap[pos] = fragment
        }
        return fragment
    }
}
