package pocInsurance.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.CounterpartReq;
import pocInsurance.DTORes.CounterpartRes;
import pocInsurance.Entity.Counterpart;
import pocInsurance.Repository.CounterpartRepository;
import pocInsurance.Service.CounterpartService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterpartServiceImp implements CounterpartService {

    private final CounterpartRepository counterpartRepository;

    @Override
    public CounterpartRes createCounterpart(CounterpartReq request) {
        Counterpart counterpart = new Counterpart();
        counterpart.setNome(request.getNome());
        counterpart.setCognome(request.getCognome());
        counterpart.setCodiceFiscale(request.getCodiceFiscale());
        counterpart.setIndirizzo(request.getIndirizzo());

        Counterpart saved = counterpartRepository.save(counterpart);

        return mapToRes(saved);
    }

    @Override
    public List<CounterpartRes> getAllCounterparts() {
        return counterpartRepository.findAll()
                .stream()
                .map(this::mapToRes)
                .collect(Collectors.toList());
    }

    @Override
    public CounterpartRes getCounterpartById(Long id) {
        Counterpart counterpart = counterpartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controparte non trovata con ID: " + id));
        return mapToRes(counterpart);
    }

    private CounterpartRes mapToRes(Counterpart counterpart) {
        return CounterpartRes.builder()
                .id(counterpart.getId())
                .nome(counterpart.getNome())
                .cognome(counterpart.getCognome())
                .codiceFiscale(counterpart.getCodiceFiscale())
                .indirizzo(counterpart.getIndirizzo())
                .build();
    }
}
