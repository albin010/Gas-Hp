package gasagency.hpgas.server.gastypeservice;


import gasagency.hpgas.entity.gastypeentity.GasType;
import gasagency.hpgas.repository.gastyperepository.GasTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasTypeService {

    private final GasTypeRepository repository;

    public GasTypeService(GasTypeRepository repository) {
        this.repository = repository;
    }

    public GasType save(GasType gasType) {
        return repository.save(gasType);
    }

    public List<GasType> getAll() {
        return repository.findAll();
    }

    public GasType getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}