package hust.soict.globalict.screen.controller;

import java.util.Map;
import java.util.TreeMap;

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
import hust.soict.globalict.core.utils.Pair;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class DemoController {
    Map<String, Map<String, Pair<String, String>>> Category = new TreeMap<String, Map<String, Pair<String, String>>>();


    @FXML
    private TreeView<String> selectionFIleNameTree = new TreeView<String>();

    @FXML
    private Label informationLabel;

    @FXML
    private Label objectLabel;

    @FXML
    void selectItem() {
        TreeItem<String> item = selectionFIleNameTree.getSelectionModel().getSelectedItem();
        String content = "";
        if(item.getValue() != null && Category.containsKey(item.getValue())) {
        	System.out.println("Querying " + item.getValue());
        	String currentSubject = "";
        	Map<String, Pair<String, String>> itemData = Category.get(item.getValue()); 
          for(Map.Entry<String, Pair<String, String>> entry : itemData.entrySet()){
        	  String predicateObject = "	" + entry.getValue().getPredicate() + ": " + entry.getValue().getObject() + "\n";
        	  if(currentSubject.equals(entry.getKey())) {
        		  content += predicateObject;
        	  }else {
        		  content += entry.getKey() + ":\n" +  predicateObject;
        		  currentSubject = entry.getKey();
        	  }
          }
        }
        informationLabel.setText(content);
    }

    public void mapInitial() {
        Category.put("Culture", (new Culture()).getStructuredDataMap());
        Category.put("Festival", (new Festival()).getStructuredDataMap());
        Category.put("Beach", (new Beach()).getStructuredDataMap());
        Category.put("Cave", (new Cave()).getStructuredDataMap());
        Category.put("Lake", (new Lake()).getStructuredDataMap());
        Category.put("Skyscraper", (new Skyscraper()).getStructuredDataMap());
        Category.put("Pagoda", (new Pagoda()).getStructuredDataMap());
        Category.put("Temple", (new Temple()).getStructuredDataMap());
        Category.put("National Park", (new NationalPark()).getStructuredDataMap());
        Category.put("Hotel", (new Hotel()).getStructuredDataMap());
        Category.put("Resort", (new Resort()).getStructuredDataMap());
        Category.put("Bridge", (new Bridge()).getStructuredDataMap());
        Category.put("Airport", (new Airport()).getStructuredDataMap());
        Category.put("Railway Station", (new RailwayStation()).getStructuredDataMap());
    }

    public DemoController() {
        super();
    }

    public void initialize() {
    	mapInitial();
        String [] mainTopic = {"Attraction",
                "Festival",
                "Culture",
                "Accomodation",
                "Travel"
        };
        String [][] subTopic = {{"NaturalAttraction", "ManMadeAttraction"},
                {"Festival", null},
                {"Culture", null},
                {"Accomodation", null},
                {"Travel", null},
        };
        String [][][] objectTopic = { {{"Beach", "National Park", "Lake", "Cave"}, {"Bridge", "Skyscraper","Temple","Museum"}},
                {{"Festival", null, null, null}, {null, null, null,null}},
                {{"Culture", null, null, null}, {null, null, null,null}},
                {{"Resort", null, null, null}, {"Hotel", null, null,null}},
                {{"Railway Station", null, null, null}, {"Airport", null, null,null}},

        };
        TreeItem<String> rootItem = new TreeItem<String>("Tourism");
        TreeItem<String> item = new TreeItem<String>();
        TreeItem<String> subItem = new TreeItem<String>();
        TreeItem<String> object = new TreeItem<String>();
        for(int i = 0; i < mainTopic.length; i++) {
            item = new TreeItem<String>(mainTopic[i]);

            for(int j = 0; j < subTopic[i].length; j++) {
                if(subTopic[i][j] != null) {
                    subItem = new TreeItem<String>(subTopic[i][j]);
                    item.getChildren().add(subItem);
                }

                for(int k = 0; k < objectTopic[i][j].length; k++) {
                    if(objectTopic[i][j][k] != null) {
                        object = new TreeItem<String>(objectTopic[i][j][k]);
                        subItem.getChildren().add(object);
                    }
                }
            }

            rootItem.getChildren().add(item);
        }

        selectionFIleNameTree.setRoot(rootItem);
        selectionFIleNameTree.setShowRoot(false);

    }


}
