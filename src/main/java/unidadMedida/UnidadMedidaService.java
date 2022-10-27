package unidadMedida;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UnidadMedidaService {
    @Autowired
    private UnidadMedidaRepository medidaRepository;

    public UnidadMedida create(UnidadMedida unidadMedida){
        return medidaRepository.save(unidadMedida);
    }

    public List<UnidadMedida> getAllUnidadMedida(){
        return medidaRepository.findAll();
    }
    public void deleteById(Integer id){
        medidaRepository.deleteById(id);
    }
    public Optional<UnidadMedida> getById(Integer id){
        return medidaRepository.findById(id);
    }
}
