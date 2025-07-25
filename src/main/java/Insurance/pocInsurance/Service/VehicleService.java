package pocInsurance.Service;

import pocInsurance.DTOReq.VehicleReq;
import pocInsurance.DTORes.VehicleRes;

import java.util.List;

public interface VehicleService {

    VehicleRes createVehicle(VehicleReq request);

    List<VehicleRes> getAllVehicles();

    VehicleRes getVehicleById(Long id);

    List<VehicleRes> getVehiclesByInsuredId(Long insuredId);

    List<VehicleRes> getVehiclesByCounterpartId(Long counterpartId);
}
