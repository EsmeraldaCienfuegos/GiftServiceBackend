package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.CityDTO;
import pe.edu.upc.gift_service.entities.City;
import pe.edu.upc.gift_service.servicesinterfaces.ICityService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
//@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN','USUARIO')")
public class CityController {
    @Autowired
    private ICityService icS;

    @PostMapping
    public void insertar(@RequestBody CityDTO cityDTO){
        ModelMapper m=new ModelMapper();
        City ct=m.map(cityDTO, City.class);
        icS.insert(ct);
    }

    @GetMapping
    public List<CityDTO> listar(){
        return icS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, CityDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ icS.delete(id);}

    @PutMapping
    public void update(@RequestBody CityDTO dto) {
        ModelMapper m = new ModelMapper();
        City u = m.map(dto, City.class);
        icS.insert(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public CityDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        City e = icS.listId(id);
        return m.map(e, CityDTO.class);
    }
}
