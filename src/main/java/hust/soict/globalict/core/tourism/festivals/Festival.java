package hust.soict.globalict.core.tourism.festivals;

import java.util.Map;
import java.util.TreeMap;

import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.utils.SparqlUtils;


public class Festival extends Tourism{
	private String meaning = "?data dbo:meaning ?meaning.";
    private String similar = "?data dbo:similar ?similar.";
    private String celebrations = "?data dbp:celebrations ?celebration.";
    private String date = "?data dbp:date ?date";
    private String frequency = "?data dbp:frequency ?frequency.";
    private String significance = "?data dbp:significance ?significance.";
    private String query = """
	                ?data dct:subject dbc:Festivals_in_Vietnam.
	            """;

	public Festival() {
		 super();
	        super.constructQueryPart += SparqlUtils.convertOptionalQuery(meaning)
	                                + SparqlUtils.convertOptionalQuery(similar)
	                                + SparqlUtils.convertOptionalQuery(celebrations)
	                                + SparqlUtils.convertOptionalQuery(date)
	                                + SparqlUtils.convertOptionalQuery(frequency)
	                                + SparqlUtils.convertOptionalQuery(significance)
	                                + SparqlUtils.convertOptionalQuery(query)
	                                + query;
	}
	
    @Override
    public String getExportedFileName() {
        return "Festival";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }

}
