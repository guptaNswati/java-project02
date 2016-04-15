project folder:
guptaNswati-prject02


Brief description of submitted files:

src/MillionSongDataSubset.java
    - One object of class MillionSongDataSubset parses a JSON data set and stores each entry in an array.

src/SongEntry.java
    - One object of class SongEntry stores a simplified version of the genre data set from the Million Song Dataset.

src/TimeConverter.java
    - Converts duration into a string representation.

src/BubbleSort.java
    - Performs a basic sorting algorithm of a generic array of objects.

src/subsetsum/FoothillTunesStore.java
   - An object of type FoothillTunesStore creates an object of type MillionSongDataSubset, which in turn parses a JSON data set with a given file path. 
   - The parsed data set is stored in an array of SongEntry objects. Next, it reads prompts the user for a play list duration. 
   - Uses an object of type SubsetSum to make a play list of SongEntry objects that best match the given duration.
   - Includes main

src/subsetsum/GroceriesFileReader.java
   - Reads in a file and adds the prices into a list of the prices of groceries

src/subsetsum/Itunesstore.java
   - Reads a json file that contains songs. and creates an arraylist of songs of their duration.

src/subsetsum/ShoppingBag.java
   - An object of type ShoppingBag class creates an object of type subset sum to find a best possible grocery shopping list within the given budget.
   - Creates an Object of FoothillTunesStores that creates a list of songs.
   - Includes main

src/subsetsum/SubsetSum.java
   - Given the condition of how much the user's target is, determines a list of grocery items and songs.

lib/json-simple-1.1.1.jar
    - Java toolkit for JSON (JavaScript Object Notation) used to encode or decode JSON text.
    - https://code.google.com/p/json-simple/downloads/list

resources/groceries.txt
   - contains list of grocery items and their price

resources/music_genre_subset.json
   - contains songs in json format


resources/RUN.txt
   - console output of ShoppingBag and FoothillItunesStore

README.txt
   - description of submitted files