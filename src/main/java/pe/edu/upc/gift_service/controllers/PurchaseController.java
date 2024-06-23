package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.PurchaseDTO;
//import pe.edu.upc.gift_service.dtos.QuantityByTypeDeliveryDTO;
//import pe.edu.upc.gift_service.dtos.RankingPaymentTypesUsedDTO;
import pe.edu.upc.gift_service.dtos.QuantityByTypeDeliveryDTO;
import pe.edu.upc.gift_service.dtos.RankingPaymentTypesUsedDTO;
import pe.edu.upc.gift_service.entities.Purchase;
import pe.edu.upc.gift_service.servicesinterfaces.IPurchaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/purchases")
@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
public class PurchaseController {
    @Autowired
    private IPurchaseService pS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void insert(@RequestBody PurchaseDTO purchaseDTO){
        ModelMapper m=new ModelMapper();
        Purchase p=m.map(purchaseDTO,Purchase.class);
        pS.insert(p);
    }
    @PostMapping("/insertR")
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public PurchaseDTO insertR(@RequestBody PurchaseDTO purchaseDTO){
        ModelMapper m=new ModelMapper();
        Purchase p=m.map(purchaseDTO,Purchase.class);
        return m.map(pS.insertR(p),PurchaseDTO.class);
    }

    @GetMapping
    public List<PurchaseDTO> list(){
        return  pS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, PurchaseDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO')")
    public void delete(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void update(@RequestBody PurchaseDTO purchaseDTO) {
        ModelMapper m = new ModelMapper();
        Purchase e = m.map(purchaseDTO, Purchase.class);
        pS.update(e);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public PurchaseDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Purchase e = pS.listId(id);
        return m.map(e, PurchaseDTO.class);
    }
    @GetMapping("/maxIdPurchase/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public int maxID(@PathVariable("id") int id) {
        return pS.maxIdPurchase(id);
    }

    @GetMapping("CantidadDeTipoDeDeliveryDelTotalDeCompras")
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public List<QuantityByTypeDeliveryDTO> cantidadPorTipoDeEntrega(){
        List<String[]> filaLista= pS.QuantityByTypeDelivery();
        List<QuantityByTypeDeliveryDTO> dtoLista=new ArrayList<>();
        for(String [] columna:filaLista){
            QuantityByTypeDeliveryDTO dto=new QuantityByTypeDeliveryDTO();
            dto.setTotalpurchase(Integer.parseInt(columna[0]));
            dto.setNameTypeDelivery(columna[1]);
            dto.setQuantityTypeDelivery(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/Ranking_payment_type_used")
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public List<RankingPaymentTypesUsedDTO> RankingPaymentTypesUsed(){
        List<String[]> filaLista= pS.RankingPaymentTypesUsed();
        List<RankingPaymentTypesUsedDTO> dtoLista=new ArrayList<>();
        for(String [] columna:filaLista){
            RankingPaymentTypesUsedDTO dto=new RankingPaymentTypesUsedDTO();
            dto.setNamePaymentType(columna[0]);
            dto.setTotal(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
