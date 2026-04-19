//package gasagency.hpgas.server.gastypeservice;
//
//import com.example.gasagency.model.GasType;
//import com.example.gasagency.repository.GasTypeRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class GasTypeService {
//
//    private final GasTypeRepository repository;
//
//    public GasTypeService(GasTypeRepository repository) {
//        this.repository = repository;
//    }
//
//    public GasType save(GasType gasType) {
//        return repository.save(gasType);
//    }
//
//    public List<GasType> getAll() {
//        return repository.findAll();
//    }
//
//    public GasType getById(Long id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }
//}