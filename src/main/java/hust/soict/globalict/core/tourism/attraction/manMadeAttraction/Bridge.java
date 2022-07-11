package hust.soict.globalict.core.tourism.attraction.manMadeAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

public class Bridge extends ManMadeAttraction{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/manMadeAttraction/Bridge";
    private final String width = "?data dbo:width ?width.";
//    private String infrastructure = "?data dbo:\"infrastructure/length\" ?in.";
    private final String bridgeCarries = "?data dbo:bridgeCarries ?bc.";
    private final String crosses = "?data dbo:crosses ?cr.";
//    private String length = "?data dbo:length ?len.";
    private final String whereQuery = """
            ?data dct:subject dbc:Road_bridges_in_Vietnam.
            """;

    public Bridge(){
        super();
        super.path = this.path;
        super.constructQueryPart += width + "\n"
//                                    + infrastructure + "\n"
                                    + crosses + "\n";
//                                    + length + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(width)
//                            + SparqlUtils.convertOptionalQuery(infrastructure)
                            + SparqlUtils.convertOptionalQuery(crosses)
//                            + SparqlUtils.convertOptionalQuery(length)
                            + whereQuery;
    }
}
