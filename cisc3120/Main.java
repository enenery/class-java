package com.enenery.class_game_simulation;
/**
 * Created by Erii on 5/9/2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    static Android mAndroid = new Android();
    static Assassin mAssassin = new Assassin();
    static Beastmaster mBeastmaster = new Beastmaster();
    static Commander mCommander = new Commander();
    static Engineer mEngineer = new Engineer();
    static Healer mHealer = new Healer();
    static Huntress mHuntress = new Huntress();
    static Mariner mMariner = new Mariner();
    static Soldier mSoldier = new Soldier();
    static Swordsman mSwordsman = new Swordsman();

    static Text teamName;


        private String characters[] = {"Android", "Assassin"
                ,"Beastmaster", "Commander", "Engineer",
                "Healer", "Huntress", "Mariner", "Soldier", "Swordsman"};

    Button buttonSet1 = new Button("NEXT");
    static ArrayList<String> charList = new ArrayList<>();
    TextField teamName1 = new TextField("Enter name for this group.");


    @Override
        public void start(Stage primaryStage) {
            ListView<String> listView1 = new ListView<>();
            for (int i = 0; i < 10 ; i++) {
                String item = characters[i];
                listView1.getItems().add(item);
            }


            listView1.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(String item) {
                    BooleanProperty observable = new SimpleBooleanProperty();
                    observable.addListener((obs, wasSelected, isNowSelected) ->{
                        switch (item){
                            case "Android":
                                charList.add("Android");
                                mAndroid.selected = true;
                                break;
                            case "Assassin":
                                charList.add("Assassin");
                                mAssassin.selected = true;
                                break;
                            case "Beastmaster":
                                charList.add("Beastmaster");
                                mBeastmaster.selected = true;
                                break;
                            case "Commander":
                                charList.add("Commander");
                                mCommander.selected = true;
                                break;
                            case "Engineer":
                                charList.add("Engineer");
                                mEngineer.selected = true;
                                break;
                            case "Healer":
                                charList.add("Healer");
                                mHealer.selected = true;
                                break;
                            case "Huntress":
                                charList.add("Huntress");
                                mHuntress.selected = true;
                                break;
                            case "Mariner":
                                charList.add("Mariner");
                                System.out.println("8");
                                mMariner.selected = true;
                                break;
                            case "Soldier":
                                charList.add("Soldier");
                                System.out.println("9");
                                mSoldier.selected = true;
                                break;
                            case "Swordsman":
                                charList.add("Swordsman");
                                System.out.println("10");
                                mSwordsman.selected = true;
                                break;
                        }
                            System.out.println("Check box for "+item+" changed from "+wasSelected+" to "+isNowSelected);});
                    return observable;
                }
            }));


            buttonSet1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    formMembership();
                    displaySummary();
                }
            });


            VBox root = new VBox();
            root.getChildren().addAll(teamName1, listView1, buttonSet1);

            VBox root2 = setCharFeatures(characters);
            VBox root3 = setSummary();

            HBox parent = new HBox();

            parent.getChildren().addAll(root, root2, root3);

            Scene scene = new Scene(parent, 1000, 600);
            primaryStage.setTitle("Team Formation");
            primaryStage.setScene(scene);
            primaryStage.show();

        }


    public static void formMembership(){

        if(mAndroid.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Android"))
                    mAndroid.addAMember(member);
            }
            mAndroid.addBonusAttack();
        }

        if(mAssassin.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Assassin"))
                    mAssassin.addAMember(member);
            }
            mAssassin.addBonusAttack();
        }

        if(mBeastmaster.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Beastmaster"))
                    mBeastmaster.addAMember(member);
            }
            mBeastmaster.addBonusAttack();
        }

        if(mCommander.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Commander"))
                    mCommander.addAMember(member);
            }
            mCommander.addBonusAttack();
        }

        if(mEngineer.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Engineer"))
                    mEngineer.addAMember(member);
            }
            mEngineer.addBonusAttack();
        }

        if(mHealer.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Healer"))
                    mHealer.addAMember(member);
            }
            mHealer.addBonusAttack();
        }

        if(mHuntress.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Huntress"))
                    mHuntress.addAMember(member);
            }
            mHuntress.addBonusAttack();
        }

        if(mMariner.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Mariner"))
                    mMariner.addAMember(member);
            }
            mMariner.addBonusAttack();
        }

        if(mSoldier.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Soldier"))
                    mSoldier.addAMember(member);
            }
            mSoldier.addBonusAttack();
        }

        if(mSwordsman.selected == true) {

            for (String member : charList) {
                if (!member.equalsIgnoreCase("Swordsman"))
                    mSwordsman.addAMember(member);
            }
            mSwordsman.addBonusAttack();
        }

    }

    public static void displaySummary(){
        //HBox root = new HBox();
        String summary = "";

        for(String member: charList)
        {
            switch (member){
                case "Android":
                    summary += "\nAndroid's attack power is " + mAndroid.getAttackPower();
                    break;
                case "Assassin":
                    summary += "\nAssassin's attack power is " + mAssassin.getAttackPower();
                    break;
                case "Beastmaster":
                    summary += "\nBeastmaster's attack power is " + mBeastmaster.getAttackPower();
                    break;
                case "Commander":
                    summary += "\nBeastmaster's attack power is " + mCommander.getAttackPower();
                    break;
                case "Engineer":
                    summary += "\nEngineer's attack power is " + mEngineer.getAttackPower();
                    break;
                case "Healer":
                    summary += "\nHealer's attack power is " + mHealer.getAttackPower();
                    break;
                case "Huntress":
                    summary += "\nHuntress's attack power is " + mHuntress.getAttackPower();
                    break;
                case "Mariner":
                    summary += "\nMariner's attack power is " + mMariner.getAttackPower();
                    break;
                case "Soldier":
                    summary += "\nSoldier's attack power is " + mSoldier.getAttackPower();
                    break;
                case "Swordsman":
                    summary += "\nSwordsman's attack power is " + mSwordsman.getAttackPower();
                    break;
            }

        }
        System.out.println(summary);
        teamName.setText(summary);
        //root.getChildren().addAll(teamName);
        //return root;
    }
    public static VBox setCharFeatures(ArrayList<String> mstring){
            VBox root = new VBox();
            ComboBox mComboBox = new ComboBox();

            for(String character: mstring)
            mComboBox.getItems().add(character);
            root.getChildren().addAll(mComboBox);

            return root;
        }

    public static VBox setCharFeatures(String[] characters){
        VBox root = new VBox();
        ComboBox mComboBox = new ComboBox();

        for(int i = 0; i<characters.length; i++)
            mComboBox.getItems().add(characters[i]);
        root.getChildren().addAll(mComboBox);

        return root;
    }

    public static VBox setSummary(){
        VBox root = new VBox();
        teamName = new Text("Team1 Summary");
        root.getChildren().addAll(teamName);
        return root;
    }

        public static void main(String[] args) {
            launch(args);
        }
    }