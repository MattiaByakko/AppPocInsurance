package pocInsurance.ServiceImpl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.VehicleReq;
import pocInsurance.DTORes.VehicleRes;
import pocInsurance.Entity.Counterpart;
import pocInsurance.Entity.Insured;
import pocInsurance.Entity.Vehicle;
import pocInsurance.Repository.CounterpartRepository;
import pocInsurance.Repository.InsuredRepository;
import pocInsurance.Repository.VehicleRepository;
import pocInsurance.Service.VehicleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImp implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final InsuredRepository insuredRepository;
    private final CounterpartRepository counterpartRepository;

    @Override
    public VehicleRes createVehicle(VehicleReq request) {
        Insured insured = insuredRepository.findById(request.getInsuredId())
                .orElseThrow(() -> new RuntimeException("Assicurato non trovato con ID: " + request.getInsuredId()));

        Counterpart counterpart = counterpartRepository.findById(request.getCounterpartId())
                .orElseThrow(() -> new RuntimeException("Controparte non trovata con ID: " + request.getCounterpartId()));

        Vehicle vehicle = new Vehicle();
        vehicle.setTarga(request.getTarga());
        vehicle.setMarca(request.getMarca());
        vehicle.setModello(request.getModello());
        vehicle.setAnno(request.getAnno());
        vehicle.setInsured(insured);
        vehicle.setControparte(counterpart);

        Vehicle saved = vehicleRepository.save(vehicle);

        return mapToRes(saved);
    }

    @Override
    public List<VehicleRes> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapToRes)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleRes getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veicolo non trovato con ID: " + id));
        return mapToRes(vehicle);
    }

    @Override
    public List<VehicleRes> getVehiclesByInsuredId(Long insuredId) {
        return vehicleRepository.findByInsuredId(insuredId)
                .stream()
                .map(this::mapToRes)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleRes> getVehiclesByCounterpartId(Long counterpartId) {
        return vehicleRepository.findByControparteId(counterpartId)
                .stream()
                .map(this::mapToRes)
                .collect(Collectors.toList());
    }

    private VehicleRes mapToRes(Vehicle vehicle) {
        return VehicleRes.builder()
                .id(vehicle.getId())
                .targa(vehicle.getTarga())
                .marca(vehicle.getMarca())
                .modello(vehicle.getModello())
                .anno(vehicle.getAnno())
                .insuredId(vehicle.getInsured() != null ? vehicle.getInsured().getId() : null)
                .counterpartId(vehicle.getControparte() != null ? vehicle.getControparte().getId() : null)
                .build();
    }
}
