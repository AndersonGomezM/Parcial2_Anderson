package edu.ucne.parcial2_anderson.di

import javax.inject.Singleton
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import edu.ucne.parcial2_anderson.data.remote.VerboApi

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideVerboApi(moshi: Moshi): VerboApi {
        val Base_Url = "https://private-a127e-verbos.apiary-mock.com"
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(VerboApi::class.java)
    }
}