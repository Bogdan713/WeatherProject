package com.example.weatherapplication;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;
public class Retrofit {
    private static final String ENDPOINT = "http://api.openweathermap.org/data/2.5/";
    private static ApiInterface apiInterface;

    static {
        initialize();
    }

    interface ApiInterface{

        @GET("/forecast")
        void getSubRegions(@Query("q") String countryName,
                           @Query("mode") String nameType,
                           @Query("apikey") String apiKey,
                           Callback<WeatherDataCall> callback);
    }

    private static void initialize(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiInterface = restAdapter.create(ApiInterface.class);
    }

    public static void getSubRegion(String nameRegion, String nameType, String apiKey, Callback<WeatherDataCall> callback){
        apiInterface.getSubRegions(nameRegion, nameType,apiKey,  callback);
    }

}
