package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {


    private static final List<Car> cars =  new ArrayList<>();

    static{
        makeList();
    }

    public static void makeList(){
        cars.add(new Car("car", "number", 1));
        cars.add(new Car("car", "number", 2));
        cars.add(new Car("its not a bug", "number", 3));
        cars.add(new Car("im serious", "number", 4));
        cars.add(new Car("just a car", "number", 5));
    }

    public List<Car> getCarCounted(int i){
        if (i > 5 || i < 1) { return cars;}
        return cars.stream().limit(i).collect(Collectors.toList());
    }
}
