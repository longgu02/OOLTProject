package hust.soict.globalict.core.tourism.attraction;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;
import java.util.Map;
import java.util.TreeMap;

public class Attraction extends Tourism {
    private String geolat = "?data geo:lat ?lat.";
    private String geolong = "?data geo:long ?long.";

    private String georss = "?data georss:point ?point.";
    private String location = "?data dbp:location ?location.";

    public Attraction(){
        super();
        super.constructQueryPart += georss + "\n"
//                                + geolong + "\n"
                                + location + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(georss)
//                            + SparqlUtils.convertOptionalQuery(geolong)
                            + SparqlUtils.convertOptionalQuery(location);
    }

    @Override
    public String getExportedFileName() {
        return "Attraction";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
