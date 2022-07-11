package hust.soict.globalict.core.tourism.food;

public class Noodle extends Food{
    private String path = "src/main/java/hust/soict/globalict/core/resources/data/food/Noodle";
    private final String query = """
                ?data dct:subject dbc:Vietnamese_noodle_dishes.
            """;

    public Noodle(){
        super();
        super.path = this.path;
        super.whereQueryPart += query;
    }
}
