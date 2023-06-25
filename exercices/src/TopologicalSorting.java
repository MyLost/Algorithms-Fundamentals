import java.util.*;

public class TopologicalSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static List<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while(!graph.isEmpty()) {
            String current = graph.keySet()
                    .stream().filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if(current == null) {
                    break;
            }

            for (String child : graph.get(current)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(current);
            graph.remove(current);
        }


        if(!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {

        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);
                for (String child : node.getValue()) {
                    dependenciesCount.putIfAbsent(child, 0);
                    dependenciesCount.put(child, dependenciesCount.get(child) + 1);
                }
        }

        return dependenciesCount;
    }
}
