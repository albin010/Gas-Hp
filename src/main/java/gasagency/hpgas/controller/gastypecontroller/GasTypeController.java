package gasagency.hpgas.controller.gastypecontroller;


import gasagency.hpgas.entity.gastypeentity.GasType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gas-types")
public class GasTypeController {

    private final gasagency.hpgas.server.gastypeservice.GasTypeService service;

    public GasTypeController(gasagency.hpgas.server.gastypeservice.GasTypeService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public GasType create(@RequestBody GasType gasType) {
        return service.save(gasType);
    }

    // Get All
    @GetMapping
    public List<gasagency.hpgas.entity.gastypeentity.GasType> getAll() {
        return service.getAll();
    }

    // Get by ID
    @GetMapping("/{id}")
    public GasType getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted successfully";
    }
}