package hust.soict.globalict.core.tourism.accomodation;

import hust.soict.globalict.core.utils.SparqlUtils;

public class Resort extends Accommodation{

    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/accommodation/Resort.ttl";
    private final String numberOfBars = "?data dbo:numberOfBars ?nob.";
    private final String numberOfRestaurants = "?data dbo:numberOfRestaurants ?nor.";
    private final String query = """
                ?data dct:subject dbc:Resorts_in_Vietnam.
            """;
    public Resort(){
        super();
        super.path = this.path;
        super.constructQueryPart += numberOfBars + "\n"
                                + numberOfRestaurants + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(numberOfBars)
                                +  SparqlUtils.convertOptionalQuery(numberOfRestaurants)
                                + query;
    }
}
