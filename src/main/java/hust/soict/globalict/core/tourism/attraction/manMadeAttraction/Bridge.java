package hust.soict.globalict.core.tourism.attraction.manMadeAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

import java.util.Map;
import java.util.TreeMap;

public class Bridge extends ManMadeAttraction{
    private String width = "?data dbo:width ?width.";
//    private String infrastructure = "?data dbo:\"infrastructure/length\" ?in.";
    private String bridgeCarries = "?data dbo:bridgeCarries ?bc.";
    private String crosses = "?data dbo:crosses ?cr.";
//    private String length = "?data dbo:length ?len.";
    private String whereQuery = """
            ?data dct:subject dbc:Road_bridges_in_Vietnam.
            """;

    public Bridge(){
        super();
        super.constructQueryPart += width + "\n"
//                                    + infrastructure + "\n"
                                    + crosses + "\n";
//                                    + length + "\n";
        super.whereQueryPart += SparqlUtils.convertOptionalQuery(width)
//                            + SparqlUtils.convertOptionalQuery(infrastructure)
                            + SparqlUtils.convertOptionalQuery(crosses)
//                            + SparqlUtils.convertOptionalQuery(length)
                            + whereQuery;
    }

    @Override
    public String getExportedFileName() {
        return "Bridge";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
