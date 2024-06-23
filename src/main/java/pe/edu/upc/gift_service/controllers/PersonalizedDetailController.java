package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.PersonalizedDetailDTO;
import pe.edu.upc.gift_service.dtos.UserDTO;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;
import pe.edu.upc.gift_service.entities.Users;
import pe.edu.upc.gift_service.servicesinterfaces.IPersonalizedDetailService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personalizeddetails")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN')")
public class PersonalizedDetailController {
    @Autowired
    private IPersonalizedDetailService ipS;
    @PostMapping
    public void insertar(@RequestBody PersonalizedDetailDTO typeDTO){
        ModelMapper m = new ModelMapper();
        PersonalizedDetail r = m.map(typeDTO, PersonalizedDetail.class);
        ipS.insert(r);
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN', 'USUARIO')")
    public List<PersonalizedDetailDTO> listar(){
        return ipS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PersonalizedDetailDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        ipS.delete(id);
    }

    @GetMapping("/{id}")
    public PersonalizedDetailDTO listarID(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        PersonalizedDetailDTO dto = m.map(ipS.listId(id), PersonalizedDetailDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody PersonalizedDetailDTO dto) {
        ModelMapper m = new ModelMapper();
        PersonalizedDetail u = m.map(dto, PersonalizedDetail.class);
        ipS.insert(u);
    }

}
