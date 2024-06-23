package pe.edu.upc.gift_service.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.gift_service.dtos.*;
import pe.edu.upc.gift_service.entities.PurchaseDetail;
import pe.edu.upc.gift_service.entities.ReceiptType;
import pe.edu.upc.gift_service.servicesinterfaces.IPurchaseDetailService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/purchasedetails")
@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
public class PurchaseDetailController {
    @Autowired
    private IPurchaseDetailService pdS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public void insertar(@RequestBody PurchaseDetailDTO purchaseDetailDTO) {
        ModelMapper m = new ModelMapper();
        PurchaseDetail e = m.map(purchaseDetailDTO, PurchaseDetail.class);
        pdS.insert(e);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
    public List<PurchaseDetailDTO> list() {
        return pdS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, PurchaseDetailDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void update(@RequestBody PurchaseDetailDTO dto) {
        ModelMapper m = new ModelMapper();
        PurchaseDetail u = m.map(dto, PurchaseDetail.class);
        pdS.insert(u);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO')")
    public void delete(@PathVariable("id") int id) {
        pdS.delete(id);
    }


    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public PurchaseDetailDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PurchaseDetail e = pdS.listId(id);
        return m.map(e, PurchaseDetailDTO.class);
    }


    @GetMapping("/cantidaddecomprasporEmprendimiento")
    @PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO', 'ADMIN')")
    public List<PurchaseByEntrepreneurshipDTO> quantityPurchaseByEntrepreneurship(){
        List<String[]> filaLista=pdS.quantityPurchaseByEntrepreneurship();
        List<PurchaseByEntrepreneurshipDTO> dtoLista=new ArrayList<>();
        for(String[] columna:filaLista){
            PurchaseByEntrepreneurshipDTO dto=new PurchaseByEntrepreneurshipDTO();
            dto.setNameEntrepreneurship(columna[0]);
            dto.setQuantityPurchaseD(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/montodeventasporEmprendimiento")
    @PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO', 'ADMIN')")
    public List<TotalAmountByEntrepreneurshipDTO> monto(){
        List<String[]> filaLista= pdS.TotalAmountByEntrepreneurship();
        List<TotalAmountByEntrepreneurshipDTO> dtoLista=new ArrayList<>();
        for(String [] columna:filaLista){
            TotalAmountByEntrepreneurshipDTO dto=new TotalAmountByEntrepreneurshipDTO();
            dto.setNameEntrepreneurship(columna[0]);
            dto.setTotalAmount(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/SumaDeCantidadesPorFechaCompra")
    @PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO', 'ADMIN')")
    public SumAmountByPurchaseDateDTO sumAmountByPurchaseDate(@RequestParam LocalDate fechaCompra){
        int total = pdS.sumTotalProductsByPurchaseDate(fechaCompra);
        return new SumAmountByPurchaseDateDTO(total);
    }

    @GetMapping("/TotalProductosVendidosDescent")
    @PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO', 'ADMIN', 'USUARIO')")
    public List<FilterBestSellerDTO> filterBestSellerDescent() {
        List<String[]> filaLista= pdS.filterBestSellerProductDescent();
        List<FilterBestSellerDTO> dtoLista=new ArrayList<>();
        for(String [] columna:filaLista){
            FilterBestSellerDTO dto=new FilterBestSellerDTO();
            dto.setProductId(Integer.parseInt(columna[0]));
            dto.setTotalSales(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/Ranking_Category_purchase")
    public List<RankingCategoryPurchaseDTO> RankingCategoryPurchase(){
        List<String[]> filaLista= pdS.RankingCategoryPurchase();
        List<RankingCategoryPurchaseDTO> dtoLista=new ArrayList<>();
        for(String [] columna:filaLista){
            RankingCategoryPurchaseDTO dto=new RankingCategoryPurchaseDTO();
            dto.setNameCategory(columna[0]);
            dto.setTotal(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
