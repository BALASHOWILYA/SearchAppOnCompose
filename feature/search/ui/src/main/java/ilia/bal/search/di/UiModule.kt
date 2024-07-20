package ilia.bal.search.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ilia.bal.search.navigation.SearchFeatureApi
import ilia.bal.search.navigation.SearchFeatureApiImpl

@InstallIn(SingletonComponent::class)
@Module
object UiModule {


    @Provides
    fun provideSearchFeatureApi(): SearchFeatureApi {
        return SearchFeatureApiImpl()
    }

}