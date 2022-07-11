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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoController {
    Map<String, Map<String, Pair<String, String>>> Category = new TreeMap<String, Map<String, Pair<String, String>>>();


    @FXML
    private ToggleGroup queryBtn;

    @FXML
    private ChoiceBox<String> typeOfFileChooseBox;

    @FXML
    private RadioButton radioBtnObjectQuery;

    @FXML
    private RadioButton radioBtnSubjectQuery;

    @FXML
    private TextField queryForm;
    
    @FXML
    private BorderPane tfFilter;

    @FXML
    private RadioButton radioBtnPredicateQuery;

    @FXML
    private TreeView<String> selectionFIleNameTree;

    @FXML
    private Label informationLabel;

    @FXML
    private Label objectLabel;
    
    @FXML
    private Button openBoxBtn = new Button();
    
    @FXML
    void openBoxBtnPressed(ActionEvent event) {
		Stage textWindow = new Stage();
	    VBox box = new VBox(20);
	    TextArea inputArea = new TextArea();
	    Label commentlabel = new Label("Enter the SPAQRL:");
	    Button run = new Button("Enter");
	    box.getChildren().addAll(commentlabel, inputArea, run);
	    textWindow.setScene(new Scene(box,350,250));
	    textWindow.show();
	    
	    run.setOnAction(e ->{
	    	String code = inputArea.getText();
	    	System.out.println(code);
	    	//xu ly tiep
	    });

    }

    
    public void getTypeOfFile(ActionEvent event) {
    	//
    	
    	String typeOfFile = typeOfFileChooseBox.getValue();
    	System.out.println(typeOfFile);
    }
    @FXML
    void selectItem() {
        TreeItem<String> item = selectionFIleNameTree.getSelectionModel().getSelectedItem();
        String content = "";
        if(item != null && Category.containsKey(item.getValue())) {
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
          objectLabel.setText(item.getValue());
          informationLabel.setText(content);
        }
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
        String [] mainTopic = {
        		"Attraction",
                "Event",
                "Culture",
                "Accomodation",
                "Travel"
        };
        String [][] subTopic = {
        		{"NaturalAttraction", "ManMadeAttraction"},
                {"Event", null},
                {"Culture", null},
                {"Accomodation", null},
                {"Travel", null},
        };
        String [][][] objectTopic = { 
        		{{"Beach", "National Park", "Lake", "Cave"}, {"Bridge", "Skyscraper","Temple","Museum"}},
                {{"Festival", null, null, null}, {null, null, null,null}},
                {{"Culture", null, null, null}, {null, null, null,null}},
                {{"Resort", null, null, null}, {"Hotel", null, null,null}},
                {{"Railway Station", null, null, null}, {"Airport", null, null,null}},

        };
        String [] typeOfFile = {"RDF/XML", "RDFa", "TURTLE"};
        
        //tao tree
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
        
        typeOfFileChooseBox.getItems().addAll(typeOfFile);
        typeOfFileChooseBox.setOnAction(this::getTypeOfFile);
        typeOfFileChooseBox.setValue("TURTLE");
        
        openBoxBtn.setVisible(true);
        
        selectionFIleNameTree.setRoot(rootItem);
        selectionFIleNameTree.setShowRoot(false);

    }


}
