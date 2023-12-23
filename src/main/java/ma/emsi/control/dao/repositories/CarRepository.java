package ma.emsi.control.dao.repositories;

import ma.emsi.control.dao.entities.Car;
import ma.emsi.control.service.dtos.CarDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    public List<Car> getCarByModel(String model);
    public List<CarDTO> getCarByModelAndPrice(String model, Double price);
   public CarDTO getCarByMatricul(String matricul);
}
