package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public long getCarId() {
        return id;
    }

    public void setCarId(long id) {
        this.id = id;
    }

    public String getCarModel() {
        return model;
    }

    public void setCarModel(String model) {
        this.model = model;
    }

    public int getCarSeries() {
        return series;
    }

    public void setCarSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
