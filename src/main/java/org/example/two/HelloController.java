package org.example.two;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloController {



    private String unit = ConversionService.CELSIUS;
    private String unitTo = ConversionService.FAHRENHEIT;
    private String celsius;
    private String fahrenheit;
    private String kelvin;
    private String toCelsius;
    private String toFahrenheit;
    private String toKelvin;
    private double value;

    private double xOffset = 0;
    private double yOffset = 0;




    public  ConversionService conversionService = new ConversionService();

    @FXML
    private Button message_exit;

    @FXML
    private Pane message_pane;

    @FXML
    private CheckBox activate_boobs;

    @FXML
    private Text boobs;


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane mainPane;


    @FXML
    private RadioButton buttonFromKelvin;

    @FXML
    private RadioButton buttonFromCelsius;

    @FXML
    private RadioButton buttonFromFahrenheit;

    @FXML
    private RadioButton buttonToCelsius;

    @FXML
    private RadioButton buttonToFahrenheit;

    @FXML
    private RadioButton buttonToKelvin;

    @FXML
    private Button convert_button;

    @FXML
    private TextField enter_temp;

    @FXML
    private ToggleGroup initial_unit;

    @FXML
    private AnchorPane logoPane;

    @FXML
    private ToggleGroup target_unit;

    @FXML
    private Text text_result;

    @FXML
    private Text text_unitFrom;

    @FXML
    private Text text_unitTo;

    @FXML
    private Text text_value;

    @FXML
    private Button exit;

    public void initialize() {
        anchorPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        anchorPane.setOnMouseDragged(event -> {
            anchorPane.getScene().getWindow().setX(event.getScreenX() - xOffset);
            anchorPane.getScene().getWindow().setY(event.getScreenY() - yOffset);
        });

        text_unitFrom.setText("C'");

        enter_temp.textProperty().addListener((observable, oldValue, newValue) -> {
            text_value.setText("");
            text_result.setText("");

        });

        initial_unit.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            text_result.setText("");
        } );

        target_unit.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            text_result.setText("");
        });

        text_unitFrom.setText("C°");
        text_unitFrom.setVisible(true);
        text_unitTo.setText("F°");
        text_unitTo.setVisible(true);


    }


    @FXML
    void close_message(MouseEvent event) {
        message_pane.setVisible(false);

    }



    @FXML
    void getValue(ActionEvent event) {

    }


    @FXML
    public void getUnit(ActionEvent event) {
        if (buttonFromCelsius.isSelected()) {
            unit = ConversionService.CELSIUS;
            text_unitFrom.setText("C°");
            text_unitFrom.setVisible(true);
        } else if(buttonFromFahrenheit.isSelected()){
            unit = ConversionService.FAHRENHEIT;
            text_unitFrom.setText("F°");
            text_unitFrom.setVisible(true);
        } else if(buttonFromKelvin.isSelected()){
            unit = ConversionService.KELVIN;
            text_unitFrom.setText("K°");
            text_unitFrom.setVisible(true);
        }


    }

    @FXML
    void getUnitTo(ActionEvent event) {
        if (buttonToCelsius.isSelected()){
            unitTo = ConversionService.CELSIUS;
            text_unitTo.setText("C°");
            text_unitTo.setVisible(true);
        } else if (buttonToFahrenheit.isSelected()){
            unitTo = ConversionService.FAHRENHEIT;
            text_unitTo.setText("F°");
            text_unitTo.setVisible(true);
        } else if (buttonToKelvin.isSelected()){
            unitTo = ConversionService.KELVIN;
            text_unitTo.setText("K°");
            text_unitTo.setVisible(true);
        }

    }

    @FXML
    void make_boobs_appear(ActionEvent event) {
        if (activate_boobs.isSelected()) {
            boobs.setVisible(true);
            message_pane.setVisible(true);
        } else {
            boobs.setVisible(false);
            message_pane.setVisible(false);
        }


    }

    @FXML
    void converting(ActionEvent event) {
        double result = conversionService.getResult(unit, Double.parseDouble(enter_temp.getText()), unitTo);


        text_value.setVisible(true);
        value = Double.parseDouble(enter_temp.getText());
        text_value.setText(String.valueOf(value));
        text_result.setText(String.format("%.2f", result));
        text_result.setVisible(true);



    }

    Stage stage;
    @FXML
    public void toExit(MouseEvent event) {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("alerts.css").toExternalForm());
        dialogPane.getStyleClass().add("alert");
        alert.setTitle("EXIT");
        alert.setHeaderText("I am so sorry you're finally leaving.");
        alert.setContentText("Do you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();
        }

    }
    }






