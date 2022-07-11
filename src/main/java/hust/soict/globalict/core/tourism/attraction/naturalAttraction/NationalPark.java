package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;


public class NationalPark extends NaturalAttraction{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/naturalAttraction/NationalPark";
    private final String governingBody = "?data dbp:governingBody ?gov.";
    private final String nearestCity = "?data dbp:nearestCity ?city.";
    private final String areaTotal = "?data dbo:areaTotal ?area.";
    private final String established = "?data dbp:established ?established.";
    private final String whereQuery = """
                ?data dct:subject dbc:National_parks_of_Vietnam.
            """;

    public NationalPark(){
        super();
        super.path = this.path;
        super.constructQueryPart += governingBody + "\n"
//                                    + nearestCity + "\n"
//                                    + areaTotal + "\n"
                                    + established + "\n";

        super.whereQueryPart += SparqlUtils.convertOptionalQuery(governingBody)
//                            + SparqlUtils.convertOptionalQuery(nearestCity)
//                            + SparqlUtils.convertOptionalQuery(areaTotal)
                            + SparqlUtils.convertOptionalQuery(established)
                            + whereQuery;
    }
}
