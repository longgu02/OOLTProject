package hust.soict.globalict.core.tourism.travel;

public class Airport extends Travel{
    private final String additionalPrefix = "    PREFIX yago: <http://dbpedia.org/class/yago/>\n";
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/travel/Airport.ttl";
    private final String query = """
                        ?data rdf:type yago:WikicatAirportsInVietnam.
                    """;

    public Airport() {
        super();
        super.path = this.path;
        super.prefixesQueryPart += additionalPrefix;
        super.whereQueryPart += query;
    }
}
