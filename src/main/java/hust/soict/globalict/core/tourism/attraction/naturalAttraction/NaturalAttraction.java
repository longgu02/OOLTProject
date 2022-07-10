package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.tourism.attraction.Attraction;
import hust.soict.globalict.core.utils.SparqlUtils;


public class NaturalAttraction extends Attraction {
    private final String area = "?data dbp:area ?area.";

    public NaturalAttraction(){
        super();
        super.constructQueryPart += area + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(area);
    }
}
