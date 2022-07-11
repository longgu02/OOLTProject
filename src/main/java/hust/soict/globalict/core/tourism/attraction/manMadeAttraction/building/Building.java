package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;

import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.ManMadeAttraction;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Building extends ManMadeAttraction{
    private final String province = "?data dbp:province ?province.";

    public Building() {
        super();
        super.constructQueryPart += province + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(province);
    }
}
