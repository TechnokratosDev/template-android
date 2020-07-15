package com.technokratos.core_db.di

import com.technokratos.core_db.AppDatabase

interface DbApi {

    fun provideDatabase(): AppDatabase
}