import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    public static void main(String[] args) {

        List<Edge> graph_list = new ArrayList<>();

        graph_list.add(new Edge(1, 2));
        graph_list.add(new Edge(1, 3));
        graph_list.add(new Edge(1, 4));
        graph_list.add(new Edge(1, 5));
        graph_list.add(new Edge(1, 6));


        int nodes = 10;
        int [][] graph_matrix = new int [nodes+1][nodes+1];

        graph_matrix[3][6] = 1;


        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).addAll(Arrays.asList(9, 8, 5));
        graph.get(9).add(1);
        graph.get(8).add(1);
        graph.get(5).add(1);
        graph.get(2).add(10);
        graph.get(3).add(1);

        for (int child : graph.get(9)) {
            System.out.println(child);
        }
    }

    private static class Edge {
        public int source;
        public int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
}
