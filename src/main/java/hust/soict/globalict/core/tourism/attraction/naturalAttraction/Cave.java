package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

import java.util.Map;
import java.util.TreeMap;

public class Cave extends NaturalAttraction{
    private String length = "?data dbo:length ?length.";
    private String depth = "?data dbp:depth ?depth.";
    private String discovery = "?data dbp:discovery ?discovery.";
    private String survey = "?data dbp:survey ?survey.";
    private String date = "?data dbp:date ?date.";
    private String query = """
                ?data dct:subject dbc:Caves_of_Vietnam.
            """;


    public Cave(){
        super();
        super.constructQueryPart += SparqlUtils.convertOptionalQuery(length)
                                + SparqlUtils.convertOptionalQuery(depth)
                                + SparqlUtils.convertOptionalQuery(discovery)
                                + SparqlUtils.convertOptionalQuery(survey)
                                + SparqlUtils.convertOptionalQuery(date)
                                + SparqlUtils.convertOptionalQuery(query)
                                + query;
    }

    @Override
    public String getExportedFileName() {
        return "Lake";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
