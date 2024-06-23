package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Conversation;
import pe.edu.upc.gift_service.repositories.IConversationRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IConversationService;

import java.util.List;

@Service
public class ConversationServiceImplement implements IConversationService {
    @Autowired
    private IConversationRepository cR;
    @Override
    public void insert(Conversation conversation) {
        cR.save(conversation);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Conversation listId(int id) {
        return cR.findById(id).orElse(new Conversation());
    }

    @Override
    public List<Conversation> list() {
        return cR.findAll();
    }

    @Override
    public List<Conversation> findAllByUserEntrepre(int id_entre, int id_user) {
        return cR.findAllByUserEntrepre(id_entre, id_user);
    }


}
