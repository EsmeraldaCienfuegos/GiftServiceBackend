package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.ReceiptTypeDTO;
import pe.edu.upc.gift_service.dtos.ReviewsDTO;
import pe.edu.upc.gift_service.entities.ReceiptType;
import pe.edu.upc.gift_service.entities.Reviews;
import pe.edu.upc.gift_service.servicesinterfaces.IReceiptTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receipttypes")
@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
public class ReceiptTypeController {
    @Autowired
    private IReceiptTypeService iR;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void insert(@RequestBody ReceiptTypeDTO ReceiptTypeDTO){
        ModelMapper m=new ModelMapper();
        ReceiptType p=m.map(ReceiptTypeDTO, ReceiptType.class);
        iR.insert(p);
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO','ADMIN')")
    public List<ReceiptTypeDTO> list(){
        return  iR.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ReceiptTypeDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iR.delete(id);
    }

    @PutMapping
    public void update(@RequestBody ReceiptTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        ReceiptType u = m.map(dto, ReceiptType.class);
        iR.insert(u);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ReceiptTypeDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ReceiptType e = iR.listId(id);
        return m.map(e, ReceiptTypeDTO.class);
    }

}
