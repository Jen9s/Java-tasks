import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static java.lang.StrictMath.abs;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr =new FileReader("C:\\Users\\user\\IdeaProjects\\Lab2.1\\input.txt");
        Scanner sc = new Scanner(fr);
        int n;
        int m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(var i : matrix){
            for(int j = 0; j < m;j++){
                i[j] =sc.nextInt();
            }
        }

        int answer = -1;
        int sum_tmp = 0;
        int sum = 0;
        int counter = 0;

        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[i][j] % 2 == 0){
                    sum_tmp = 0;
                    break;
                }
                counter++;
                sum_tmp += abs(matrix[i][j]);
            }
            if(counter == matrix[0].length){
                if(sum < sum_tmp){
                    answer = i;
                    sum = sum_tmp;
                    sum_tmp = 0;
                }
            }
            counter = 0;
        }
        System.out.println(answer);
    }
}