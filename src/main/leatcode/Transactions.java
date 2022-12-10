package src.main.leatcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'groupTransactions' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY transactions as parameter.
     */

    public static List<String> groupTransactions(List<String> transactions) {
        // Options
        // 1) Use a map and then convert the map into an array afterwards
        // 2) Use an array from the outset
        // 3) Sort the list, count how many String match and append that number to the array - Fastest!!!
        //java.util.Collections.sort(transactions);
        //String lastString = "";

        // There is a better solution, but I am not confident I will get it off in time
        // I don't love option 2 because there are most things which I am uncertain about
        Map<String, Integer> map = new HashMap<>();
        for (String transaction : transactions) {
            if (map.containsKey(transaction)) {
                map.put(transaction, map.get(transaction) + 1);
            } else {
                map.put(transaction, 1);
            }
        }
        List<String> returnList = new ArrayList<>();
        LinkedHashMap<String, Integer> sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue(),
                                (e1, e2) -> null,
                                () -> new LinkedHashMap<String, Integer>()
                        )
                );
        // The map contains all of the key value pairs
        // Next, convert the map into a list, appending each value to the end of each index
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            returnList.add(entry.getKey() + " " + entry.getValue());
        }

        return returnList;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int transactionsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> transactions = IntStream.range(0, transactionsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.groupTransactions(transactions);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
