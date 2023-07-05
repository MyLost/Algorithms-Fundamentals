package exams;

import java.util.*;

public class UnreachableOutposts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt() +1;

        int M = scanner.nextInt() + 1;

        // Create adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.get(from).add(to);
        }

        int startNode = scanner.nextInt();

        List<Integer> unreachableOutposts = findUnreachableOutposts(graph, startNode);
        System.out.println("Unreachable outposts: " + unreachableOutposts);
    }

    public static List<Integer> findUnreachableOutposts(List<List<Integer>> graph, int startNode) {
        Set<Integer> visited = new HashSet<>();
        visitNodes(graph, startNode, visited);

        List<Integer> unreachableOutposts = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited.contains(i)) {
                unreachableOutposts.add(i);
            }
        }

        return unreachableOutposts;
    }

    public static void visitNodes(List<List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                visitNodes(graph, neighbor, visited);
            }
        }
    }
}
