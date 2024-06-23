package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.Conversation;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface IConversationService {
    public void insert(Conversation conversation);
    public void delete(int id);
    public Conversation listId(int id);
    public List<Conversation> list();
    public List<Conversation> findAllByUserEntrepre(int id_entre, int id_user);
}
