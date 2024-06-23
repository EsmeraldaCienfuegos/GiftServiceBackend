package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.Product;

import java.util.List;

public interface IProductService {
    public void insert(Product r);
    public List<Product> list();
    public void delete(int id);
    public Product listId(int id);
    public void update(Integer id, Product product);
    public List<Product> productByNameCategory( String nombreC);
    public List<Product> productByNameEntrepreneurship(String nombreE);
    public List<Product> productByName(String nombreP);
    public List<String[]> productForSale();
}

