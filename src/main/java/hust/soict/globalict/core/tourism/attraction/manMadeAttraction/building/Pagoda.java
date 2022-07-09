package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;



import java.util.Map;
import java.util.TreeMap;

public class Pagoda extends Building {
    private String pagoda = """
                    ?data dct:subject dbc:Pagodas_in_Vietnam.
                """;

    public Pagoda() {
        super();
        super.whereQueryPart += pagoda;
    }

    @Override
    public String getExportedFileName() {
        return "Pagoda";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
