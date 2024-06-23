package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.DeliveryTypeDTO;
import pe.edu.upc.gift_service.entities.DeliveryType;
import pe.edu.upc.gift_service.servicesinterfaces.IDeliveryTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deliverytypes")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN','USUARIO')")
public class DeliveryTypeController {
    @Autowired
    private IDeliveryTypeService iD;

    @PostMapping
    public void insert(@RequestBody DeliveryTypeDTO DeliveryTypeDTO) {
        ModelMapper m = new ModelMapper();
        DeliveryType p = m.map(DeliveryTypeDTO, DeliveryType.class);
        iD.insert(p);
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public List<DeliveryTypeDTO> list() {
        return iD.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, DeliveryTypeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iD.delete(id);
    }

    @GetMapping("/findByName")
    //@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public List<DeliveryTypeDTO> findByName(@RequestParam String nameDelivery){
        return iD.findByNameDeliveryType(nameDelivery).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,DeliveryTypeDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void Update (@PathVariable Integer id, @RequestBody DeliveryTypeDTO deliveryTypeDTO){
        ModelMapper m=new ModelMapper();
        DeliveryType d=m.map(deliveryTypeDTO,DeliveryType.class);
        iD.update(id,d);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public DeliveryTypeDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        DeliveryType e = iD.listId(id);
        return m.map(e, DeliveryTypeDTO.class);
    }
}
