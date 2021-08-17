package HomeWork7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpWeatherOutputFromAccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/прогнозы/v1/daily/1day/{locationKey}
// Создаю в модели набор констант
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "WTAnk9TLNG1jquqR5HGotj9OxldL4OY3";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    // Создаю экземпляры необходимых классов
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //Составляю метод, получающий погоду
    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();
// Создаю запрос к серверу Accuweather
                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();
// Описываю формат ответа сервера
                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);
// Попытался привести в человекочитаемый вид
//                String endDate = objectMapper.readTree(weatherResponse).get(0).at("/EndDate").asText();
//                return endDate;
//            String weatherText = objectMapper.readTree(weatherResponse).get(0).at("/Text").asText();
//            return weatherText;
//            String temperature = objectMapper.readTree(weatherResponse).get(0).at("/Temperature").asText();
//            return temperature;
//            System.out.println("В городе " + String city + "на дату " + endDate + "ожидается " + weatherText + ", температура - " + temperature);

                break;
            case FIVE_DAYS:
                HttpUrl httpUrl2 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request2 = new Request.Builder()
                        .url(httpUrl2)
                        .build();

                Response fiveDaysForecastResponse = okHttpClient.newCall(request2).execute();
                String weatherResponse2 = fiveDaysForecastResponse.body().string();
                System.out.println(weatherResponse2);

//                String endDate1 = objectMapper.readTree(weatherResponse2).get(0).at("/EndDate").asText();
//                return endDate1;
//            String iconPhrase1 = objectMapper.readTree(weatherResponse2).get(0).at("/IconPhrase").asText();
//            return iconPhrase1;
//            String precipitationType1 = objectMapper.readTree(weatherResponse2).get(0).at("/PrecipitationType").asText();
//            return precipitationType1;
//
//                String endDate2 = objectMapper.readTree(weatherResponse2).get(1).at("/EndDate").asText();
//                return endDate2;
//            String iconPhrase2 = objectMapper.readTree(weatherResponse2).get(1).at("/IconPhrase").asText();
//            return iconPhrase2;
//            String precipitationType2 = objectMapper.readTree(weatherResponse2).get(1).at("/PrecipitationType").asText();
//            return precipitationType2;

//                String endDate3 = objectMapper.readTree(weatherResponse2).get(2).at("/EndDate").asText();
//                return endDate3;
//            String iconPhrase3 = objectMapper.readTree(weatherResponse2).get(2).at("/IconPhrase").asText();
//            return iconPhrase3;
//            String precipitationType3 = objectMapper.readTree(weatherResponse2).get(2).at("/PrecipitationType").asText();
//            return precipitationType3;

//                String endDate4 = objectMapper.readTree(weatherResponse2).get(3).at("/EndDate").asText();
//                return endDate4;
//            String iconPhrase4 = objectMapper.readTree(weatherResponse2).get(3).at("/IconPhrase").asText();
//            return iconPhrase4;
//            String precipitationType4 = objectMapper.readTree(weatherResponse2).get(3).at("/PrecipitationType").asText();
//            return precipitationType4;

//                String endDate5 = objectMapper.readTree(weatherResponse2).get(4).at("/EndDate").asText();
//                return endDate5;
//            String iconPhrase5 = objectMapper.readTree(weatherResponse2).get(4).at("/IconPhrase").asText();
//            return iconPhrase5;
//            String precipitationType5 = objectMapper.readTree(weatherResponse2).get(4).at("/PrecipitationType").asText();
//            return precipitationType5;

//                System.out.println("В городе " + String city + "на ближайшие 5 дней ожидается следующая погода:");
//                System.out.println(endDate1 + iconPhrase1 + precipitationType1);
//                System.out.println(endDate2 + iconPhrase2 + precipitationType2);
//                System.out.println(endDate3 + iconPhrase3 + precipitationType3);
//                System.out.println(endDate4 + iconPhrase4 + precipitationType4);
//                System.out.println(endDate5 + iconPhrase5 + precipitationType5);
                break;
        }
    }

    // Создаю метод, определяющий местоположение прогноза
    private static String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();
//Составляю метод, выводящий поле Key из ответа сервера
        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
//        System.out.println(response.code());
//        System.out.println(response.headers());
//        System.out.println(responseString);
//        return responseString;
    }
}
