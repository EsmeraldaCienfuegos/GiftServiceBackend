package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.PaymentTypeDTO;
import pe.edu.upc.gift_service.entities.PaymentType;
import pe.edu.upc.gift_service.servicesinterfaces.IPaymentTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paymenttypes")
@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
public class PaymentTypeController {
    @Autowired
    private IPaymentTypeService iP;

    @PostMapping
    public void insert(@RequestBody PaymentTypeDTO paymentTypeDTO){
        ModelMapper m=new ModelMapper();
        PaymentType p=m.map(paymentTypeDTO, PaymentType.class);
        iP.insert(p);
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO', 'ADMIN')")
    public List<PaymentTypeDTO> list(){
        return  iP.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, PaymentTypeDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iP.delete(id);
    }

    @PutMapping
    public void update(@RequestBody PaymentTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        PaymentType u = m.map(dto, PaymentType.class);
        iP.insert(u);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public PaymentTypeDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PaymentType e = iP.listId(id);
        return m.map(e, PaymentTypeDTO.class);
    }
}


