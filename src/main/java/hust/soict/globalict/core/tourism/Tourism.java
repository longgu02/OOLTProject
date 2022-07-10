package hust.soict.globalict.core.tourism;



import hust.soict.globalict.core.exceptions.QueryException;
import hust.soict.globalict.core.utils.Pair;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public abstract class Tourism {
    protected String path;
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

    public String getSPARQLQuery(){
        return prefixesQueryPart
                + constructQueryPart + "}"
                + whereQueryPart + "}";
    }

    public void executeQuery() throws QueryException {
        String serviceQuery = "http://dbpedia.org/sparql";
        try{
            FileOutputStream fileLocation = new FileOutputStream(path);
            String queryString = this.getSPARQLQuery();
            Query query = QueryFactory.create(queryString);
            try(QueryExecution qexec = QueryExecution.service(serviceQuery).query(query).build()) {
                Model results = qexec.execConstruct();
                StmtIterator it =  results.listStatements();
                Statement statement = it.next();
                String subjectCheck = statement.getSubject().toString();
                if(!subjectCheck.equals("https://dbpedia.org/sparql#service")){
                    results.write(System.out, "TURTLE");
                    results.write(fileLocation, "TURTLE");
                }else{
                    throw new QueryException("Your Query is too long, please reduce it");
                }
            }
            // SELECT QUERY
//            ResultSet rs = qexec.execSelect();
//            ResultSetFormatter.out(System.out, rs, query);
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.err.println("Please check your file path");
        }
    }

    public Map<String, Pair<String, String>> getStructuredDataMap() {
        Map<String, Pair<String, String>> structuredDataMap = new TreeMap<>();
        Model model = RDFDataMgr.loadModel(path);
        StmtIterator it =  model.listStatements();
            while (it.hasNext()) {
                Statement statement = it.next();
                String subject = statement.getSubject().toString().split("/")[4].replace("_", " ");
                String predicate = statement.getPredicate().toString().split("/")[4].replace("_", " ");
                String object  = statement.getObject().toString();
                structuredDataMap.put(subject, new Pair<>(predicate, object));
            }
        return structuredDataMap;
    }
}
