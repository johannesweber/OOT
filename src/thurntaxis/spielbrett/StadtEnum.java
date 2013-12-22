package thurntaxis.spielbrett;

/**
 * Created by Johannes on 21.12.13.
 */
public enum StadtEnum {

    MANNHEIM(LandEnum.BADEN), CARLSRUHE(LandEnum.BADEN), FREIBURG(LandEnum.BADEN),

    BASEL(LandEnum.SCHWEIZ), ZUERICH(LandEnum.SCHWEIZ),

    INNSBRUCK(LandEnum.TYROL),

    SALZBURG(LandEnum.SALZBURG), LINZ(LandEnum.SALZBURG),

    BUDWEIS(LandEnum.BOEHMEN), PILSEN(LandEnum.BOEHMEN),

    LODS(LandEnum.POLEN),

    WUERZBURG(LandEnum.BAIERN), NUERNBERG(LandEnum.BAIERN), KEMPTEN(LandEnum.BAIERN),
    MUENCHEN(LandEnum.BAIERN), PASSAU(LandEnum.BAIERN), AUGSBURG(LandEnum.BAIERN),
    INGOLSTADT(LandEnum.BAIERN), REGENSBURG(LandEnum.BAIERN),

    STUTTGART(LandEnum.WUERTTEMBERG), ULM(LandEnum.WUERTTEMBERG),

    SIGMARINGEN(LandEnum.HOHENZOLLERN);

    private LandEnum land;

    private StadtEnum(LandEnum land) {
        this.land = land;
    }

    public LandEnum getLand() {
        return land;
    }
}
