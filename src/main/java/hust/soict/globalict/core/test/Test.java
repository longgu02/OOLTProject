package hust.soict.globalict.core.test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

import hust.soict.globalict.core.tourism.attraction.Attraction;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.Bridge;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Pagoda;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Skycraper;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Temple;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.NationalPark;

public class Test {
    public static void main(String[] args) {
        String serviceQuery = "http://dbpedia.org/sparql";
//        Tourism test = new Tourism();
//        Building buildingTest = new Building();
        Attraction attractionTest = new Attraction();
        Pagoda pagodaTest = new Pagoda();
        NationalPark parkTest = new NationalPark();
        Bridge bridgeTest = new Bridge();
        Skycraper skycraperTest = new Skycraper();
        Temple templeTest = new Temple();
        
        String queryString = skycraperTest.getSPARQLQuery();
        String queryString2 = templeTest.getSPARQLQuery();

        System.out.println(queryString);

        Query query = QueryFactory.create(queryString);
        try(QueryExecution qexec = QueryExecution.service(serviceQuery).query(query).build()) {
            // CONSTRUCT QUERY
            Model results = qexec.execConstruct();
            results.write(System.out, "TURTLE");
            OutputStream fileOutput = new FileOutputStream(
                    "src/main/java/hust/soict/globalict/core/resources/data/"
                    + bridgeTest.getExportedFileName() + ".ttl");
            results.write(fileOutput, "TURTLE");
            // SELECT QUERY
//			ResultSet rs = qexec.execSelect();
//            ResultSetFormatter.out(System.out, rs, query);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
