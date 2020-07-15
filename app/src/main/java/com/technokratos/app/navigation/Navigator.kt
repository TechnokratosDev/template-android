package com.technokratos.app.navigation

import android.content.Context
import androidx.navigation.NavController
import com.technokratos.app.MainActivity
import com.technokratos.app.R
import com.technokratos.splash.SplashRouter
import com.technokratos.users.UsersRouter
import com.technokratos.users.presentation.details.UserFragment

class Navigator : UsersRouter, SplashRouter {

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

    override fun openUser(userId: Int) {
        navController?.navigate(R.id.userFragment, UserFragment.createBundle(userId))
    }

    override fun returnToUsers() {
        navController?.popBackStack()
    }

    override fun openMain(context: Context) {
        MainActivity.start(context)
    }
}