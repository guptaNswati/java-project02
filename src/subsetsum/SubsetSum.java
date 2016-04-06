package subsetsum;

import java.util.ArrayList;
import java.util.Iterator;

public class SubsetSum
{
    public static ArrayList<ArrayList<Double>> listOfList = new ArrayList<ArrayList<Double>>();
    
    public static double sumFunction(ArrayList<Double> list)
    {
      if (list.isEmpty())
            return 0;
      
          double sum = 0;           

          for(int i = 0; i < list.size(); i++) 
          {                                
              sum = sum + list.get(i);                                      
          }
          return sum;          
    }
        
    public static ArrayList<Double> findSubset(ArrayList<Double> list, double budget)
    {   // collection of all possible lists                 
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

        for (int i = 0; i < list.size(); i++)
        {                                                  
            int k = listOfLists.size();
            int j = 0;                 

            while (j < k)                    
            {                    
                ArrayList<Double> currentSet = listOfLists.get(j);
                
                double setSum = sumFunction(currentSet) + list.get(i);                                
                
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
                } 
                j++;                                                            
            }                 
            
         }
        listOfList = listOfLists;
        return closestSubList;                 
        }
    
    public static ArrayList<ArrayList<Double>> memoryOptimization(ArrayList<ArrayList<Double>> listOfLists, ArrayList<Double> list)
    {
        for(int i = 0; i < listOfLists.size(); i++)
        {
            if(list.subList(0, list.size()-1).equals(listOfLists.get(i)))
            {
                listOfLists.remove(listOfLists.get(i));
//                break;
            }
        }
        return listOfLists; 
        
    }
}
