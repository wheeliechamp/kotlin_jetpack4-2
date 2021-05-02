package com.wheeliechamp.fragmentviewmodel6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wheeliechamp.fragmentviewmodel6.R
import com.wheeliechamp.fragmentviewmodel6.view.MainFragment
import com.wheeliechamp.fragmentviewmodel6.view.SubFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.linear_container, MainFragment.newInstance())
                .add(R.id.linear_container, SubFragment.newInstance())
                .commitNow()
        }
    }
}


