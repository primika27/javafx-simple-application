package org.example.labo3log121;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;

public class ConcreteMediator extends Mediator{

    public ConcreteMediator(GridPane carteCreditGridPane, GridPane carteCadeauGridPane, GridPane paiementLivraisonGridPane,
                            ComboBox<String> modePaiementComboBox,
                            TextField adresseLivraisonTextField, TextField adresseFacturationTextField, CheckBox memeAdresseCheckBox) {
        super(carteCreditGridPane, carteCadeauGridPane, paiementLivraisonGridPane, modePaiementComboBox, adresseLivraisonTextField,
                adresseFacturationTextField,memeAdresseCheckBox);
    }

    @Override
    public void registerComponents() {
        modePaiementComboBox.setOnAction(e ->
                onModePaiementChanged(modePaiementComboBox.getValue()));

        memeAddresseCheckBox.setOnAction(e -> {
            if (memeAddresseCheckBox.isSelected()) {
                // Désactiver le champ d'adresse de facturation
                adresseFacturationTextField.setDisable(true);
                // Copier le contenu du champ d'adresse de livraison vers le champ d'adresse de facturation
                adresseFacturationTextField.setText(adresseLivraisonTextField.getText());
            } else {
                // Réactiver le champ d'adresse de facturation
                adresseFacturationTextField.setDisable(false);
            }
        });
    }

    @Override
    public void onModePaiementChanged(String selectedMode) {
        switch (selectedMode) {
            case "Carte de crédit":
                carteCreditGridPane.setVisible(true);
                carteCadeauGridPane.setVisible(false);
                paiementLivraisonGridPane.setVisible(false);
                break;
            case "Carte cadeau":
                carteCreditGridPane.setVisible(false);
                carteCadeauGridPane.setVisible(true);
                paiementLivraisonGridPane.setVisible(false);
                break;
            case "Paiement à la livraison":
                carteCreditGridPane.setVisible(false);
                carteCadeauGridPane.setVisible(false);
                paiementLivraisonGridPane.setVisible(true);
                break;
            default:
                carteCreditGridPane.setVisible(false);
                carteCadeauGridPane.setVisible(false);
                paiementLivraisonGridPane.setVisible(false);
                break;
        }
    }

}
