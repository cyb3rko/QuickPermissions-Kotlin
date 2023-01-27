package com.livinglifetechway.quickpermissions_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.livinglifetechway.quickpermissions_sample.databinding.ActivityMainBinding
import com.livinglifetechway.quickpermissions_sample.kotlin.AllKotlinActivity
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        mBinding.buttonKotlinAll.setOnClickListener {
            startActivity<AllKotlinActivity>()
        }
        setContentView(mBinding.root)
    }
}
