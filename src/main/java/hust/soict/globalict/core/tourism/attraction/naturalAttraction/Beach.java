package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

public class Beach extends NaturalAttraction{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/naturalAttraction/Beach";
    private final String comment = "?data rdfs:comment ?comment.";
    private final String label = "?data rdfs:label ?label.";
//    private String discovery = "?data dbp:discovery ?discovery";
//    private String survey = "?data dbp:survey ?survey";
//    private String date = "?data dbp:date ?date";
    private final String query = """
                ?data dct:subject dbc:Beaches_of_Vietnam.
            """;

    public Beach(){
        super();
        super.path = this.path;
        super.constructQueryPart += comment + "\n"
                                + label + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(comment)
                                + SparqlUtils.convertOptionalQuery(label)
//                                + SparqlUtils.convertOptionalQuery(discovery)
//                                + SparqlUtils.convertOptionalQuery(survey)
//                                + SparqlUtils.convertOptionalQuery(date)
                                + query;
    }
}
