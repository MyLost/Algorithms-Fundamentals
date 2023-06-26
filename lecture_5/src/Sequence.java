public class Sequence {
    public static void main(String[] args) {

        int[] sequence = {3, 14 ,5 ,12 ,15, 7, 8, 9, 11, 10, 1};

        int[] length = new int[sequence.length];

        for (int i = 0; i < sequence.length ; i++) {
            int current = sequence[i];
            int bestLength =1;

            for (int j = i; j >= 0 ; j--) {
                if(sequence[j] < current && length[j] + 1 > bestLength) {
                    bestLength = length[j] + 1;
                }
            }
            length[i] = bestLength;
        }
    }
}
