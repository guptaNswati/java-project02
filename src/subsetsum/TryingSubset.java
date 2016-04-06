package subsetsum;

import java.util.ArrayList;

import cs1c.SongEntry;

public class TryingSubset
{   
    public static double sumFunction(ArrayList<?> list)
    {
      double sum = 0;     
      
      if (list.isEmpty())
      {
            return sum;
      }
      
      else if (list.get(0) instanceof Double)
      {                        
          for(int i = 0; i < list.size(); i++) 
          {  
              double item = (double) list.get(i);
              sum = sum + item ;                                    
          }
          return sum; 
      }
      
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
      else
      return 0;
    }
    
    // divide in two methods and check condition of instance of and call them accordingly
    public static ArrayList<?> findingSubSet(ArrayList<?> list, double budget)
    {

        ArrayList<ArrayList<?>> listOfLists = new ArrayList<ArrayList<?>>();        
        
        // an empty list
        ArrayList<?> subList = new ArrayList<Object>();
        listOfLists.add(subList);
        
        // list for closest match to the budget
        ArrayList<?> closestSubList = new ArrayList<Object>();
        
        ArrayList<SongEntry> songList;
       
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
                ArrayList<?> currentSet = listOfLists.get(j);
                
                double setSum = 0;
                
                if (list.get(i) instanceof Double)
                {                
                     setSum = sumFunction(currentSet) + (double)list.get(i);
                     
                     if(setSum <= budget)                
                     {
                     ArrayList<Double> subSet = new ArrayList<Double>();
                                          
                     for(int m = 0 ; m < currentSet.size() ; m++)
                     {
                         subSet.add((Double) currentSet.get(m));                            
                     }                        
                     subSet.add((Double) list.get(i));                                                
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
                
                else if (list.get(i) instanceof SongEntry)
                {
                    songList = (ArrayList<SongEntry>) list;
                    setSum = sumFunction(currentSet) + (double)songList.get(i).getDuration();                
                    
                    if(setSum <= budget)                
                    {
                    ArrayList<SongEntry> subSet = new ArrayList<SongEntry>();
                    
                    
                    for(int m = 0 ; m < currentSet.size() ; m++)
                    {
                        subSet.add((SongEntry) currentSet.get(m));                            
                    }                        
                    subSet.add((SongEntry) list.get(i));                                                
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
         
        } 
        return closestSubList;
    }
}
        
    

