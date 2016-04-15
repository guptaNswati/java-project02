package subsetsum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Reads in a file and adds the prices into a list of the prices of groceries
 * @author swati
 *
 */
public class GroceriesFileReader
{
    private ArrayList<Double> priceOfGroceries;

    // constructor that initializes priceOfGroceries
    GroceriesFileReader()
    {
        priceOfGroceries = new ArrayList<Double>();        
    }

    /**
     * reads the CSV file of groceries 
     * @param filePath [The input file to parse]
     * @return an ArrayList of grocery prices
     */
    public ArrayList<Double> readFile(String filePath)
    {
        Scanner input;

        try 
        {
            input = new Scanner (new File(filePath));

            ArrayList<String> items = new ArrayList<String>();

            while(input.hasNextLine())
            {
                items.add(input.nextLine());
            }

            for(int i = 0; i < items.size(); i++)
            {
                String[] tokens = items.get(i).split(",");

                priceOfGroceries.add(Double.parseDouble(tokens[1]));
            }
            input.close();
        }

        // exception handling
        catch (FileNotFoundException e) 
        {
            System.out.println("File " + filePath + " not found!");
        }
        return priceOfGroceries;    
    }
}
