package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.EntrepreneurshipDTO;
//import pe.edu.upc.gift_service.dtos.PersonalizedEntrepreneurshipDTO;
//import pe.edu.upc.gift_service.dtos.QuantityReviewDTO;
import pe.edu.upc.gift_service.dtos.PersonalizedEntrepreneurshipDTO;
import pe.edu.upc.gift_service.dtos.QuantityReviewDTO;
import pe.edu.upc.gift_service.entities.Entrepreneurship;
import pe.edu.upc.gift_service.servicesinterfaces.IEntrepreneurshipService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping("/entrepreneurships")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO', 'ADMIN')")
public class EntrepreneurshipController {
    @Autowired
    private IEntrepreneurshipService iE;

    @PostMapping
    public void insertar(@RequestBody EntrepreneurshipDTO entrepreneurshipDTO){
        ModelMapper m=new ModelMapper();
        Entrepreneurship e=m.map(entrepreneurshipDTO, Entrepreneurship.class);
        iE.insert(e);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO', 'ADMIN','USUARIO')")
    public List<EntrepreneurshipDTO> list(){
        return iE.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, EntrepreneurshipDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        iE.delete(id);
    }

    @PutMapping
    public void update(@RequestBody EntrepreneurshipDTO entrepreneurshipDTO){
        ModelMapper m=new ModelMapper();
        Entrepreneurship e=m.map(entrepreneurshipDTO, Entrepreneurship.class);
        iE.update(e);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public EntrepreneurshipDTO listById(@PathVariable("id") Long id){
        ModelMapper m=new ModelMapper();
        Entrepreneurship e=iE.listId(id);
        return m.map(e, EntrepreneurshipDTO.class);
    }

    @GetMapping("/quantityReviewsByProduct/{id}")
    @PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO', 'ADMIN','USUARIO')")
    public List<QuantityReviewDTO> quantityReviewsByProduct(
            @PathVariable("id") Long id
    ) {
        List<QuantityReviewDTO> listDTO =  new ArrayList<>();
        List<String[]> list = iE.quantityReviewsByProduct(id);
        for (String[] hm : list) {
            QuantityReviewDTO dto = new QuantityReviewDTO();
            dto.setNameProduct(hm[0]);
            dto.setQuantityReview(Integer.parseInt(hm[1]));
            listDTO.add(dto);
        }
        return listDTO;
    }

    @GetMapping("/top3personalized/{id}")
    @PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN','USUARIO')")
    public List<PersonalizedEntrepreneurshipDTO> findTop3PersonalizationsByEntrepreneurshipId(
            @PathVariable("id") Long id
    ) {
        List<PersonalizedEntrepreneurshipDTO> listDTO =  new ArrayList<>();
        List<String[]> list = iE.findTop3PersonalizationsByEntrepreneurshipId(id);
        for (String[] hm : list) {
            PersonalizedEntrepreneurshipDTO dto = new PersonalizedEntrepreneurshipDTO();
            dto.setNamePersonalized(hm[0]);
            dto.setQuantityPersonalized(Integer.parseInt(hm[1]));
            listDTO.add(dto);
        }
        return listDTO;
    }
}
