import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr =new FileReader("C:\\Users\\user\\IdeaProjects\\Lab2.3\\out\\input.txt");
        Scanner sc = new Scanner(fr);
        int n;
        int m;
        int answer = 2147483647;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n + 2][m + 2];
        for(int i = 1;i < n + 1;i++){
            for(int j = 1;j < m + 1;j++){
                matrix[i][j] =sc.nextInt();
            }
        }

        for(int j = 0;j < matrix[0].length;j++){
            matrix[0][j] = -2147483647;
            matrix[matrix.length - 1][j] = -2147483647;
        }

        for(int j = 0;j < matrix.length;j++){
            matrix[j][0] = -2147483647;
            matrix[j][matrix[j].length - 1] = -2147483647;
        }

        for(int i = 1;i < n + 1;i++){
            for(int j = 1;j < m + 1;j++){
                if(matrix[i][j] > matrix[i - 1][j - 1] && matrix[i][j] > matrix[i - 1][j]
                        && matrix[i][j] > matrix[i - 1][j + 1] && matrix[i][j] > matrix[i][j - 1]
                        && matrix[i][j] > matrix[i][j + 1] && matrix[i][j] > matrix[i + 1][j - 1]
                        && matrix[i][j] > matrix[i + 1][j] && matrix[i][j] > matrix[i + 1][j + 1]){
                    System.out.println(matrix[i][j]);
                    if(answer > matrix[i][j]){
                        answer = matrix[i][j];
                    }
                }
            }
        }

        if(answer == 2147483647){
            System.out.println("Didn't find!");
        }else{
            System.out.println(answer);
        }
    }
}