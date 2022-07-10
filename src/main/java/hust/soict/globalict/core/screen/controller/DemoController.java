package hust.soict.globalict.core.screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class DemoController {
	
    @FXML
    private TreeView<String> selectionFIleNameTree = new TreeView<String>();

    @FXML
    private Label informationLabel;
    
    @FXML
    private Label objectLabel;  

    @FXML
    void selectItem() {
    	TreeItem<String> item = selectionFIleNameTree.getSelectionModel().getSelectedItem();
    	//doc file in ra man hinh
    	String content = ""; 
    	
    	if(item != null) {
    		System.out.println(item.getValue());
    		objectLabel.setText(item.getValue());
    		informationLabel.setText(content);
    	}
    }    
    
    public DemoController() {
		super();
	}
    
    public void initialize() {    	

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
		String [][][] objectTopic = { {{"Beach", "NationPark", "Lake", "Cave"}, {"Bridge", "Skycraper","Temple","Museum"}},
									  {{"Festival", null, null, null}, {null, null, null,null}},
									  {{"Culture", null, null, null}, {null, null, null,null}},
									  {{"Resort", null, null, null}, {"Hotels", null, null,null}},
									  {{"RailwayStation", null, null, null}, {"Airport", null, null,null}},
				
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
