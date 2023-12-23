package ma.emsi.control.service;

import ma.emsi.control.dao.entities.Car;
import ma.emsi.control.dao.repositories.CarRepository;
import ma.emsi.control.service.dtos.CarDTO;
import ma.emsi.control.service.mappers.CarMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CarManagerAction implements CarManager{

    private CarMapper carMapper;
    private CarRepository carRepository;

    public CarManagerAction(CarMapper carMapper, CarRepository carRepository) {
        this.carMapper = carMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = carMapper.fromCarDtoToCar(carRepository.getCarByMatricul(carDTO.getMatricul()));
        if(car == null) return carMapper.fromCarToCarDto(carRepository.save(car));
        return null;
    }

    @Override
    public CarDTO deleteCar(Long id) {
        CarDTO carDTO = carMapper.fromCarToCarDto(carRepository.findById(id).get());
        carRepository.deleteById(id);
        return carDTO;
    }

    @Override
    public List<CarDTO> getCarByModel(String model) {
        return Collections.singletonList(carMapper.fromCarToCarDto((Car) carRepository.getCarByModel(model)));
    }

    @Override
    public List<CarDTO> getCarByModelAndPrice(String model, Double price) {
        return Collections.singletonList(carMapper.fromCarToCarDto((Car) carRepository.getCarByModelAndPrice(model, price)));
    }
}
