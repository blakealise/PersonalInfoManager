package com.example.personalinfomanager;

// Starter template to help you begin:

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class PersonalInfoManager extends Application {

    // Instance variables for your UI components
    private TextField nameField;
    private TextField emailField;
    private TextField phoneField;
    private TextField display;
    private List<String> contacts = new ArrayList<>();
    GridPane grid = new GridPane();
    String combined = "";
    VBox box = new VBox();
    HBox hBox = new HBox(64);
    TextField name1 = new TextField();

    @Override
    public void start(Stage primaryStage) {
        // Your implementation here
        primaryStage.setTitle("JavaFX Personal Info Manager");

        Scene scene = new Scene(createContent(), 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Region createContent() {
        // Build your UI here




        display = new TextField("personal info manager");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);

        hBox.getChildren().addAll(addContact(),clearContact(), printContact());
        box.getChildren().addAll(display);

        grid.setHgap(3);
        grid.setVgap(2);

        String[][] texts = {
                {"name:", "enter name"},
                {"email:", "enter email"},
                {"phone:", "enter phone"},
        };

        for(int i = 0; i< texts.length; i++){
            for(int j = 0; j < texts.length; j++){
                if(j == 0){
                    Label help = new Label(texts[i][0]);
                    grid.add( help , i, j );

                }
                if(j == 1){
                    TextField imCooked = new TextField();
                    imCooked.setPromptText(texts[i][j]);

                    grid.add( imCooked , i, j );
                }

            }
        }
        box.getChildren().addAll(grid);
        box.getChildren().addAll(hBox);
        return box;
    }

    private Button createButton(String text) {
        // Handle adding a contact
        Button contactButton = new Button(text);
        contactButton.setMinSize(80, 60);
        contactButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        if (text.matches("Add Contact")) {
            contactButton.setStyle("-fx-background-color: #f0a1cd; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 18px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-background-radius: 8px; " +
                    "-fx-border-radius: 8px;");
        }
        contactButton.setOnMouseEntered(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle + "-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;");
        });

        contactButton.setOnMouseExited(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle.replaceAll("-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;", ""));
        });

        // Add click handler
        contactButton.setOnAction(e -> System.out.println("I was clicked!"));

        // what am I adding button to?
        return contactButton;
    }


    private Button addContact() {
        // Handle adding a contact
        String text = "Add Contact";
        Button contactButton = new Button(text);
        contactButton.setMinSize(80, 60);
        contactButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        if (text.matches("Add Contact")) {
            contactButton.setStyle("-fx-background-color: #f0a1cd; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 18px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-background-radius: 8px; " +
                    "-fx-border-radius: 8px;");
        }
        contactButton.setOnMouseEntered(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle + "-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;");
        });

        contactButton.setOnMouseExited(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle.replaceAll("-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;", ""));
        });

        // Add click handler
        contactButton.setOnAction(e -> Create());

        // what am I adding button to?
        return contactButton;
    }
    private Button clearContact() {
        // Handle adding a contact
        String text = "Clear Contact";
        Button contactButton = new Button(text);
        contactButton.setMinSize(80, 60);
        contactButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        if (text.matches("Clear Contact")) {
            contactButton.setStyle("-fx-background-color: #f0a1cd; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 18px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-background-radius: 8px; " +
                    "-fx-border-radius: 8px;");
        }
        contactButton.setOnMouseEntered(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle + "-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;");
        });

        contactButton.setOnMouseExited(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle.replaceAll("-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;", ""));
        });

        // Add click handler

        contactButton.setOnAction(e -> Clear());

        // what am I adding button to?
        return contactButton;
    }

    public void Create(){
        String name;
        String phone;
        String email;


        TextField foundIt = (TextField) (grid.getChildren().get(1));
        name = foundIt.getText();
       // System.out.println("Done erasing stuff");

        TextField boo = (TextField) (grid.getChildren().get(3));
        phone = boo.getText();

        TextField hello = (TextField) (grid.getChildren().get(5));
        email = hello.getText();


        System.out.println(isValidPhone(phone));
        if(phone.contains("@") && isValidPhone(email)==true){
            combined += name + ", "+ phone + ", " + email;
        }



        System.out.println(combined);
    }

    public boolean isValidPhone(String phone){
        String[] arr = {"0","1","2","3","4","5","6","7","8","9", "-"};
        for(int i = 0; i < phone.length(); i++){
            boolean foundYa = false;
            for(int j = 0; j < arr.length; j++){
                System.out.println(phone.substring(i,i+1));
                System.out.println(arr[j]);
                if(phone.substring(i,i+1).equals(arr[j])){
                    foundYa = true;
                }
            }
            if(foundYa == false){
                return false;
            }
        }
        //jkjkjkjjkkjkkkjr
        return true;
    }

    public void Clear(){

        TextField boo = (TextField) (grid.getChildren().get(1));
        boo.setText("");
        TextField foundIt = (TextField) (grid.getChildren().get(3));
        foundIt.setText("");
    //    System.out.println("Done erasing stuff");

        TextField hello = (TextField) (grid.getChildren().get(5));
        hello.setText("");
    }

    public void Print(){
        ArrayList<String> contact = new ArrayList<>();
        contact.add(combined);
        combined = "";
        TextField printed = new TextField(contact.getLast());
        box.getChildren().addAll(printed);

    }
    private Button printContact() {
        // Handle adding a contact
        String text = "Print Contact";
        Button contactButton = new Button(text);
        contactButton.setMinSize(80, 60);
        contactButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        if (text.matches("Print Contact")) {
            contactButton.setStyle("-fx-background-color: #f0a1cd; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size: 18px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-background-radius: 8px; " +
                    "-fx-border-radius: 8px;");
        }
        contactButton.setOnMouseEntered(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle + "-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;");
        });

        contactButton.setOnMouseExited(e -> {
            String currentStyle = contactButton.getStyle();
            contactButton.setStyle(currentStyle.replaceAll("-fx-opacity: 0.8; -fx-scale-x: 1.05; -fx-scale-y: 1.05;", ""));
        });

        // Add click handler
        contactButton.setOnAction(e -> Print());


        return contactButton;
    }


    private void handleButtonClick(String buttonText) {
        switch (buttonText) {
            case "":

                break;
            case "=":
                //;
                break;

                //setOperator(buttonText);

            default:
                if (buttonText.matches("[0-9.]")) {
                //    appendNumber(buttonText);
                }
        }
    }

    private void clearFields() {
        // Clear all text fields
    }

    private void displayContacts() {
        // Show all contacts
    }
}

