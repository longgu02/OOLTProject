package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;

import java.util.Map;
import java.util.TreeMap;

import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.ManMadeAttraction;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Skycraper extends ManMadeAttraction{

    private String owner = "?data dbp:owner ?owner.";
    private String address = "?data dbo:address ?address.";
    private String height = "?data dbo:height ?height.";
//    private String survey = "?data dbp:survey ?survey";
//    private String date = "?data dbp:date ?date";
    private String query = """
                ?data dct:subject dbc:Skyscraper_office_buildings_in_Vietnam.
            """;

    public Skycraper(){
        super();
        super.constructQueryPart += SparqlUtils.convertOptionalQuery(owner)
                                + SparqlUtils.convertOptionalQuery(address)
                                + SparqlUtils.convertOptionalQuery(height)
//                                + SparqlUtils.convertOptionalQuery(survey)
//                                + SparqlUtils.convertOptionalQuery(date)
                                + SparqlUtils.convertOptionalQuery(query)
                                + query;
    }

    @Override
    public String getExportedFileName() {
        return "Skycraper";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }


}
