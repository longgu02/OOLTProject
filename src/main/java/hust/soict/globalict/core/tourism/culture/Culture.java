package hust.soict.globalict.core.tourism.culture;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Culture extends Tourism{
	private final String path = "src/main/java/hust/soict/globalict/core/resources/data/culture/Culture";
	private final String label = "?data rdfs:label ?label." ;
	private final String comment = "?data rdfs:comment ?comment.";
	private final String wasDerivedFrom = "?data prov:wasDerivedFrom ?wasDerivedFrom.";
	private final String additionalPrefix = "PREFIX prov: <http://www.w3.org/ns/prov#>";
	private final String query = """
            ?data dct:subject dbc:Archaeological_cultures_in_Vietnam.
        """;
	
	public Culture() {
		 super();
		 super.path = this.path;
		 super.prefixesQueryPart += additionalPrefix + "\n";
		 super.constructQueryPart += label + "\n"
		 							+ comment + "\n"
		 							+ wasDerivedFrom + "\n";
		 super.whereQueryPart += SparqlUtils.convertOptionalQuery(label)
	                                + SparqlUtils.convertOptionalQuery(comment)
	                                + SparqlUtils.convertOptionalQuery(wasDerivedFrom)
	                                + query;
	}

}
