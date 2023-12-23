package ma.emsi.control.service;

import ma.emsi.control.service.dtos.CarDTO;

import java.util.List;

public interface CarManager {
    public CarDTO saveCar(CarDTO carDTO);
    public CarDTO deleteCar(Long id);
    public List<CarDTO> getCarByModel(String model);
    public List<CarDTO> getCarByModelAndPrice(String model, Double price);
}
