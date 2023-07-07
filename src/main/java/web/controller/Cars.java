package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Cars {

    public List<Car> getNewLengthCarsList(List<Car> list, int count) {
        if (count == 5) {
            return list;
        }
        return list.stream().limit(count).collect(Collectors.toList());

    }

    @GetMapping(value = "/cars")
    public String showListOfCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> carsList = List.of(new Car[]{
                new Car("Bmw", "black", 1),
                new Car("Volkswagen", "grey", 2),
                new Car("Mercedes", "white", 3),
                new Car("Opel", "blue", 4),
                new Car("Audi", "gold", 5)});
        List<Car> newCarsList = getNewLengthCarsList(carsList, count);
        model.addAttribute("carsList", newCarsList);
        return "cars";
    }
}
