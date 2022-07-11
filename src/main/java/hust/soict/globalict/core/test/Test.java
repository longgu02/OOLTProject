package hust.soict.globalict.core.test;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import hust.soict.globalict.core.exceptions.QueryException;
import hust.soict.globalict.core.tourism.accomodation.Accommodation;
import hust.soict.globalict.core.tourism.accomodation.Hotel;
import hust.soict.globalict.core.tourism.accomodation.Resort;
import hust.soict.globalict.core.tourism.attraction.Attraction;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.Bridge;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Museum;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Pagoda;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Skyscraper;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Temple;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Beach;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Cave;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Lake;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.NationalPark;
import hust.soict.globalict.core.tourism.culture.Culture;
import hust.soict.globalict.core.tourism.festival.Festival;
import hust.soict.globalict.core.tourism.food.Noodle;
import hust.soict.globalict.core.tourism.food.Rice;
import hust.soict.globalict.core.tourism.travel.Airport;
import hust.soict.globalict.core.tourism.travel.RailwayStation;
import hust.soict.globalict.core.tourism.travel.Travel;
import hust.soict.globalict.core.utils.FileExportUtils;
import hust.soict.globalict.core.utils.Pair;

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
        Museum museumTest = new Museum();
        Rice riceTest = new Rice();
        Noodle noodleTest = new Noodle();
//       try {
//		noodleTest.executeQuery("TURTLE");
//
//	} catch (QueryException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
        FileExportUtils.exportFileFromQuery("                    PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
                "                    PREFIX dbp: <http://dbpedia.org/property/>\n" +
                "                    PREFIX dbc: <http://dbpedia.org/resource/Category:>\n" +
                "                    PREFIX dbr: <http://dbpedia.org/resource/>\n" +
                "                    PREFIX dct: <http://purl.org/dc/terms/>\n" +
                "                    PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "                    PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "                    PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" +
                "                    PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "                    PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
                "                    PREFIX georss: <http://www.georss.org/georss/>\n" +
                "                    PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n" +
                "                    PREFIX yago: <http://dbpedia.org/class/yago/>" +
                "select distinct ?p where {\n" +
                "{?p rdf:type yago:WikicatVietnameseKings} \n" +
                "UNION \n" +
                "{?p rdf:type yago:WikicatVietnamesePoliticians}\n" +
                "} LIMIT 100\n", "src/main/java/hust/soict/globalict/core/resources/data/food/Test", "TURTLE");
//        Map<String, ArrayList<Pair<String, String>>> testMap = pagodaTest.getStructuredDataMap();
////        test.getStructuredDatMap();
//        for(Map.Entry<String, ArrayList<Pair<String, String>>> entry : testMap.entrySet()){
//            for(Pair<String, String> pair: entry.getValue()) {
//                System.out.println(entry.getKey() + "\n" + pair.getPredicate() + "\n" + pair.getObject());
//                System.out.println("--------------------------------------------");
//            }
//        }
//        try{
////            festivalTest.executeQuery();
//        }catch(QueryException e){
//            System.err.println(e.getMessage());
//        }
//        try {
//			museumTest.executeQuery();
//		} catch (QueryException e) {
//			System.err.println(e.getMessage());
//		}

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
