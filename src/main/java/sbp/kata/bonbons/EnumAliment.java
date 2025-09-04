package sbp.kata.bonbons;

import lombok.Getter;

@Getter
public enum EnumAliment {

    JUJUBE(false, false, 10, 2000),
    MARSHMALLOW(false, false, 5, 3000),
    CHOCOLAT(true, false, 15, 3000),
    CHOCOLAT_ARACHIDE(true, true, 18, 4000),
    ;

    final private boolean isChocolat ;
    final private boolean asArachide;
    final private int sucreParKilo;
    final private int calorieParKilo;

    EnumAliment(boolean isChocolat, boolean asArachide, int sucreParKilo, int calorieParKilo) {
        this.isChocolat = isChocolat;
        this.asArachide = asArachide;
        this.sucreParKilo = sucreParKilo ;
        this.calorieParKilo = calorieParKilo;
    }
}
