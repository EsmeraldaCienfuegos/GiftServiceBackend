package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.ConversationDTO;
import pe.edu.upc.gift_service.entities.Conversation;
import pe.edu.upc.gift_service.servicesinterfaces.IConversationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conversations")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN','USUARIO')")
public class ConversationController {
    @Autowired
    private IConversationService cS;

    @PostMapping
    public void insertar(@RequestBody ConversationDTO conversationDTO) {
        ModelMapper m = new ModelMapper();
        Conversation e = m.map(conversationDTO, Conversation.class);
        cS.insert(e);
    }

    @GetMapping
    public List<ConversationDTO> list() {
        return cS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ConversationDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        cS.delete(id);
    }


    @GetMapping("/Mensajes")
    public List<ConversationDTO> listByUserID(@RequestParam int entrepreneurship_id,@RequestParam int user_id){
        return  cS.findAllByUserEntrepre(entrepreneurship_id, user_id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ConversationDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public ConversationDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Conversation e = cS.listId(id);
        return m.map(e, ConversationDTO.class);
    }

}
