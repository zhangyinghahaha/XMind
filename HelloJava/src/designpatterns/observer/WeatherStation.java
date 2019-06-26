package designpatterns.observer;

/**
 * WeatherStation class
 *
 * @author zhangying
 * @date 2019/6/27
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 11);
    }
}
