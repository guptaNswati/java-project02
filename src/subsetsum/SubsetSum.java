package subsetsum;
import java.util.ArrayList;
import java.util.Iterator;

import cs1c.SongEntry;

/**
 * Given the condition of how much the user's target is, determines a list of grocery items and songs.
 * @author swati
 *
 */
public class SubsetSum
{
    /**
     * calculates the sum of elements of given arraylist
     * @param list [a generic arraylist]
     * @return sum of elements of list
     */
    public static double sumFunction(ArrayList<?> list)
    {
        double sum = 0;     

        if (list.isEmpty())
        {
            return 0;
        }

        // check if list contains Objects of type double
        else if (list.get(0) instanceof Double)
        {                        
            for(int i = 0; i < list.size(); i++) 
            {  
                double item = (double) list.get(i);
                sum = sum + item ;                                    
            }
            return sum; 
        }

        // check if list contains SongEntry Objects
        else if (list.get(0) instanceof SongEntry)
        {
            ArrayList<SongEntry> songList = (ArrayList<SongEntry>) list;

            for(int i = 0; i < list.size(); i++)
            {         
                double duration = songList.get(i).getDuration();
                sum = sum + duration;
            }
            return sum;
        }
        return sum;
    }

    /**
     * 
     * @param list [ArrayList containing Objects of Type Double]
     * @param budget [users target amount in double]
     * @return list of items within budget
     */
    public static ArrayList<Double> creatingGroceryList(ArrayList<Double> list, double budget)
    {
        // collection of subsets
        ArrayList<ArrayList<Double>> listOfLists = new ArrayList<ArrayList<Double>>();        

        // an empty list
        ArrayList<Double> subList = new ArrayList<Double>();
        listOfLists.add(subList);

        // list for closest match to the budget
        ArrayList<Double> closestSubList = new ArrayList<Double>();

        if (budget > sumFunction(list))
        {
            return list;                      
        }
        else
            for (int i = 0; i < list.size(); i++)
            {                                                  
                int listSize = listOfLists.size();
                int index = 0;                 

                while (index < listSize)                    
                {                    
                    ArrayList<Double> currentSet = listOfLists.get(index);

                    double setSum = 0;

                    setSum = sumFunction(currentSet) + (double)list.get(i);

                    if(setSum <= budget)                
                    {
                        ArrayList<Double> subSet = new ArrayList<Double>();

                        for(int m = 0 ; m < currentSet.size() ; m++)
                        {
                            subSet.add(currentSet.get(m));                            
                        }                        
                        subSet.add(list.get(i));                                                
                        listOfLists.add(subSet);

                        if(setSum == budget)                    
                        {                            
                            return  subSet;
                        }
                        // for closest match 
                        else if (sumFunction(closestSubList) < setSum)
                        {
                            closestSubList = subSet;
                        }
                    }  // ending of if(setSum <= budget) block

                    index++;                     

                } // ending while block                              

            } // ending outer for loop                      

        return closestSubList;       
    }

    /**
     * creates a list of songs within target duration and for saving memory throws away unnecessary subsets
     * @param list[ArrayList containing Objects of Type SongEntry]
     * @param budget [users target duration in double]
     * @return list of song within duration
     */
    public static ArrayList<SongEntry> creatingSongList(ArrayList<SongEntry> list, double budget)
    { 
        // collection of subsets
        ArrayList<ArrayList<SongEntry>> listOfLists = new ArrayList<ArrayList<SongEntry>>();        

        // an empty list
        ArrayList<SongEntry> subList = new ArrayList<SongEntry>();
        listOfLists.add(subList);

        // list for closest match to the budget
        ArrayList<SongEntry> closestSubList = new ArrayList<SongEntry>();

        if (budget > sumFunction(list))
        {
            return list;                      
        }

        else
            for (int i = 0; i < list.size(); i++)
            {                                                  
                Iterator<ArrayList<SongEntry>> songsIterator = listOfLists.iterator();

                while (songsIterator.hasNext())                    
                {                    
                    ArrayList<SongEntry> currentSet = songsIterator.next();

                    double setSum = sumFunction(currentSet) + (double)list.get(i).getDuration();

                    if (setSum <= budget)                
                    {
                        currentSet.add(list.get(i));

                        if (setSum == budget)                    
                        {                      
                            return  currentSet;
                        }
                        
                        else if (sumFunction(closestSubList) < setSum)
                        {
                            closestSubList = currentSet;
                        }
                        
                    } // ending of if(setSum <= budget) block
               
                } // ending while block                 

            } // ending outer for loop         
        return closestSubList;              
    }

    /**
     * check whether the list contains Objects of SongEntry or Double and creates a list accordingly
     * @param list [generic ArrayList]
     * @param budget [users's target]
     * @return a generic list of items within target
     */
    public static ArrayList<?> findSubset(ArrayList<?> list, double budget)
    {
        if (list.get(0) instanceof Double)
        {
            return creatingGroceryList((ArrayList<Double>) list, budget);           
        }
        else
            return creatingSongList((ArrayList<SongEntry>) list, budget);
    }
}
