package subsetsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import cs1c.MillionSongDataSubset;
import cs1c.SongEntry;
import cs1c.TimeConverter;

public class ItunesStore
{
    public static ArrayList<SongEntry> songList;
    
    
    /**
     * Reads an input file that contains the prices of the different items.
     * Then stores and outputs a list of items we can buy
     * given the condition of how much money you have in your wallet.
     * We're at a cash only store. So, no checks or credit purchases!
     * @param args  Not used.
     */
    public static ArrayList<Double> creatingListOfSongsWithDuration()
    {
        ArrayList<Double> listOfSongs = new ArrayList<Double>();
        
        final String FILEPATH = "resources/music_genre_subset.json";

        // parses the JSON input file
        MillionSongDataSubset msd = new MillionSongDataSubset(FILEPATH);
        
        // retrieves the parsed objects
        SongEntry [] allSongs = msd.getArrayOfSongs();

        songList = new ArrayList<SongEntry>(Arrays.asList(allSongs));
        // displays the number of songs read from the input file
        System.out.println("Number of available songs:");
        System.out.println(songList.size());
        
        for(int i = 0; i < songList.size(); i++)
        {
            // converting duration from secs to minutes
            double currentSongDuration = songList.get(i).getDuration();   
            listOfSongs.add(currentSongDuration);
        }
        return listOfSongs;
    }
}
