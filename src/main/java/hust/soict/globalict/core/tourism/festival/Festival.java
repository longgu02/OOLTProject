package hust.soict.globalict.core.tourism.festival;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;


public class Festival extends Tourism{
    private final String path = "src/main/java/hust/soict/globalict/core/resources/data/festival/Festival.ttl";
	private final String meaning = "?data dbo:meaning ?meaning.";
    private final String similar = "?data dbo:similar ?similar.";
    private final String celebrations = "?data dbp:celebrations ?celebration.";
    private final String date = "?data dbp:date ?date.";
    private final String frequency = "?data dbp:frequency ?frequency.";
    private final String significance = "?data dbp:significance ?significance.";
    private final String query = """
	                ?data dct:subject dbc:Festivals_in_Vietnam.
	            """;

	public Festival() {
		 super();
         super.path = this.path;
         super.constructQueryPart += meaning + "\n"
                                    + similar + "\n"
                                    + celebrations + "\n"
                                    + date + "\n";
//                                    + frequency + "\n"
//                                    + significance + "\n";
         super.whereQueryPart += SparqlUtils.convertOptionalQuery(meaning)
	                                + SparqlUtils.convertOptionalQuery(similar)
	                                + SparqlUtils.convertOptionalQuery(celebrations)
	                                + SparqlUtils.convertOptionalQuery(date)
//	                                + SparqlUtils.convertOptionalQuery(frequency)
//	                                + SparqlUtils.convertOptionalQuery(significance)
	                                + query;
	}
}
