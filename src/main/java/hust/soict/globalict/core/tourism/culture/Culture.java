package hust.soict.globalict.core.tourism.culture;

import java.util.Map;
import java.util.TreeMap;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;

public class Culture extends Tourism{
	private String label = "?data rdfs:label ?label." ;
	private String comment = "?data rdfs:comment ?comment.";
	private String wasDerivedFrom = "?data prov:wasDerivedFrom ?wasDerivedFrom.";
	private String query = """
            ?data dct:subject dbc:Archaeological_cultures_in_Vietnam.
        """;
	
	public Culture() {
		 super();
	        super.constructQueryPart += SparqlUtils.convertOptionalQuery(label)
	                                + SparqlUtils.convertOptionalQuery(comment)
	                                + SparqlUtils.convertOptionalQuery(wasDerivedFrom)
//	                                + SparqlUtils.convertOptionalQuery(date)
//	                                + SparqlUtils.convertOptionalQuery(frequency)
//	                                + SparqlUtils.convertOptionalQuery(significance)
	                                + SparqlUtils.convertOptionalQuery(query)
	                                + query;
	}
	
	@Override
    public String getExportedFileName() {
        return "Culture";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
