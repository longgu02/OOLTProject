package hust.soict.globalict.core.tourism.attraction.naturalAttraction;

import hust.soict.globalict.core.utils.SparqlUtils;

import java.util.Map;
import java.util.TreeMap;

public class Lake extends NaturalAttraction{
    private String averageDepth = "?data dbo:averageDepth ?avgdepth";
    private String elevation = "?data dbo:elevation ?elevation";
    private String maximumDepth = "?data dbo:maximumDepth ?maxdepth";
    private String areaTotal = "?data dbo:areaTotal ?area";
    private String whereQuery = """
                ?data dct:subject dbc:Lakes_of_Vietnam
            """;
    public Lake(){
        super();
        super.constructQueryPart += SparqlUtils.convertOptionalQuery(averageDepth)
                                +  SparqlUtils.convertOptionalQuery(elevation)
                                +  SparqlUtils.convertOptionalQuery(maximumDepth)
                                +  SparqlUtils.convertOptionalQuery(areaTotal)
                                +  whereQuery;
    }

    @Override
    public String getExportedFileName() {
        return "Lake";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
