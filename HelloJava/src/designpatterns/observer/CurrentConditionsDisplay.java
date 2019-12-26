package designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * CurrentConditionsDisplay class
 *
 * @author zhangying
 * @date 2019/6/27
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    //private Subject weatherData;
    Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
//        this.weatherData = weatherData;
////        this.weatherData.registerObserver(this);
        this.observable = observable;
        observable.addObserver(this);
    }

//    @Override
//    public void update(float temp, float humidity, float pressure) {
//        this.temperature = temperature;
//        this.humidity = humidity;
//        display();
//    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf("Current conditons: %f  .\nF degrees: %f", temperature, humidity);
    }
}
