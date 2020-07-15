package com.technokratos.splash.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.technokratos.common.di.FeatureUtils
import com.technokratos.common.utils.EventObserver
import com.technokratos.splash.di.SplashFeatureApi
import com.technokratos.splash.di.SplashFeatureComponent
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FeatureUtils.getFeature<SplashFeatureComponent>(this, SplashFeatureApi::class.java)
            .splashComponentFactory()
            .create(this)
            .inject(this)

        splashViewModel.openUsersEvent.observe(this, EventObserver {
            splashViewModel.openMain(this)
            finish()
        })
    }
}