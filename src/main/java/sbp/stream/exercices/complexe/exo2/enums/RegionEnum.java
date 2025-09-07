package sbp.stream.exercices.complexe.exo2.enums;

public enum RegionEnum {

    AUVERGNE_RHONE_ALPES("Auvergne-Rhône-Alpes"),
    BOURGOGNE_FRANCHE_COMTE("Bourgogne-Franche-Comté"),
    BRETAGNE("Bretagne"),
    CENTRE_VAL_DE_LOIRE("Centre-Val de Loire"),
    CORSE("Corse"),
    GRAND_EST("Grand Est"),
    HAUTS_DE_FRANCE("Hauts-de-France"),
    ILE_DE_FRANCE("Île-de-France"),
    NORMANDIE("Normandie"),
    NOUVELLE_AQUITAINE("Nouvelle-Aquitaine"),
    OCCITANIE("Occitanie"),
    PAYS_DE_LA_LOIRE("Pays de la Loire"),
    PROVENCE_ALPES_COTE_DAZUR("Provence-Alpes-Côte d'Azur"),

    GUADELOUPE("Guadeloupe"),
    MARTINIQUE("Martinique"),
    GUYANE("Guyane"),
    REUNION("La Réunion"),
    MAYOTTE("Mayotte");

    private final String displayName;

    RegionEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
