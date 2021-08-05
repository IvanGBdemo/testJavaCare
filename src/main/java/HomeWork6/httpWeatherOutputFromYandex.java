package HomeWork6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class httpWeatherOutputFromYandex {
    //    public static void main(String[] args) throws IOException {
// Обозначаю элементы запроса к серверу
// https://api.weather.yandex.ru/v2/forecast/
// Пример Запрос:
//GET https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&extra=true
//X-Yandex-API-Key: 4pa...3
// Формат запроса
//Населенный пункт указывается при помощи значений широты (параметр lat) и долготы (параметр lon).
// Если данные параметры заданы некорректно, ответ будет содержать код ошибки 404.
////GET https://api.weather.yandex.ru/v2/forecast?
// lat=<широта>
// & lon=<долгота>
// & [lang=<язык ответа>]
// & [limit=<срок прогноза>]
// & [hours=<наличие почасового прогноза>]
// & [extra=<подробный прогноз осадков>]
//
//X-Yandex-API-Key: <значение ключа>

    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String VERSION = "v2";
    private static final String FORECAST = "forecast";
    private static final String LAT = "lat=";
    private static final String VALUE_LAT = "52.971868";
    private static final String LON = "&lon=";
    private static final String VALUE_LON = "36.064349";
    private static final String LANG = "&lang=";
    private static final String VALUE_LANG = "ru_RU";
    private static final String LIMIT = "&limit=";
    private static final String VALUE_LIMIT = "5";
    private static final String API_KEY_QUERY_PARAM = "X-Yandex-API-Key";
    private static final String API_KEY = "12ae7464-11d2-4699-b655-39a7b036da1d";

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static void getWeather() throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST)
                .addPathSegment(LAT)
                .addPathSegment(VALUE_LAT)
                .addPathSegment(LON)
                .addPathSegment(VALUE_LON)
                .addPathSegment(LANG)
                .addPathSegment(VALUE_LANG)
                .addPathSegment(LIMIT)
                .addPathSegment(VALUE_LIMIT)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response fiveDayForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = fiveDayForecastResponse.body().string();
        System.out.println(request);
        System.out.println(weatherResponse);
    }

    public static void main(String[] args) {
        try {
            getWeather();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Код запроса содержимого страницы с урока 6
// Для начала работы с Postman создаю клиент
//        OkHttpClient okHttpClient = new OkHttpClient()
//                .newBuilder()
//// Заполняю параметры клиента
//                .readTimeout(10, TimeUnit.SECONDS)
//                .build();
//// Создаю экземпляр класса веб-адреса, на который буду посылать запрос
//        HttpUrl url = new HttpUrl.Builder()
//                .scheme("https")
//                .host("yandex.ru")
//                .addPathSegment("dev/weather/doc/dg/concepts/about.html")
//                .build();
//// Описываю запрос, который буду выполнять
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .build();
//// Отправляю созданный запрос на сервер
//        Response response = okHttpClient.newCall(request).execute();
//
//        System.out.println(response.code());
//        System.out.println(response.headers());

//    }
