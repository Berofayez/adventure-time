package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AdventureTime {
    static void main() {
        loadAdventure();

    }

    public static void loadAdventure()
    {
        try
        {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            fileReader.close();

        }
        catch (Exception e){

        }
    }
}
