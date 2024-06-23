package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.Notification;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface INotificationService {
    public void insert(Notification ntf);
    public List<Notification> list();

    public Notification listId(int id);
    public void delete(int id);
}
