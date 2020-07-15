package com.technokratos.users.di

import com.technokratos.common.di.CommonApi
import com.technokratos.common.di.scope.FeatureScope
import com.technokratos.core_db.di.DbApi
import com.technokratos.feature_user_api.di.UserFeatureApi
import com.technokratos.users.UsersRouter
import com.technokratos.users.presentation.details.di.UserComponent
import com.technokratos.users.presentation.list.di.UsersComponent
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        UserFeatureDependencies::class
    ],
    modules = [
        UserFeatureModule::class
    ]
)
interface UserFeatureComponent : UserFeatureApi {

    fun usersComponentFactory(): UsersComponent.Factory

    fun userComponentFactory(): UserComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun router(usersRouter: UsersRouter): Builder

        fun withDependencies(deps: UserFeatureDependencies): Builder

        fun build(): UserFeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class,
            DbApi::class
        ]
    )
    interface UserFeatureDependenciesComponent : UserFeatureDependencies
}