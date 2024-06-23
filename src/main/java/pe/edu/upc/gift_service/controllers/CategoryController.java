package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.CategoryDTO;
import pe.edu.upc.gift_service.entities.Category;
import pe.edu.upc.gift_service.servicesinterfaces.ICategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN','USUARIO')")
public class CategoryController {
    @Autowired
    private ICategoryService cS;

    @PostMapping
    public void save(@RequestBody CategoryDTO categoryDTO){
        ModelMapper m = new ModelMapper();
        Category category = m.map(categoryDTO, Category.class);
        cS.save(category);
    }

    @PutMapping
    public void update(@RequestBody CategoryDTO categoryDTO){
        ModelMapper m = new ModelMapper();
        Category category = m.map(categoryDTO, Category.class);
        cS.update(category);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        cS.delete(id);
    }

    @GetMapping("/{id}")
    public CategoryDTO listById(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        Category category = cS.listId(id);
        return m.map(category, CategoryDTO.class);
    }

    @GetMapping
    public List<CategoryDTO> list(){
        ModelMapper m = new ModelMapper();
        return cS.list().stream().map( category-> m.map(category,CategoryDTO.class)).collect(Collectors.toList());
    }
}
