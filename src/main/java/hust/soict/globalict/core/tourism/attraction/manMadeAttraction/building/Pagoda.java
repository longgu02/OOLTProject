package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;

public class Pagoda extends Building {
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/manMadeAttraction/building/Pagoda";
    private final String pagoda = """
                    ?data dct:subject dbc:Pagodas_in_Vietnam.
                """;

    public Pagoda() {
        super();
        super.path = this.path;
        super.whereQueryPart += pagoda;
    }
}
