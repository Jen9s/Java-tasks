import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr =new FileReader("C:\\Users\\user\\IdeaProjects\\Lad2.2\\input.txt");
        Scanner sc = new Scanner(fr);
        int n;
        int m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n][m];
        TreeMap<Integer,Integer> numbers = new TreeMap<>();
        for(var i : matrix){
            for(int j = 0; j < m;j++){
                i[j] =sc.nextInt();
            }
        }


        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (!numbers.containsKey(anInt)) {
                    numbers.put(anInt, 0);
                } else {
                    int tmp = (int) numbers.get(anInt);
                    numbers.put(anInt, tmp + 1);
                }
            }
        }
        if(!numbers.containsValue(0)){
            System.out.println("Didn't have!");
        }
        else {
            System.out.println(numbers);
            Set<Integer> keys = numbers.keySet();
            for(var i : keys){
                if(numbers.get(i) == 0){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}