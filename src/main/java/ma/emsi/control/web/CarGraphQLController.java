package ma.emsi.control.web;

import ma.emsi.control.service.CarManager;
import ma.emsi.control.service.dtos.CarDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarGraphQLController {
//    @Autowired
//    private PersonManagerDependence personManagerDependence;
//    // getPersonById(id: Float) : PersonDto
//
//    @QueryMapping
//    public PersonDto getPersonById(@Argument Long id) {
//        return personManagerDependence.getPersonById(id);
//    }
//
//    // savePerson(personDto: PersonDtoInput ):PersonDto
//    @MutationMapping
//    public PersonDto savePerson(PersonDto personDto) {
//        return personManagerDependence.savePerson(personDto);
//    }
    private CarManager carManager;


    public CarGraphQLController(CarManager carManager) {
        this.carManager = carManager;
    }

    @QueryMapping
    public List<CarDTO> getCarByModel(@Argument String model){
        return carManager.getCarByModel(model);
    }

    @QueryMapping
    public List<CarDTO> getCarByModelAndPrice(@Argument String model, @Argument Double price){
        return carManager.getCarByModelAndPrice(model,price);
    }

    @MutationMapping
    public CarDTO saveCar(@Argument CarDTO carDTO){
        return carManager.saveCar(carDTO);
    }

    @MutationMapping
    public CarDTO deleteCar(@Argument Long id){
        return carManager.deleteCar(id);
    }

}
