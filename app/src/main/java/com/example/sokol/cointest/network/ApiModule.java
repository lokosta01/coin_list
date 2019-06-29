package com.example.sokol.cointest.network;



import com.example.sokol.cointest.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import okhttp3.OkHttpClient;
import okhttp3.Request;


import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    private static final int TIMEOUT_SEC = 20 * 1000;
    private static final String BASE_URL = "https://pro-api.coinmarketcap.com";
    private static final String API_KEY = "8b76ec36-53be-4be7-8f68-d37404fe379f";


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
      final OkHttpClient.Builder builder = new OkHttpClient.Builder();


       // перехватить запросы с помощью HttpLoggingInterceptor
      if(BuildConfig.DEBUG){
       final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
       logging.setLevel(HttpLoggingInterceptor.Level.BODY);
       builder.addInterceptor(logging);
      }

      builder.connectTimeout(TIMEOUT_SEC,TimeUnit.SECONDS)   //время ожидания
              .readTimeout(TIMEOUT_SEC,TimeUnit.SECONDS)
              .writeTimeout(TIMEOUT_SEC,TimeUnit.SECONDS)
              .addInterceptor((chain -> {
                  final Request original = chain.request();

                  // Настраиваем запросы
                  final Request.Builder request = original.newBuilder()
                          .header("Accept", "application/json")
                          .method(original.method(), original.body());

                      request.header("X-CMC_PRO_API_KEY", API_KEY);

                  return chain.proceed(request.build());
              }));


        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRestAdapter(final OkHttpClient okHttpClient, final Gson gs){
     final Retrofit.Builder builder = new Retrofit.Builder();
     builder.client(okHttpClient)
             .baseUrl(BASE_URL + "/")
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .addConverterFactory(GsonConverterFactory.create());
     return builder.build();
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(final Retrofit restAdapter){
        return restAdapter.create(ApiService.class);
    }
}
