package Diplom.JavaFX.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.util.Stack;

public class ParentFrameController {
    @FXML   private TreeView<String> treeViewACS;
    @FXML   private BorderPane bpParent;
    @FXML   private Label lblStatus;
    @FXML   private ToggleButton tbtnShowTree;
    private TreeItem<String> workers = new TreeItem<String>("Персонал");
    private TreeItem<String> departments = new TreeItem<String>("Цеха");
    private TreeItem<String> planning = new TreeItem<String>("План");
    private TreeItem<String> details = new TreeItem<String>("Номенклатура деталей");
    private TreeItem<String> plots = new TreeItem<String>("Графики");
    private TreeItem<String> professions = new TreeItem<String>("Профессии");
    private TreeItem<String> analyze = new TreeItem<String>("Анализ");
    private TreeItem<String> data_form = new TreeItem<String>("Данные");

    TreeItem<String> manage = new TreeItem<String>("Управление");
    TreeItem<String> ACS_MMZ = new TreeItem<String>("Система управления персоналом");
    private  AnchorPane anchor_pane_get;

    public void initialize(){
        tbtnShowTree.setSelected(true);
        try{
            data_form.getChildren().addAll(workers, departments,professions);
            data_form.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/plan.png"), 20, 20, false, true)));
            workers.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/personal.png"), 20, 20, false, true)));
            professions.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/pepega.png"), 20, 20, false, true)));
            professions.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/pepega.png"), 20, 20, false, true)));
            analyze.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/calc.png"), 20, 20, false, true)));

            ACS_MMZ.getChildren().addAll(data_form, analyze);
            ACS_MMZ.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/snail.gif"), 24, 24, false, true)));

            treeViewACS.setRoot(ACS_MMZ);
            treeViewACS.setShowRoot(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        treeViewACS.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                FXMLLoader loader = new FXMLLoader();
                if (newValue == professions) {
                    loader.setLocation(ParentFrameController.class.getResource("/Frames/ProfessionsFrame.fxml"));
                }
                else if(newValue == workers) {
                    loader.setLocation(ParentFrameController.class.getResource("/Frames/WorkersFrame.fxml"));
                }
                else if(newValue == departments) {
                    loader.setLocation(ParentFrameController.class.getResource("/Frames/DepartmentsFrame.fxml"));
                }
                else if(newValue == details) {
                    loader.setLocation(ParentFrameController.class.getResource("/Frames/DetailsFrame.fxml"));
                }
                else if(newValue == analyze) {
                    loader.setLocation(ParentFrameController.class.getResource("/Frames/CalculationFrame.fxml"));
                }
                anchor_pane_get = loader.load();
                bpParent.setCenter(anchor_pane_get);

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });



    }

    public void hideTree(){
        if(tbtnShowTree.isSelected() == true) {
            treeViewACS.setVisible(true);
            AnchorPane anc = (AnchorPane) bpParent.getCenter();
            bpParent.setCenter(null);
            bpParent.setLeft(treeViewACS);
            bpParent.setCenter(anc);
        }
        else {
            treeViewACS.setVisible(false);
            AnchorPane anc = (AnchorPane) bpParent.getCenter();

            bpParent.setCenter(null);
            bpParent.setLeft(null);
            bpParent.setCenter(anc);


        }
    }


}
