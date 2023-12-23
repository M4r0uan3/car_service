package ma.emsi.control.service.mappers;

import ma.emsi.control.dao.entities.Car;
import ma.emsi.control.service.dtos.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class CarMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public CarDTO fromCarToCarDto(Car car) {
        return this.modelMapper.map(car, CarDTO.class);
    }

    public Car fromCarDtoToCar(CarDTO carDTO) {return this.modelMapper.map(carDTO, Car.class);}
}
