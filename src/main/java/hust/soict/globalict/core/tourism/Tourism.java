package hust.soict.globalict.core.tourism;



import java.util.Map;
import java.util.TreeMap;

public class Tourism {
    protected String prefixesQueryPart = """
                    PREFIX dbo: <http://dbpedia.org/ontology/>
                    PREFIX dbp: <http://dbpedia.org/property/>
                    PREFIX dbc: <http://dbpedia.org/resource/Category:>
                    PREFIX dbr: <http://dbpedia.org/resource/>
                    PREFIX dct: <http://purl.org/dc/terms/>
                    PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                    PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
                    PREFIX skos: <http://www.w3.org/2004/02/skos/core#>
                    PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                    PREFIX foaf: <http://xmlns.com/foaf/0.1/>
                    PREFIX georss: <http://www.georss.org/georss/>
                    PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>
                    """;
    protected String constructQueryPart = """
                    CONSTRUCT{
                    ?data dbo:abstract ?abstract.
                    ?data dbo:wikiPageWikiLink ?wiki.
                    ?data dbo:country ?country.
                    """;
    protected String whereQueryPart = """
                    WHERE{
                        ?data dbo:abstract ?abstract.
                        OPTIONAL{?data dbo:wikiPageWikiLink ?wiki.}
                        OPTIONAL{?data dbo:country ?country.}
                    """;

    public Tourism(){

    }

    public String getSPARQLQuery(){
        String SparqlQuery = prefixesQueryPart
                + constructQueryPart + "}"
                + whereQueryPart + "}";
        return SparqlQuery;
    }

    public String getExportedFileName() {
        return "Tourism";
    }

    public Map<String, String> getStructuredDatMap() {
        Map<String, String> structuredDataMap = new TreeMap<String, String>();
        return structuredDataMap;
    }
}
