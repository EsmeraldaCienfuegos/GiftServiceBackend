package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.NotificationDTO;
import pe.edu.upc.gift_service.dtos.PaymentTypeDTO;
import pe.edu.upc.gift_service.entities.Notification;
import pe.edu.upc.gift_service.entities.PaymentType;
import pe.edu.upc.gift_service.servicesinterfaces.INotificationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO','ADMIN')")
public class NotificationController {
    @Autowired
    private INotificationService iN;

    @PostMapping
    public void insertar(@RequestBody NotificationDTO notificationDTO){
        ModelMapper m=new ModelMapper();
        Notification n=m.map(notificationDTO, Notification.class);
        iN.insert(n);
    }

    @GetMapping
    public List<NotificationDTO> listar(){
        return iN.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, NotificationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ iN.delete(id);}

    @PutMapping
    public void update(@RequestBody NotificationDTO dto) {
        ModelMapper m = new ModelMapper();
        Notification u = m.map(dto, Notification.class);
        iN.insert(u);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public NotificationDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Notification e = iN.listId(id);
        return m.map(e, NotificationDTO.class);
    }
}
