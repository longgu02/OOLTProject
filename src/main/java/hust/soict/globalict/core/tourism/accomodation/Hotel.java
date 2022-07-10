package hust.soict.globalict.core.tourism.accomodation;

import hust.soict.globalict.core.utils.SparqlUtils;

public class Hotel extends Accommodation {
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/accommodation/Hotel.ttl";
    private final String numberOfSuites = "?data dbo:numberOfSuites ?nos.";
    private final String query = """
                ?data dct:subject dbc:Hotels_in_Vietnam.
            """;
    public Hotel(){
        super();
        super.path = this.path;
        super.constructQueryPart += numberOfSuites + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(numberOfSuites) + query;
    }
}
