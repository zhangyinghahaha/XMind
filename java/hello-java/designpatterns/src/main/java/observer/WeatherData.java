package observer;

import java.util.ArrayList;
import java.util.Observable;
// import java.util.Observer;

/**
 * WeatherData class
 *
 * @author zhangying
 * @date 2019/6/27
 */
public class WeatherData extends Observable {
    // private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {}

//    @Override
//    public void registerObserver(Observer o) {
//        observers.add(o);
//    }
//
//    @Override
//    public void removeObserver(Observer o) {
//        int i = observers.indexOf(o);
//        if(i >= 0) {
//            observers.remove(i);
//        }
//    }

//    @Override
//    public void notifyObservers() {
//        for(int i = 0; i < observers.size(); i++) {
//            Observer observer = observers.get(i);
//            observer.update(temperature, humidity, pressure);
//        }
//    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
