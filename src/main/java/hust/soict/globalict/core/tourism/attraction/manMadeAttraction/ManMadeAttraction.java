package hust.soict.globalict.core.tourism.attraction.manMadeAttraction;

import hust.soict.globalict.core.tourism.attraction.Attraction;
import hust.soict.globalict.core.utils.SparqlUtils;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class ManMadeAttraction extends Attraction {
    private String year = "?data dbp:year ?year.";

    public ManMadeAttraction(){
        super();
        super.constructQueryPart += year + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(year);
    }

    @Override
    public String getExportedFileName() {
        return "ManMadeAttraction";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
