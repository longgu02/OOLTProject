package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;

public class Temple extends Building {
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/attraction/manMadeAttraction/building/Temple";
    private final String temple = """
                    ?data dct:subject dbc:Confucian_temples_in_Vietnam.
                """;

    public Temple() {
        super();
        super.path = this.path;
        super.whereQueryPart += temple;
    }
}
