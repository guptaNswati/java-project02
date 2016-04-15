package subsetsum;

import java.util.ArrayList;
import java.util.Iterator;

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
    public static ArrayList<SongEntry> findingSubSet(ArrayList<?> list, double budget)
    {
            return creatingSongList((ArrayList<SongEntry>) list, budget);
    }

    public static ArrayList<SongEntry> creatingSongList(ArrayList<SongEntry> list, double budget)
    {
 
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
                int listSize = listOfLists.size();
                int index = 0;
                
            while (index < listSize)                    
            {                    
                ArrayList<SongEntry> currentSet = listOfLists.get(index);
                
                double setSum = 0;
                
                setSum = sumFunction(currentSet) + (double)list.get(i).getDuration();                
                
                if(setSum <= budget)                
                {
                ArrayList<SongEntry> subSet = new ArrayList<SongEntry>();
                
                
                for(int m = 0 ; m < currentSet.size() ; m++)
                {
                    subSet.add(currentSet.get(m));                            
                }                        
                subSet.add(list.get(i));                                                
                listOfLists.add(subSet);
                    
                if(setSum == budget)                    
                {   
                    System.out.println("found perfect match");                        
                    return  subSet;
                }
                // for closest match 
                else if (sumFunction(closestSubList) < setSum)
                {
                    closestSubList = subSet;
                }
                
                memoryOptimization(listOfLists, subSet);
            } 
            index++;                                                            
        }                 
        
     }
    return closestSubList;
               
    }
  
    public static ArrayList<ArrayList<SongEntry>> memoryOptimization(ArrayList<ArrayList<SongEntry>> listOfLists, ArrayList<SongEntry> subSet)
    {
        Iterator<ArrayList<SongEntry>> itr = listOfLists.iterator();
        
        while(itr.hasNext())
        {
            ArrayList<SongEntry> currentSet = itr.next();
           
            if(subSet.subList(0, subSet.size()-1).equals(currentSet))
            {   
                System.out.println("sub list " + subSet.subList(0, subSet.size()-1));
                System.out.println("current set of list " + currentSet);
                System.out.println("removing common subsets");
                itr.remove();
            }      
        }
//        for(int i = 0; i < listOfLists.size(); i++)
//        {
//            if(list.subList(0, list.size()-1).equals(listOfLists.get(i)))
//            {
//                listOfLists.remove(listOfLists.get(i));
//
//            }
//        }
        System.out.println("list is " + listOfLists);
        return listOfLists; 
        
    }
}
        
    

