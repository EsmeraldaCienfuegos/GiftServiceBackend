package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

@Repository
public interface IPersonalizedDetailRepository extends JpaRepository<PersonalizedDetail, Integer> {

}
