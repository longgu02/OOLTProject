package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

public class Lake extends NaturalAttraction{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/naturalAttraction/Lake.ttl";
    private final String averageDepth = "?data dbo:averageDepth ?avgdepth.";
    private final String elevation = "?data dbo:elevation ?elevation.";
    private final String maximumDepth = "?data dbo:maximumDepth ?maxdepth.";
    private final String areaTotal = "?data dbo:areaTotal ?area.";
    private final String query = """
                ?data dct:subject dbc:Lakes_of_Vietnam.
            """;
    public Lake(){
        super();
        super.path = this.path;
        super.constructQueryPart += averageDepth + "\n"
//                                + elevation + "\n"
                                + maximumDepth + "\n";
//                                + areaTotal + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(averageDepth)
//                                +  SparqlUtils.convertOptionalQuery(elevation)
                                +  SparqlUtils.convertOptionalQuery(maximumDepth)
//                                +  SparqlUtils.convertOptionalQuery(areaTotal)
                                +  query;
    }
}
