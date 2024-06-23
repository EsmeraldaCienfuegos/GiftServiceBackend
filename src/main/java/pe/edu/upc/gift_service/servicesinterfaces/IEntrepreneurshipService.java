package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.Entrepreneurship;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface IEntrepreneurshipService {
    public void insert(Entrepreneurship entrepreneurship);
    public List<Entrepreneurship> list();

    public Entrepreneurship listId(Long id);
    public void update(Entrepreneurship entrepreneurship);
    public void delete(Long id);
    public List<String[]> quantityReviewsByProduct(Long id);
    public List<String[]> findTop3PersonalizationsByEntrepreneurshipId(Long id);
}
