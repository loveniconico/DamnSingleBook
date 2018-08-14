package com.wmsswj.damnsinglebook

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.wmsswj.damnsinglebook.controller.fragment.TabFragment
import com.wmsswj.damnsinglebook.model.sql.RunningAccount
import com.wmsswj.damnsinglebook.model.sql.RunningAccountDAO
import com.wmsswj.damnsinglebook.model.util.ContextUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, TabFragment.OnFragmentInteractionListener {
    private var page = 0
    private var mDB: RunningAccountDAO? = null

    override fun onFragmentInteraction(uri: Uri) {
        Log.i("TAG", uri.toString())

        page = uri.getQueryParameter("page").toInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "当前是$page", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

        }

        mDB = RunningAccount.getInstance(this)?.RunningAccountDAO()

        initFragment()

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    @SuppressLint("CommitTransaction")
    private fun initFragment() {
        @SuppressLint("CommitTransaction")
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = TabFragment()
        fragmentTransaction.add(R.id.mainFragment, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> {
                ContextUtil(this).toast("设置")
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
