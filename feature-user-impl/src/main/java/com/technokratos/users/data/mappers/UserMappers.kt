package com.technokratos.users.data.mappers

import com.technokratos.core_db.model.UserLocal
import com.technokratos.feature_user_api.domain.model.User
import com.technokratos.users.data.network.model.UserRemote

fun mapUserToUserLocal(user: User): UserLocal {
    return with(user) {
        UserLocal(id, firstName, lastName)
    }
}

fun mapUserLocalToUser(user: UserLocal): User {
    return with(user) {
        User(id, firstName, lastName)
    }
}

fun mapUserRemoteToUser(user: UserRemote): User {
    return with(user) {
        User(id, firstName, lastName)
    }
}