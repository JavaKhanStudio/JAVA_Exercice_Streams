package sbp.stream.exercices.complexe.exo2.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sbp.stream.exercices.complexe.exo2.enums.RegionEnum;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class RapportClimatJournalier {

    RegionEnum region;
    Date date;
    int temperature;
    int pluieEnMl ;
    int ventKmH ;


    public RapportClimatJournalier(RegionEnum region, Date date, int temperature, int pluieEnMl, int ventKmH) {
        this.region = region;
        this.date = date;
        this.temperature = temperature;
        this.pluieEnMl = pluieEnMl;
        this.ventKmH = ventKmH;
    }
}
