package HomeWork7;

import java.io.IOException;
// Создаю интерфейс, описывающий модель
public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException;
}
