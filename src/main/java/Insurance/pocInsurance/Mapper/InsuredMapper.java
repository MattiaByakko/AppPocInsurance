package pocInsurance.Mapper;

import org.mapstruct.Mapper;
import pocInsurance.DTOReq.InsuredReq;
import pocInsurance.DTORes.InsuredRes;
import pocInsurance.Entity.Insured;

@Mapper(componentModel = "spring")
public interface InsuredMapper {
    Insured toEntity(InsuredReq dto);
    InsuredRes toRes(Insured entity);
}
