package com.example.graduationproject.di

import com.example.graduationproject.data.datasource.BasketDatasource
import com.example.graduationproject.data.datasource.FoodDatasource
import com.example.graduationproject.data.repo.BasketRepository
import com.example.graduationproject.data.repo.FoodRepository
import com.example.graduationproject.retrofit.ApiUtils
import com.example.graduationproject.retrofit.FoodsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodRepository(fds: FoodDatasource) : FoodRepository {
        return FoodRepository(fds)
    }

    @Provides
    @Singleton
    fun provideBasketRepository(bds: BasketDatasource) : BasketRepository {
        return BasketRepository(bds)
    }

    @Provides
    @Singleton
    fun provideFoodDatasource(fdao: FoodsDao) : FoodDatasource {
        return FoodDatasource(fdao)
    }

    @Provides
    @Singleton
    fun provideBasketDatasource(fdao: FoodsDao) : BasketDatasource {
        return BasketDatasource(fdao)
    }

    @Provides
    @Singleton
    fun provideFoodsDao() : FoodsDao {
        return ApiUtils.getFoodsDao()
    }
}