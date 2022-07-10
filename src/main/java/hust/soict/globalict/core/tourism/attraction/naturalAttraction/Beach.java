package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

import java.util.Map;
import java.util.TreeMap;

public class Beach extends NaturalAttraction{
    private String comment = "?data rdfs:comment ?comment.";
    private String label = "?data rdfs:label ?label.";
//    private String discovery = "?data dbp:discovery ?discovery";
//    private String survey = "?data dbp:survey ?survey";
//    private String date = "?data dbp:date ?date";
    private String query = """
                ?data dct:subject dbc:Beaches_of_Vietnam.
            """;

    public Beach(){
        super();
        super.constructQueryPart += SparqlUtils.convertOptionalQuery(comment)
                                + SparqlUtils.convertOptionalQuery(label)
//                                + SparqlUtils.convertOptionalQuery(discovery)
//                                + SparqlUtils.convertOptionalQuery(survey)
//                                + SparqlUtils.convertOptionalQuery(date)
                                + SparqlUtils.convertOptionalQuery(query)
                                + query;
    }

    @Override
    public String getExportedFileName() {
        return "Beach";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
