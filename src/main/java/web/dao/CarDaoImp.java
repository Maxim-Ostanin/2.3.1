package web.dao;

import web.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoImp implements CarDao {
    private final List<Car> carsList;

    {
        carsList = new ArrayList<>();
        carsList.add(new Car("Bmw", "black", 1));
        carsList.add(new Car("Volkswagen", "grey", 2));
        carsList.add(new Car("Mercedes", "white", 3));
        carsList.add(new Car("Opel", "blue", 4));
        carsList.add(new Car("Audi", "gold", 5));
    }


    @Override
    public List<Car> getListCar(int count) {
        if (count == 5) {
            return new ArrayList<>(carsList);
        }
        return carsList.stream().limit(count).collect(Collectors.toList());
    }

}
