package hust.soict.globalict.core.tourism.travel;

import hust.soict.globalict.core.utils.SparqlUtils;

public class RailwayStation extends Travel{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/travel/RailwayStation.ttl";
    private final String servingRailwayLine = "?data dbo:servingRailwayLine ?srl.";
    private final String query = """
                        ?data dct:subject dbc:Railway_stations_in_Vietnam.
                    """;

    public RailwayStation() {
        super();
        super.path = this.path;
        super.constructQueryPart += servingRailwayLine + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(servingRailwayLine)
                + query;
    }
}
