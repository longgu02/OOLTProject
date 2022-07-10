package hust.soict.globalict.core.test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

import hust.soict.globalict.core.exceptions.QueryException;
import hust.soict.globalict.core.tourism.Tourism;
import hust.soict.globalict.core.tourism.accomodation.Accommodation;
import hust.soict.globalict.core.tourism.accomodation.Hotel;
import hust.soict.globalict.core.tourism.accomodation.Resort;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Beach;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Cave;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Lake;
import hust.soict.globalict.core.tourism.culture.Culture;
import hust.soict.globalict.core.tourism.festival.Festival;
import hust.soict.globalict.core.tourism.travel.Airport;
import hust.soict.globalict.core.tourism.travel.RailwayStation;
import hust.soict.globalict.core.tourism.travel.Travel;
import hust.soict.globalict.core.utils.Pair;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

import hust.soict.globalict.core.tourism.attraction.Attraction;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.Bridge;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Pagoda;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Skyscraper;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Temple;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.NationalPark;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String serviceQuery = "http://dbpedia.org/sparql";
//        Building buildingTest = new Building();
        Attraction attractionTest = new Attraction();
        Pagoda pagodaTest = new Pagoda();
        NationalPark parkTest = new NationalPark();
        Bridge bridgeTest = new Bridge();
//        Skyscraper skycraperTest = new Skyscraper();
        Beach beachTest = new Beach();
        Cave caveTest = new Cave();
        Lake lakeTest = new Lake();
        Airport airportTest = new Airport();
        RailwayStation railwayStationTest = new RailwayStation();
        Travel travelTest = new Travel();
        Temple templeTest = new Temple();
        Resort resortTest = new Resort();
        Hotel hotelTest = new Hotel();
        Skyscraper skyscraperTest = new Skyscraper();
        Accommodation accommodationTest = new Accommodation();
        Culture cultureTest = new Culture();
        Festival festivalTest = new Festival();
        Map<String, Pair<String, String>> testMap = pagodaTest.getStructuredDataMap();
//        test.getStructuredDatMap();
//        for(Map.Entry<String, Pair<String, String>> entry : testMap.entrySet()){
//            System.out.println(entry.getKey() + "\n" + entry.getValue().getPredicate() + "\n" + entry.getValue().getObject());
//            System.out.println("--------------------------------------------");
//        }
//        try{
////            festivalTest.executeQuery();
//        }catch(QueryException e){
//            System.err.println(e.getMessage());
//        }
        try {
			hotelTest.executeQuery();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

//        System.out.println(queryString);

//        Query query = QueryFactory.create(queryString);
//        try(QueryExecution qexec = QueryExecution.service(serviceQuery).query(query).build()) {
//            // CONSTRUCT QUERY
//
//            Map<String, Pair<String, String>> test = new TreeMap<String, Pair<String, String>>();
//            Model results = qexec.execConstruct();
//            results.write(System.out, "TURTLE");
//            StmtIterator it =  results.listStatements();
//            while (it.hasNext()) {
//                Statement statement = it.next();
//                String subject = statement.getSubject().toString().split("/")[3].replace("_", " ");
//                String predicate = statement.getPredicate().toString().split("/")[3].replace("_", " ");
//                String object = object = statement.getObject().toString();
//                test.put(subject, new Pair<String, String>(predicate, object));
//            }
//            for(Map.Entry<String, Pair<String, String>> entry : test.entrySet()){
//                System.out.println(entry.getKey() + "\n" + entry.getValue().getPredicate() + "\n" + entry.getValue().getObject());
//                System.out.println("--------------------------------------------");
//            }

//            results.write(festivalTest.getExportedFileStream(), "TURTLE");
            //  SELECT QUERY
//            ResultSet rs = qexec.execSelect();
//            ResultSetFormatter.out(System.out, rs, query);
//        }
    }
}
