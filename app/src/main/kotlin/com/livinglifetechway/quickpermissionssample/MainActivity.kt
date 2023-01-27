package com.livinglifetechway.quickpermissionssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.livinglifetechway.quickpermissionssample.databinding.ActivityMainBinding
import org.jetbrains.anko.startActivity
import com.livinglifetechway.quickpermissionssample.AllKotlinActivity

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
