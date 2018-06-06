package com.githang.badgedrawable

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import com.githang.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val badge = ResourcesCompat.getDrawable(resources, R.drawable.badge_stroke_white, null)!!
        val icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)!!
        val badgeDrawable = BadgeDrawable(icon, badge)
        toggle_badge.setCompoundDrawablesWithIntrinsicBounds(badgeDrawable, null, null, null)
        toggle_badge.setOnClickListener {
            badgeDrawable.showBadge = !badgeDrawable.showBadge
        }
    }
}
