package com.kodilla.stream.Project_7_3.person;
import java.util.*;

public final class People {                              // [4]

    public static List<String> getList() {                // [5]
        final List<String> theList = new ArrayList<>();    // [6]

        theList.add("John Smith");                         // [7]
        theList.add("Dorothy Newman");                     // [8]
        theList.add("John Wolkowitz");                     // [9]
        theList.add("Lucy Riley");                         // [10]
        theList.add("Owen Rogers");                        // [11]
        theList.add("Matilda Davies");                     // [12]
        theList.add("Declan Booth");                       // [13]
        theList.add("Corinne Foster");                     // [14]
        theList.add("Khloe fry");                          // [15]
        theList.add("Martin Valenzuela");                  // [16]

        return new ArrayList<>(theList);                   // [17]
    }
}
