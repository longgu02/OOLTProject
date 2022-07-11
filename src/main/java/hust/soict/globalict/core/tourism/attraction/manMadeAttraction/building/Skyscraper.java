package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;

import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.ManMadeAttraction;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Skyscraper extends ManMadeAttraction{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/manMadeAttraction/building/Skyscraper.ttl";
    private final String owner = "?data dbp:owner ?owner.";
    private final String address = "?data dbo:address ?address.";
    private final String height = "?data dbo:height ?height.";
//    private String survey = "?data dbp:survey ?survey";
//    private String date = "?data dbp:date ?date";
    private final String query = """
                ?data dct:subject dbc:Skyscraper_office_buildings_in_Vietnam.
            """;

    public Skyscraper(){
        super();
        super.path = this.path;
        super.constructQueryPart += address + "\n"
                                    + height + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(address)
                                + SparqlUtils.convertOptionalQuery(height)
//                                + SparqlUtils.convertOptionalQuery(survey)
//                                + SparqlUtils.convertOptionalQuery(date)
                                + query;
    }
}
