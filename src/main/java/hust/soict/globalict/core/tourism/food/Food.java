package hust.soict.globalict.core.tourism.food;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Food extends Tourism {
    private final String ingredient = "?data dbo:ingredient ?ingredient.";
    private final String name = "?data foaf:name ?name.";

    public Food() {
        super();
        super.constructQueryPart += ingredient + "\n"
                + name + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(ingredient)
                + SparqlUtils.convertOptionalQuery(name);
    }
}
