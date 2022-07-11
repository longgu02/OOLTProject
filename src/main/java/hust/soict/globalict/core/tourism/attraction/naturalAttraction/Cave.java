package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

public class Cave extends NaturalAttraction{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/naturalAttraction/Cave";
    private final String length = "?data dbo:length ?length.";
    private final String depth = "?data dbp:depth ?depth.";
    private final String discovery = "?data dbp:discovery ?discovery.";
    private final String survey = "?data dbp:survey ?survey.";
    private final String date = "?data dbp:date ?date.";
    private final String query = """
                ?data dct:subject dbc:Caves_of_Vietnam.
            """;


    public Cave(){
        super();
        super.path = this.path;
        super.constructQueryPart += length + "\n"
                                + depth + "\n";
//                                + discovery + "\n"
//                                + survey + "\n"
//                                + date + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(length)
                                + SparqlUtils.convertOptionalQuery(depth)
//                                + SparqlUtils.convertOptionalQuery(discovery)
//                                + SparqlUtils.convertOptionalQuery(survey)
//                                + SparqlUtils.convertOptionalQuery(date)
                                + query;
    }
}
