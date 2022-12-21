import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Введите число: ");
        n = sc.nextInt();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String changing_word = in.nextLine();


        String text = GetFromFile();

        var arr_tmp = text.split("\\.");
        text = "";
        for(int i = 0;i < arr_tmp.length;i++){
            text += arr_tmp[i];
            if(i != arr_tmp.length - 1)
                text += " .";
        }

        var arr_tmp1 = text.split(",");
        text = "";
        for(int i = 0;i < arr_tmp1.length;i++){
            text += arr_tmp1[i];
            if(i != arr_tmp1.length - 1)
                text += " ,";
        }

        var arr_tmp2 = text.split("'");
        text = "";
        for(int i = 0;i < arr_tmp2.length;i++){
            text += arr_tmp2[i];
            if(i != arr_tmp2.length - 1)
                text += " '";
        }



        var arr = text.split(" ");
        for (int i =0; i < arr.length - 1; i++){
            if (arr[i].length() == n){
                arr[i] = changing_word;

            }
        }
        String fin = "";
        for (var s: arr){
            fin += s + " ";
        }


        var arr_tmp3 = fin.split(" \\.");
        fin = "";
        for(int i = 0;i < arr_tmp3.length;i++){
            fin += arr_tmp3[i];
            if(i != arr_tmp3.length - 1)
                fin += ".";
        }

        var arr_tmp4 = fin.split(" ,");
        fin = "";
        for(int i = 0;i < arr_tmp4.length;i++){
            fin += arr_tmp4[i];
            if(i != arr_tmp4.length - 1)
                fin += ",";
        }

        var arr_tmp5 = fin.split(" '");
        fin = "";
        for(int i = 0;i < arr_tmp5.length;i++){
            fin += arr_tmp5[i];
            if(i != arr_tmp5.length - 1)
                fin += "'";
        }

        System.out.println(fin);
    }

    public static String GetFromFile() {
        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\Laboratory№3\\input.txt");
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}