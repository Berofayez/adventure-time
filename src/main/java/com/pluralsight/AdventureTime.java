package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AdventureTime {

    static ArrayList<Step> steps = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    static void main() {
        steps = loadAdventure();
        homeScreen();

    }

    public static void homeScreen(){
        System.out.println("Welcome to Adventure Time.");
        System.out.println("--------------------------");
        System.out.println("press (P) to play: ");
        System.out.println("press (Q) to quit: ");

        String choice = scanner.nextLine().toUpperCase();

        if(choice.equals("P")){
            gameScreen(1);
        }



    }


    public static void gameScreen(int id){
        for(int i = 0; i < steps.size(); i++){
            Step step = steps.get(i);
            if(step.getId() == id){
                System.out.println("Story Text: " + step.getStoryText());
                System.out.println();
                System.out.println("1) " + step.getOption1Text());
                System.out.println();
                System.out.println("2) " + step.getOption2Text());

            }

        }

    }

    public static ArrayList<Step> loadAdventure()
    {

        try
        {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            line = bufferedReader.readLine();

            while (line != null){
                //System.out.println(line);

                String [] columns = line.split("\\|");

                int id = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns[2];
                int option1NextId = Integer.parseInt(columns[3]);
                String option2Text = columns[4];
                int option2NextId = Integer.parseInt(columns[5]);


                Step step = new Step(id, storyText, option1Text, option1NextId, option2Text, option2NextId);
                steps.add(step);
                //System.out.println(step.getStoryText());

                line = bufferedReader.readLine();
            }

            fileReader.close();

        }
        catch (Exception e){
            System.out.println("err e");

        }

        return steps;
    }

}
