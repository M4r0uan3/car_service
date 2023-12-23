package ma.emsi.control;

import ma.emsi.control.dao.entities.Car;
import ma.emsi.control.dao.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CarRepository carRepository){
        return args -> {
            for (int i = 1; i < 10; i++) {
                Car car = Car.builder()
                        .model(Math.random()>0.5? "S" : "A")
                        .color("red")
                        .price(1000+Math.random()*900)
                        .matricul("10"+Math.round(Math.random()*390))
                        .build();
                System.out.println(car);
                carRepository.save(car);
            }
        };
    }
}
