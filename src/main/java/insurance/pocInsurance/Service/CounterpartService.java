package pocInsurance.Service;

import pocInsurance.DTOReq.CounterpartReq;
import pocInsurance.DTORes.CounterpartRes;

import java.util.List;

public interface CounterpartService {

    CounterpartRes createCounterpart(CounterpartReq request);

    List<CounterpartRes> getAllCounterparts();

    CounterpartRes getCounterpartById(Long id);
}
