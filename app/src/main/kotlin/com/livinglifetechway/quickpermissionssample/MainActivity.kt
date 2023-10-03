package com.livinglifetechway.quickpermissionssample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.livinglifetechway.quickpermissionssample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        mBinding.buttonKotlinAll.setOnClickListener {
            startActivity(Intent(this, AllKotlinActivity::class.java))
        }
        setContentView(mBinding.root)
    }
}
