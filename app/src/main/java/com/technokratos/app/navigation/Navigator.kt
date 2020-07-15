package com.technokratos.app.navigation

import android.content.Context
import androidx.navigation.NavController
import com.technokratos.app.MainActivity
import com.technokratos.splash.SplashRouter

class Navigator : SplashRouter {

    private var navController: NavController? = null

    fun attachNavController(navController: NavController, graph: Int) {
        navController.setGraph(graph)
        this.navController = navController
    }

    fun detachNavController(navController: NavController) {
        if (this.navController == navController) {
            this.navController = null
        }
    }

    override fun openMain(context: Context) {
        MainActivity.start(context)
    }
}