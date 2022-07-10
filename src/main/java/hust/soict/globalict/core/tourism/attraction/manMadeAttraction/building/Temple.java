package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;



import java.util.Map;
import java.util.TreeMap;

public class Temple extends Building {
    private String temple = """
                    ?data dct:subject dbc:Confucian_temples_in_Vietnam.
                """;

    public Temple() {
        super();
        super.whereQueryPart += temple;
    }

    @Override
    public String getExportedFileName() {
        return "Temple";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
