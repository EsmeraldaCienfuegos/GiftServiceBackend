package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PersonalizedDetail;
import pe.edu.upc.gift_service.entities.Reviews;

import java.util.List;

public interface IReviewsService {
    public void insert(Reviews reviews);

    public List<Reviews> list();

    public Reviews listId(int id);

    public void delete(int id);
    public int TotalScoreByProduct(int product_id, int entrepreneurship_id);
    public List<String[]> LowScoreProduct();
    public List<Reviews> reviewsByProductId(int id);
}
