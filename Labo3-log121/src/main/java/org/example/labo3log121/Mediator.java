package org.example.labo3log121;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public abstract class Mediator {
    protected GridPane carteCreditGridPane;
    protected GridPane carteCadeauGridPane;
    protected GridPane paiementLivraisonGridPane;
    protected ComboBox<String> modePaiementComboBox;
    protected CheckBox memeAddresseCheckBox;
    protected TextField adresseLivraisonTextField;
    protected TextField adresseFacturationTextField;

    public Mediator(GridPane carteCreditGridPane, GridPane carteCadeauGridPane, GridPane paiementLivraisonGridPane, ComboBox<String> modePaiementComboBox,
                    TextField adresseLivraisonTextField, TextField adresseFacturationTextField,
                    CheckBox memeAddresseCheckBox) {
        this.carteCreditGridPane = carteCreditGridPane;
        this.carteCadeauGridPane = carteCadeauGridPane;
        this.paiementLivraisonGridPane = paiementLivraisonGridPane;
        this.modePaiementComboBox = modePaiementComboBox;
        this.adresseLivraisonTextField = adresseLivraisonTextField;
        this.adresseFacturationTextField = adresseFacturationTextField;
        this.memeAddresseCheckBox=memeAddresseCheckBox;
    }

    public abstract void registerComponents();
    public abstract void onModePaiementChanged(String selectedMode);
}