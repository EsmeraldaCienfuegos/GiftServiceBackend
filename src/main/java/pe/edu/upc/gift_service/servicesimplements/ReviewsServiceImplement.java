package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Reviews;
import pe.edu.upc.gift_service.repositories.IReviewsRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IReviewsService;

import java.util.List;

@Service
public class ReviewsServiceImplement implements IReviewsService {
    @Autowired
    private IReviewsRepository rR;

    @Override
    public void insert(Reviews reviews) {
        rR.save(reviews);
    }

    @Override
    public List<Reviews> list() {
        return rR.findAll();
    }

    @Override
    public Reviews listId(int id) {
        return rR.findById(id).orElse(new Reviews());
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public int TotalScoreByProduct(int product_id, int entrepreneurship_id) {
        return rR.TotalScoreByProduct(product_id,entrepreneurship_id);
    }

    @Override
    public List<String[]> LowScoreProduct() {
        return rR.LowScoreProduct();
    }

    @Override
    public List<Reviews> reviewsByProductId(int id) {
        return rR.reviewsByProductId(id);
    }
}
