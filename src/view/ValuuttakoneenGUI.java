package view;

import java.awt.Button;
import controller.ValuuttakoneenOhjain;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Valuuttakone;
import java.io.IOException;

import controller.IValuuttakoneenOhjain;
import controller.ValuuttakoneenOhjain;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ValuuttakoneenGUI extends Application implements IValuuttakoneenGUI {

	private Stage primaryStage;
	Valuuttakone valuuttakone = new Valuuttakone();
	ValuuttakoneenOhjain ohjain;
	ListView<String> valuuttalistaVasen;
	ListView<String> valuuttalistaOikea;
	TextField maara;
	TextField tulos;
	public  void init(){
		ohjain = new ValuuttakoneenOhjain( this);
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws IOException {

		primaryStage.setTitle("Valuuttakone");

		Button laskeBtn = new Button("Laske");

		GridPane root = new GridPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setVgap(10);
		root.setHgap(10);
		//root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 800, 300);

		valuuttalistaVasen = new ListView<String>();
		valuuttalistaVasen.setPrefSize(250, 250);

		ObservableList<String> valuuttaObsVas = FXCollections.observableArrayList();
		valuuttaObsVas.addAll(ohjain.getValuutat());
		valuuttalistaVasen.setItems(valuuttaObsVas);
		valuuttalistaVasen.getSelectionModel().select(0);

		VBox valuuttaDivVasen = new VBox();
		valuuttaDivVasen.getChildren().addAll(new Label("Mistä muutetaan:"), valuuttalistaVasen);
		GridPane.setConstraints(valuuttaDivVasen, 0, 0);
		root.getChildren().add(valuuttaDivVasen);

		valuuttalistaOikea = new ListView<String>();
		valuuttalistaOikea.setPrefSize(250, 250);

		ObservableList<String> valuuttaObsOik = FXCollections.observableArrayList();
		valuuttaObsOik.addAll(ohjain.getValuutat());
		valuuttalistaOikea.setItems(valuuttaObsOik);
		valuuttalistaOikea.getSelectionModel().select(0);

		VBox valuuttaDivOikea = new VBox();
		valuuttaDivOikea.getChildren().addAll(new Label("Mihin muutetaan:"), valuuttalistaOikea);
		GridPane.setConstraints(valuuttaDivOikea, 1, 0);
		root.getChildren().add(valuuttaDivOikea);

		maara = new TextField();
		Button muunna = new Button("Muunna");
		muunna.setPrefWidth(250);
		tulos = new TextField();

		VBox tekstit = new VBox();
		tekstit.getChildren().addAll(new Label("Määrä:"), maara, muunna, new Label("Tulos:"), tulos);
		GridPane.setConstraints(tekstit, 2, 0);
		root.getChildren().add(tekstit);

		muunna.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ohjain.muunnos();
			}
		});

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public int getLahtoIndeksi() {return 0;}
	public int getKOhdeIndeksi() {return 0;}
	public double getMaara() { return 0.0;}
	public void setTulos(double maara) {}
	@Override
	public int getMistäIndeksi() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMihinIndeksi() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getMäärä() {
		// TODO Auto-generated method stub
		return 0;
	}

}
