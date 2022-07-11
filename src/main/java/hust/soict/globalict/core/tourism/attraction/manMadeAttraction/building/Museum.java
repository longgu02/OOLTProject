package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;

public class Museum extends Building{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/manMadeAttraction/building/Museum.ttl";
    private final String pagoda = """
                    ?data dct:subject dbc:Museums_in_Vietnam.
                """;

    public Museum() {
        super();
        super.path = this.path;
        super.whereQueryPart += pagoda;
    }
}
