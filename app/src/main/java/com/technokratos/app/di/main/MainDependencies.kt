package com.technokratos.app.di.main

import com.technokratos.app.di.deps.ComponentDependencies
import com.technokratos.app.navigation.Navigator

interface MainDependencies : ComponentDependencies {

    fun navigator(): Navigator
}