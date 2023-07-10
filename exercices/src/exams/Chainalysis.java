package exams;

import java.util.*;

public class Chainalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String[]> analysis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String transactionStr = scanner.nextLine();
            String[] transaction = transactionStr.split(" ");
            analysis.add(transaction);
        }

        int groups = countGroups(analysis);
        System.out.println(groups);
    }

    public static void dfs(String node, Map<String, Set<String>> graph, Set<String> visited) {
        visited.add(node);

        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static int countGroups(List<String[]> transactions) {
        Map<String, Set<String>> graph = new HashMap<>();

        for (String[] transaction : transactions) {
            String sender = transaction[0];
            String receiver = transaction[1];

            if (!graph.containsKey(sender)) {
                graph.put(sender, new HashSet<>());
            }
            if (!graph.containsKey(receiver)) {
                graph.put(receiver, new HashSet<>());
            }

            graph.get(sender).add(receiver);
            graph.get(receiver).add(sender);
        }

        Set<String> visited = new HashSet<>();
        int groups = 0;

        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                groups++;
                dfs(node, graph, visited);
            }
        }
        return groups;
    }
}
