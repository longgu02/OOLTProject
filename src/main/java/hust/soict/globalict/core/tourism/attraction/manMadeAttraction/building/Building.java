package hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building;

import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.ManMadeAttraction;

import java.util.Map;
import java.util.TreeMap;

public class Building extends ManMadeAttraction{
    private String province = """
                    ?data dbp:province ?province.
                """;
    private String optional = """
                    OPTIONAL{?data geo:lat ?lat.
                             ?data geo:long ?long.}
                    ?data dct:subject ?subject.
                    OPTIONAL{?data dbp:province ?province}
                    OPTIONAL{?data dbp:location ?location}
                    ?data dbp:country dbr:Vietnam.
                """;

    public Building() {
        super();
        super.constructQueryPart += province;
        super.whereQueryPart += optional;
    }

    @Override
    public String getExportedFileName() {
        return "Building";
    }

    @Override
    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
