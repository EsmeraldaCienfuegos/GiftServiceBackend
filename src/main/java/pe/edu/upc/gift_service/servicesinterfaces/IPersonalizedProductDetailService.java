package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PersonalizedProductDetail;

import java.util.List;

public interface IPersonalizedProductDetailService {
    public void insert(PersonalizedProductDetail ppd);

    public List<PersonalizedProductDetail> list();

    public void delete(int id);
    public PersonalizedProductDetail listId(int id);
    List<String[]> allDetailByProduct(int idProduct);
}
