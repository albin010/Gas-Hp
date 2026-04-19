//package gasagency.hpgas.controller.gastypecontroller;
//
//import com.example.gasagency.model.GasType;
//import com.example.gasagency.service.GasTypeService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/gas-types")
//public class GasTypeController {
//
//    private final GasTypeService service;
//
//    public GasTypeController(GasTypeService service) {
//        this.service = service;
//    }
//
//    // Create
//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public GasType create(@RequestBody GasType gasType) {
//        return service.save(gasType);
//    }
//
//    // Get All
//    @GetMapping
//    public List<GasType> getAll() {
//        return service.getAll();
//    }
//
//    // Get by ID
//    @GetMapping("/{id}")
//    public GasType getById(@PathVariable Long id) {
//        return service.getById(id);
//    }
//
//    // Delete
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Long id) {
//        service.delete(id);
//        return "Deleted successfully";
//    }
//}