package pocInsurance.Mapper;


import org.springframework.stereotype.Component;
import pocInsurance.DTORes.ExpertiseRes;
import pocInsurance.Entity.Expertise;

@Component
public class ExpertiseMapper {

    public ExpertiseRes toDto(Expertise expertise) {
        if (expertise == null) {
            return null;
        }

        return new ExpertiseRes(
                expertise.getId(),
                expertise.getDescrizione(),
                expertise.getDataCreazione(),
                expertise.getClaim() != null ? expertise.getClaim().getId() : null,
                expertise.getExpert() != null ? expertise.getExpert().getId() : null,
                expertise.getExpert() != null
                        ? expertise.getExpert().getNome() + " " + expertise.getExpert().getCognome()
                        : null
        );
    }
}
