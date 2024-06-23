package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.Category;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface ICategoryService {
    public void save(Category category);
    public List<Category> list();
    public Category listId(Long id);
    public void update(Category category);
    public void delete(Long id);
}
