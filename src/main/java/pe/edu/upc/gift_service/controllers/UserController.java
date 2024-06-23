package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.UserDTO;
import pe.edu.upc.gift_service.entities.Users;
import pe.edu.upc.gift_service.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
//@PreAuthorize("hasAnyAuthority('USUARIO','ADMIN','EMPRENDIMIENTO')")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping
    public void registrar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @GetMapping
    public List<UserDTO> listar(){
        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ uS.delete(id);}

    @PutMapping
    public void update(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.insert(u);
    }
    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listId(id), UserDTO.class);
        return dto;
    }

    @GetMapping("/ContarPorRol")
    public int findByNameRole(@RequestParam String name_role){
        return uS.findByNameRole(name_role);
    }

    @GetMapping("ultimoUsuario")
    public int encontrarUltimoUsuario(){
        return uS.findLastUserRegister();
    }

    @GetMapping("/ContarPorPais")
    public int findByNameCountry(@RequestParam String name_country){
        return uS.findByNameCountry(name_country);
    }
}
