package com.example.headspaceapplication.di.module

import android.app.Application
import androidx.room.Room
import com.example.headspaceapplication.BuildConfig
import com.example.headspaceapplication.MyApp
import com.example.headspaceapplication.repository.local.PicsumDatabase
import com.example.headspaceapplication.repository.remote.PicsumService
import com.example.headspaceapplication.view.MainActivity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
abstract class AppModule {


    @Binds
    abstract fun bindApplication(app: MyApp): Application

    @ContributesAndroidInjector(modules = [NavHostModule::class])
    abstract fun mainActivityInjector(): MainActivity

    @Module
    companion object {

        private val API_TIME_OUT = if(BuildConfig.DEBUG) 60L else 20L
        private const val DATABASE_NAME = "picsum_db"

        @Provides
        @JvmStatic
        fun provideMoshi(): Moshi = Moshi.Builder().build()

        @Provides
        @JvmStatic
        fun providesOkHttpClient(): OkHttpClient {

            val httpLoggingInterceptor =
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            if (BuildConfig.DEBUG) {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }else{
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            }
            val clientBuilder = OkHttpClient.Builder()
                .readTimeout(API_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(API_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(API_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)

            return clientBuilder.build()
        }

        @Provides
        @JvmStatic
        fun providesRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
            .baseUrl("https://picsum.photos/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        @Provides
        @JvmStatic
        fun providesUrbanService(retrofit: Retrofit): PicsumService =
            retrofit.create(PicsumService::class.java)

        @Singleton
        @Provides
        @JvmStatic
        fun provideDatabase(application: Application): PicsumDatabase =
            Room.databaseBuilder(application, PicsumDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        @Singleton
        @Provides
        @JvmStatic
        fun providePicsumDao(database: PicsumDatabase) = database.picsumDao()

        @Singleton
        @Provides
        @JvmStatic
        fun providePageDao(database: PicsumDatabase) = database.pageDao()

    }
}