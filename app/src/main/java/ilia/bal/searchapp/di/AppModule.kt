package ilia.bal.searchapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ilia.bal.media_player.navigation.MediaPlayerFeatureAPi
import ilia.bal.search.data.local.RecipeDao
import ilia.bal.search.data.remote.SearchApiService
import ilia.bal.search.navigation.SearchFeatureApi
import ilia.bal.searchapp.local.AppDatabase
import ilia.bal.searchapp.navigation.NavigationSubGraphs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNavigationSubGraphs(
        searchFeatureApi: SearchFeatureApi,
        mediaPlayerFeatureAPi: MediaPlayerFeatureAPi
    ): NavigationSubGraphs {
        return NavigationSubGraphs(searchFeatureApi, mediaPlayerFeatureAPi)
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) = AppDatabase.getInstance(context)

    @Provides
    fun provideRecipeDao(appDatabase: AppDatabase): RecipeDao {
        return appDatabase.getRecipeDao()
    }
}


