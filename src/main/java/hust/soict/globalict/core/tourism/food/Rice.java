package hust.soict.globalict.core.tourism.food;

import hust.soict.globalict.core.utils.SparqlUtils;

public class Rice extends Food{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/food/Rice";
    private final String query = """
                ?data dct:subject dbc:Vietnamese_rice_dishes.
            """;

    public Rice() {
        super();
        super.path = this.path;
        super.whereQueryPart += query;
    }
}
