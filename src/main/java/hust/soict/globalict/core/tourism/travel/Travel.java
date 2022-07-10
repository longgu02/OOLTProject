package hust.soict.globalict.core.tourism.travel;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;


public class Travel extends Tourism {
    private final String name = "?data dbp:name ?name.";
    private final String georss = "?data georss:point ?point.";
    private final String address = "?data dbo:address ?add.";
//    private String query = """
//                {?data dct:subject dbc:Railway_stations_in_Vietnam.}
//                UNION
//                {?data rdf:type yago:WikicatAirportsInVietnam.}
//            """;

    public Travel() {
        super();
        super.constructQueryPart += name + "\n"
                + georss + "\n"
                + address + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(name)
                + SparqlUtils.convertOptionalQuery(georss)
                + SparqlUtils.convertOptionalQuery(address);
//                + query;
    }
}
