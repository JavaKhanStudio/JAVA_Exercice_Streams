package sbp.stream.exercices.complexe.exo2;

import sbp.stream.exercices.complexe.exo2.data.*;
import sbp.stream.exercices.complexe.exo2.model.RapportClimatJournalier;

import java.util.ArrayList;
import java.util.List;

public class BanqueDeDonnees {


    public List<RapportClimatJournalier> theList ;

    public BanqueDeDonnees() {
        theList = new ArrayList<>();

        theList.addAll(ClimateData2022_BFC.getData());
        theList.addAll(ClimateData2023_BFC.getData());
        theList.addAll(ClimateData2024_BFC.getData());

        theList.addAll(ClimateData2022_Bretagne.getData());
        theList.addAll(ClimateData2023_Bretagne.getData());
        theList.addAll(ClimateData2024_Bretagne.getData());

        theList.addAll(ClimateData2022_Corse.getData());
        theList.addAll(ClimateData2023_Corse.getData());
        theList.addAll(ClimateData2024_Corse.getData());

        theList.addAll(ClimateData2022_CVDL.getData());
        theList.addAll(ClimateData2023_CVDL.getData());
        theList.addAll(ClimateData2024_CVDL.getData());

        theList.addAll(ClimateData2022_GrandEst.getData());
        theList.addAll(ClimateData2023_GrandEst.getData());
        theList.addAll(ClimateData2024_GrandEst.getData());

        theList.addAll(ClimateData2022_HautsDeFrance.getData());
        theList.addAll(ClimateData2023_HautsDeFrance.getData());
        theList.addAll(ClimateData2024_HautsDeFrance.getData());

        theList.addAll(ClimateData2022_IDF.getData());
        theList.addAll(ClimateData2023_IDF.getData());
        theList.addAll(ClimateData2024_IDF.getData());

        theList.addAll(ClimateData2022_Normandie.getData());
        theList.addAll(ClimateData2023_Normandie.getData());
        theList.addAll(ClimateData2024_Normandie.getData());

        theList.addAll(ClimateData2022_OCCITANIE.getData());
        theList.addAll(ClimateData2023_OCCITANIE.getData());
        theList.addAll(ClimateData2024_OCCITANIE.getData());
    }


}
