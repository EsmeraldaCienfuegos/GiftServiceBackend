package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.Country;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Integer> {
}
