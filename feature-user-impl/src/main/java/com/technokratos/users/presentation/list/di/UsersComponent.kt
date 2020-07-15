package com.technokratos.users.presentation.list.di

import androidx.fragment.app.Fragment
import com.technokratos.common.di.scope.ScreenScope
import com.technokratos.users.presentation.list.UsersFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UsersModule::class
    ]
)
@ScreenScope
interface UsersComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment
        ): UsersComponent
    }

    fun inject(fragment: UsersFragment)
}