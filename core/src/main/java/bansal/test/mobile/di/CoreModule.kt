package de.zalando.lounge.di

import android.arch.persistence.room.Room
import android.content.Context
import bansal.test.mobile.data.room.DB_NAME
import bansal.test.mobile.data.room.ProtoAppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    fun database(context: Context): ProtoAppDatabase {
        return Room.databaseBuilder(context, ProtoAppDatabase::class.java, DB_NAME)
            .build()
    }
}
