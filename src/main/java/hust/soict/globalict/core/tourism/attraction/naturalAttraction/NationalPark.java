package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

import java.util.Map;
import java.util.TreeMap;

public class NationalPark extends NaturalAttraction{

    private String governingBody = "?data dbp:governingBody";
    private String nearestCity = "?data dbp:nearestCity ?city";
    private String areaTotal = "?data dbo:areaTotal ?area";
    private String established = "?data dbp:established ?established";
    private String whereQuery = """
                ?data dct:subject dbc:National_parks_of_Vietnam.
            """;

    public NationalPark(){
        super();
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(governingBody)
                            + SparqlUtils.convertOptionalQuery(nearestCity)
                            + SparqlUtils.convertOptionalQuery(areaTotal)
                            + SparqlUtils.convertOptionalQuery(established)
                            + whereQuery;
    }

    @Override
    public String getExportedFileName() {
        return "NationalPark";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
