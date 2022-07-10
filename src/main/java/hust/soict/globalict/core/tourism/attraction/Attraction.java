package hust.soict.globalict.core.tourism.attraction;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Attraction extends Tourism {
//    private final String geolat = "?data geo:lat ?lat.";
//    private final String geolong = "?data geo:long ?long.";

    private final String georss = "?data georss:point ?point.";
    private final String location = "?data dbp:location ?location.";

    public Attraction(){
        super();
        super.constructQueryPart += georss + "\n"
                                + location + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(georss)
                            + SparqlUtils.convertOptionalQuery(location);
    }
}
