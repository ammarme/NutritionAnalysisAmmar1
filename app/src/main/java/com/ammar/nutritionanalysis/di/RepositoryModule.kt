package com.ammar.nutritionanalysis.di

import com.ammar.nutritionanalysis.api.NutritionApiService
import com.ammar.nutritionanalysis.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        nutritionApiService: NutritionApiService,
    ): MainRepository {
        return MainRepository(nutritionApiService)
    }
}