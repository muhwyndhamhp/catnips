package io.muhwyndhamhp.catnip.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object LocalModule {

    @Provides
    fun provideUserDao(appDatabase: AppDatabase) = appDatabase.userDao()

    @Provides
    fun provideCatDao(appDatabase: AppDatabase) = appDatabase.catDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext applicationContext: Context) =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "CatNipDatabase"
        )
            .allowMainThreadQueries()
            .build()
}