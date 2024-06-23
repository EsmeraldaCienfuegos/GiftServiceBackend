package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.ProductImageDetailDTO;
import pe.edu.upc.gift_service.dtos.PurchaseDTO;
import pe.edu.upc.gift_service.entities.ProductImageDetail;
import pe.edu.upc.gift_service.entities.Purchase;
import pe.edu.upc.gift_service.servicesinterfaces.IProductImageDetailService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productimagedetails")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN')")
public class ProductImageDetailController {
    @Autowired
    private IProductImageDetailService pidS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public List<ProductImageDetailDTO> list(){
        return  pidS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ProductImageDetailDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void insert(@RequestBody ProductImageDetailDTO productImageDetailDTO){
        ModelMapper m=new ModelMapper();
        ProductImageDetail pi=m.map(productImageDetailDTO,ProductImageDetail.class);
        pidS.insert(pi);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void delete(@PathVariable("id") Integer id) {
        pidS.delete(id);
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void update(@RequestBody ProductImageDetailDTO productImageDetailDTO) {
        ModelMapper m = new ModelMapper();
        ProductImageDetail pi = m.map(productImageDetailDTO, ProductImageDetail.class);
        pidS.insert(pi);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public ProductImageDetailDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ProductImageDetail pi = pidS.listId(id);
        return m.map(pi, ProductImageDetailDTO.class);
    }

    @GetMapping("/images/{id}")
    public List<ProductImageDetailDTO> allImageForProduct(@PathVariable("id") int id){
        return  pidS.allIamgeForProduct(id).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ProductImageDetailDTO.class);
        }).collect(Collectors.toList());

    }

}
