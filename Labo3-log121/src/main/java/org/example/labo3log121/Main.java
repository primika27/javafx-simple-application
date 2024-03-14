package org.example.labo3log121;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane mainGridPane = new GridPane();
        mainGridPane.setAlignment(Pos.TOP_LEFT);
        mainGridPane.setHgap(10);
        mainGridPane.setVgap(10);
        mainGridPane.setPadding(new Insets(20));

        // Titre
        Label title = new Label("Methode de Paiement");
        title.setStyle("-fx-font-size: 20; -fx-padding: 10 20;"); // Styling the title label
        mainGridPane.add(title, 0, 0, 2, 1); // colspan: 2

        // ComboBox pour le mode de paiement
        ComboBox<String> modePaiementComboBox = new ComboBox<>();
        modePaiementComboBox.getItems().addAll("Carte de crédit", "Carte cadeau", "Paiement à la livraison");
        modePaiementComboBox.setValue("Carte de crédit");
        mainGridPane.add(new Label("Mode de paiement: "), 0, 1);
        mainGridPane.add(modePaiementComboBox, 2, 1);

        // Créer les GridPane pour chaque mode de paiement
        GridPane carteCreditGridPane = createCarteCreditGridPane();
        GridPane carteCadeauGridPane = createCarteCadeauGridPane();
        GridPane paiementLivraisonGridPane = createPaiementLivraisonGridPane();

        // Ajouter les GridPane à mainGridPane
        mainGridPane.add(carteCreditGridPane, 0, 2);
        mainGridPane.add(carteCadeauGridPane, 0, 2);
        mainGridPane.add(paiementLivraisonGridPane, 0, 2);

        mainGridPane.add(new Label("Adresse de livraison:"), 0, 3);
        mainGridPane.add(adresseLivraisonTextField, 2, 3);
        mainGridPane.add(new Label("Adresse de facturation:"), 0, 4);
        mainGridPane.add(adresseFacturationTextField, 2, 4);

        // Ajouter l'option de livraison
        ChoiceBox<String> optionLivraisonChoiceBox = new ChoiceBox<>();
        optionLivraisonChoiceBox.getItems().addAll("Livraison en main propre", "Se retrouver à l’extérieur", "Laisser à la porte");
        mainGridPane.add(new Label("Option de livraison:"), 0, 5);
        mainGridPane.add(optionLivraisonChoiceBox, 2, 5);

        // Ajouter le checkbox pour utiliser la même adresse pour la livraison et la facturation
        CheckBox memeAdresseCheckBox = new CheckBox("Utiliser la même adresse pour la livraison et la facturation");
        mainGridPane.add(memeAdresseCheckBox, 2, 6);

        Mediator mediator = new ConcreteMediator(carteCreditGridPane, carteCadeauGridPane,
                paiementLivraisonGridPane, modePaiementComboBox,
                adresseLivraisonTextField, adresseFacturationTextField,memeAdresseCheckBox);
        mediator.registerComponents();
        // Configuration de la scène et affichage de la fenêtre
        Scene scene = new Scene(mainGridPane, 500, 400);
        stage.setTitle("Paiement de la commande");
        stage.setScene(scene);
        stage.show();
    }
    TextField adresseLivraisonTextField = new TextField();
    TextField adresseFacturationTextField = new TextField();

    private GridPane createCarteCreditGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        gridPane.add(new Label("Numéro de carte de crédit:"), 0, 0);
        gridPane.add(new TextField(), 2, 0);
        gridPane.add(new Label("Date d'expiration de la carte:"), 0, 1);
        gridPane.add(new TextField(), 2, 1);
        gridPane.add(new Label("Code de sécurité de la carte:"), 0, 2);
        gridPane.add(new TextField(), 2, 2);


        gridPane.setVisible(true); // Initiallement invisible
        return gridPane;
    }

    private GridPane createCarteCadeauGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        gridPane.add(new Label("Numéro de carte cadeau:"), 0, 0);
        gridPane.add(new TextField(), 1, 0);

        gridPane.setVisible(false); // Initiallement invisible
        return gridPane;
    }

    private GridPane createPaiementLivraisonGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));


        gridPane.setVisible(true); // Initiallement invisible
        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}