package pe.edu.upc.gift_service.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.ProductDTO;
import pe.edu.upc.gift_service.dtos.ProductForSaleDTO;
import pe.edu.upc.gift_service.entities.Product;
import pe.edu.upc.gift_service.servicesinterfaces.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN')")
public class ProductController {
    @Autowired
    private IProductService ipS;

    @PostMapping
    public void insertar(@RequestBody ProductDTO productDTO){
        ModelMapper m=new ModelMapper();
        Product e=m.map(productDTO, Product.class);
        ipS.insert(e);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO', 'ADMIN')")
    public List<ProductDTO> list(){
        return ipS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ProductDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        ipS.delete(id);
    }


    @GetMapping("/{id}")
    public ProductDTO listById(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        Product e=ipS.listId(id);
        return m.map(e, ProductDTO.class);
    }

    @GetMapping("/buscarPorCategoria")
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO','ADMIN')")
    public List<ProductDTO> productosPorCategoria(@RequestParam String nombreC){
        return ipS.productByNameCategory(nombreC).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ProductDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/buscarPorEmprendimiento")
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO','ADMIN')")
    public List<ProductDTO> productosPorEmprendimiento(@RequestParam String nombreE){
        return ipS.productByNameEntrepreneurship(nombreE).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ProductDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscarPorNombreProducto")
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO','ADMIN')")
    public List<ProductDTO> productosPorNombre(@RequestParam String nombreP){
        return ipS.productByName(nombreP).stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ProductDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/UpdateStock/{id}")
    public void Update (@PathVariable Integer id, @RequestBody ProductDTO productDTO){
        ModelMapper m=new ModelMapper();
        Product p=m.map(productDTO,Product.class);
        ipS.update(id,p);
    }

    @GetMapping("/productforsale")
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO','ADMIN')")
    public List<ProductForSaleDTO> ProductForSaleDTO(){
        List<String[]> filaLista= ipS.productForSale();
        List<ProductForSaleDTO> dtoLista=new ArrayList<>();
        for(String [] columna:filaLista){
            ProductForSaleDTO dto=new ProductForSaleDTO();
            dto.setIdProduct(Integer.parseInt(columna[0]));
            dto.setDescriptionProduct(columna[1]);
            dto.setNameProduct(columna[2]);
            dto.setPriceProduct(Double.parseDouble(columna[3]));
            dto.setImageRoute(columna[4]);
            dto.setNameCategory(columna[5]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    /*@GetMapping("/productforsaleByCategory/{category}")
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO','ADMIN')")
    public List<ProductForSaleDTO> ProductForSaleByCategoriy(@PathVariable Integer category){
        List<String[]> filaLista= ipS.productForSale();
        List<ProductForSaleDTO> dtoLista=new ArrayList<>();
        for(String [] columna:filaLista){
            ProductForSaleDTO dto=new ProductForSaleDTO();
            dto.setIdProduct(Integer.parseInt(columna[0]));
            dto.setDescriptionProduct(columna[1]);
            dto.setNameProduct(columna[2]);
            dto.setPriceProduct(Double.parseDouble(columna[3]));
            dto.setImageRoute(columna[4]);
            dto.setNameCategory(columna[5]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }*/
}

