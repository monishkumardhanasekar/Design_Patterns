package primeService.server;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class AllPrimeQueries {
    private Map<String, int[]> queries = new LinkedHashMap<>();

    private Map<String, Integer> currentQuery = new LinkedHashMap<>();

    public synchronized void addQuery(String clientName, int value) {
        try{
            if (queries.containsKey(clientName)) {
                int[] existingArray = queries.get(clientName);
                int[] newArray = Arrays.copyOf(existingArray, existingArray.length + 1);
                System.arraycopy(new int[]{value}, 0, newArray, existingArray.length, 1);
                queries.put(clientName, newArray);
                currentQuery.clear();
                currentQuery.put(clientName,value);
            } 
            else {
                queries.put(clientName, new int[]{value});
                currentQuery.clear();
                currentQuery.put(clientName,value);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public synchronized String getClientNames() {
        try{
            StringBuilder result = new StringBuilder();
            if(currentQuery!=null){
                Map.Entry<String, Integer> query = currentQuery.entrySet().stream().findFirst().orElse(null);
                result.append(query.getKey()).append(" ").append(query.getValue());
                return result.toString().trim();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public synchronized String getAllQueries() {
        
        StringBuilder result = new StringBuilder();
        try{
            for (Map.Entry<String, int[]> entry : queries.entrySet()) {
                result.append(entry.getKey()).append(" ");
                for(int value: entry.getValue()){
                    result.append(value).append(" ");
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result.toString().trim();
    }
}
