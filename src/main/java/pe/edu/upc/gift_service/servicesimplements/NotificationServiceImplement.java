package pe.edu.upc.gift_service.servicesimplements;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Notification;
import pe.edu.upc.gift_service.repositories.INotificationRepository;
import pe.edu.upc.gift_service.servicesinterfaces.INotificationService;

import java.util.List;

@Service
public class NotificationServiceImplement implements INotificationService {
    @Autowired
    private INotificationRepository nTR;

    @Autowired
    private EmailServiceImplement emailS;

    @Override
    public void insert(Notification ntf) {
        nTR.save(ntf);
        String userEmail = ntf.getUsEr().getMail();
        System.out.println("User Email: " + userEmail);  // Línea de depuración

        if (userEmail == null || userEmail.isEmpty()) {
            System.err.println("Email esta vacio");  // Mensaje de error para depuración
            return;
        }

        try {
            emailS.sendEmail(
                    userEmail,
                    "| Nueva Notification |",
                    "Usted tiene una nueva notificación del Emprendimiento: \n" + ntf.getMessage()
            );
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Notification> list() {
        return nTR.findAll();
    }

    @Override
    public Notification listId(int id) {
        return nTR.findById(id).orElse(new Notification());
    }

    @Override
    public void delete(int id) {
        nTR.deleteById(id);
    }
}
