package decorator;

/**
 * Beverage class
 *
 * @author ying.zhang01
 * @date 2019/12/30
 */
public abstract class Beverage {
    String description = "Unknown Beverage";
    String size;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public String getSize(){
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
