package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Category;
import pe.edu.upc.gift_service.repositories.ICategoryRepository;
import pe.edu.upc.gift_service.servicesinterfaces.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImplement implements ICategoryService {

    @Autowired
    private ICategoryRepository cR;

    @Override
    public void save(Category category) {
        cR.save(category);
    }

    @Override
    public List<Category> list() {
        return cR.findAll();
    }

    @Override
    public Category listId(Long id) {
        return cR.findById(id).orElse(new Category());
    }

    @Override
    public void update(Category category) {
        cR.save(category);
    }

    @Override
    public void delete(Long id) {
        cR.deleteById(id);
    }
}
