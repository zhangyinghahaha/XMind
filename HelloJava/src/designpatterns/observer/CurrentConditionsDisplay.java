package designpatterns.observer;

/**
 * CurrentConditionsDisplay class
 *
 * @author zhangying
 * @date 2019/6/27
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.printf("Current conditons: %f  .\nF degrees: %f", temperature, humidity);
    }
}
