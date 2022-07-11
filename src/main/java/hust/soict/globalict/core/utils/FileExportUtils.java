package hust.soict.globalict.core.utils;

import hust.soict.globalict.core.exceptions.FileTypeNotValidException;
import hust.soict.globalict.core.exceptions.QueryException;
import hust.soict.globalict.core.tourism.accomodation.Hotel;
import hust.soict.globalict.core.tourism.accomodation.Resort;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.Bridge;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Pagoda;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Skyscraper;
import hust.soict.globalict.core.tourism.attraction.manMadeAttraction.building.Temple;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Beach;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Cave;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.Lake;
import hust.soict.globalict.core.tourism.attraction.naturalAttraction.NationalPark;
import hust.soict.globalict.core.tourism.culture.Culture;
import hust.soict.globalict.core.tourism.festival.Festival;
import hust.soict.globalict.core.tourism.travel.Airport;
import hust.soict.globalict.core.tourism.travel.RailwayStation;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import java.io.*;
import java.util.*;

public class FileExportUtils {
    private static Set<String> allowFileType = Set.of("TURTLE", "TTL", "turtle",
            "N-TRIPLES", "N-TRIPLE", "NT", "JSON-LD", "RDF/XML-ABBREV", "RDF/XML", "N3", "RDF/JSON");
    private static Map<String, String> suffix = new TreeMap<>();

    public static void init(){
        suffix.put("TURTLE", ".ttl");
        suffix.put("TTL", ".ttl");
        suffix.put("turtle", ".ttl");
        suffix.put("N-TRIPLES", ".nt");
        suffix.put("N-TRIPLE", ".nt");
        suffix.put("NT", ".nt");
        suffix.put("JSON-LD", ".json-ld");
        suffix.put("RDF/XML-ABBREV", ".rdf");
        suffix.put("RDF/XML", ".rdf");
        suffix.put("N3", ".n3");
        suffix.put("RDF/JSON", ".rdf");
    }
    public static void exportFile(Model model, String filePath, String fileType) throws FileNotFoundException, FileTypeNotValidException {
        init();
        filePath += suffix.get(fileType);
        try{
            OutputStream outputStream = new FileOutputStream(filePath);
            if(allowFileType.contains(fileType)){
                model.write(outputStream, fileType);
            }else{
                throw new FileTypeNotValidException("Please check your file type");
            }
        }catch(FileNotFoundException e){
            throw new FileNotFoundException("Please check your path");
        }
    }

    public static void exportFileFromQuery(String queryString, String filePath, String fileType){
        init();
        String serviceQuery = "http://dbpedia.org/sparql";
        try{
            Query query = QueryFactory.create(queryString);
            try(QueryExecution qexec = QueryExecution.service(serviceQuery).query(query).build()) {
                if(queryString.toLowerCase().contains("select")){
                    // SELECT QUERY
                    filePath += ".txt";
                    OutputStream outputStream = new FileOutputStream(filePath);
                    ResultSet resultset = qexec.execSelect();
                    ResultSetFormatter.out(System.out, resultset, query);
                    ResultSetFormatter.out(outputStream, resultset, query);
//                    ResultSetFormatter.out(outputStream, rs);
                    // Do smth with the resultset
                }else{
                    Model results = qexec.execConstruct();
                    StmtIterator it =  results.listStatements();
                    Statement statement = it.next();
                    String subjectCheck = statement.getSubject().toString();
                    if(!subjectCheck.equals("https://dbpedia.org/sparql#service")){
                        results.write(System.out, fileType);
                        exportFile(results, filePath, fileType);
                    }else{
                        throw new QueryException("Your Query is too long, please reduce it");
                    }
                }

            } catch (FileTypeNotValidException e) {
                throw new RuntimeException(e);
            } catch (QueryException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }catch(QueryParseException e){
            System.err.println(e.getMessage());
        }catch(QueryExecException e){
            System.err.println(e.getMessage());
        }
    }


}
