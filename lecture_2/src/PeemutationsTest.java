import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PeemutationsTest {

    public static String[] elements = {"A", "B", "B"};
    public static String[] perm = new String[3];
    public static boolean[] used = new boolean[3];

    public static void main(String[] args) {

        permute(0);

    }

    private static void permute(int index) {
        if(index >= elements.length) {
//            print();
        } else {
            for (int i = 0; i < elements.length; i++) {
                if(!used[i]) {
                    used[i] = true;
                    perm[index] = elements[i];
                    permute(index + 1);
                    used[i]=false;
                }
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", Arrays.asList(perm)));
    }
}
