package hust.soict.globalict.core.tourism.accomodation;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Accommodation extends Tourism {
    private final String location = "?data dbo:location ?location.";
    private final String name = "?data dbp:name ?name.";
    private final String website = "?data dbp:website ?web.";

    public Accommodation() {
        super();
        super.constructQueryPart += location + "\n"
                + name + "\n"
                + website + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(location)
                + SparqlUtils.convertOptionalQuery(name)
                + SparqlUtils.convertOptionalQuery(website);
    }
}
