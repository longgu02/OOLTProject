package hust.soict.globalict.core.tourism.attraction.manMadeAttraction;

import hust.soict.globalict.core.tourism.attraction.Attraction;
import hust.soict.globalict.core.utils.SparqlUtils;

public class ManMadeAttraction extends Attraction {
    private final String year = "?data dbp:year ?year.";

    public ManMadeAttraction(){
        super();
        super.constructQueryPart += year + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(year);
    }
}
