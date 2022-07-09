package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.tourism.attraction.Attraction;
import hust.soict.globalict.core.utils.SparqlUtils;

import java.util.Map;
import java.util.TreeMap;

public class NaturalAttraction extends Attraction {
    private String area = "?data dbp:area ?area";

    public NaturalAttraction(){
        super();
        super.constructQueryPart += SparqlUtils.convertOptionalQuery(area);
    }

    @Override
    public String getExportedFileName() {
        return "NaturalAttraction";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
