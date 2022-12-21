import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        String text = GetFromFileForNumbers();
//        System.out.println(GetSum(text));
          Regs();
    }

    public static int FindSimbol(StringBuilder text,char simbol,int index){
        int answer = -1;
        for(int i = index; i < text.length();i++){
            if(text.charAt(i) == simbol){
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static int FindNotSimbol(StringBuilder text,char simbol,int index){
        int answer = -1;
        for(int i = index; i < text.length();i++){
            if(text.charAt(i) != simbol){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static double GetSum(String text){
     double sum = 0;
        Pattern pattern = Pattern.compile("[ ]([+-]?((\\d*\\.\\d*e-?\\d+)|(\\d+_+\\d+_*\\d*)|(\\d*\\.?\\d+[FL]?)))");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            StringBuilder numberFromText = new StringBuilder(matcher.group());
//
            if(numberFromText.charAt(numberFromText.length() - 1) == 'L'){
                numberFromText.deleteCharAt(numberFromText.length() - 1);
                long number = Long.parseLong(numberFromText.toString());
                sum += number;
            }
            else {
                if (numberFromText.charAt(numberFromText.length() - 1) == 'F') {
                    float number = Float.parseFloat(numberFromText.toString());
                    sum += number;
                }else{
                    int flag = 0;
                    for(int i = 0; i < numberFromText.length();i++){
                        if(numberFromText.charAt(i) == '.'){
                            flag = 1;
                            break;
                        }
                        if(numberFromText.charAt(i) == '_'){
                            flag = 2;
                            int index = 0;
                            while (index != -1) {
                                index = FindSimbol(numberFromText, '_', 0);
                                if(index != -1)
                                    numberFromText.delete(index,FindNotSimbol(numberFromText, '_', index));
                            }
                            break;
                        }
                    }
                    if(flag == 0){
                        int number = Integer.parseInt(numberFromText.toString());
                        sum += number;
                    }
                    if(flag == 1){
                        double number = Double.parseDouble(numberFromText.toString());
                        sum += number;
                    }
                    if(flag == 2){
                        long number = Long.parseLong(numberFromText.toString());
                        sum += number;
                    }
                }
            }
        }

     return sum;
    }

    public static void Regs(){
        enum State {START, CHR_BODY,STR_BODY,UNSTR_BODY,SPEC_SIMBOL,SUSP_COM,ONESTR_COM,COM}
            StringBuilder text = new StringBuilder(GetFromFileForAvtomat());
            State state = State.START;
        for(int i = 0; i < text.length();i++){
                switch (state) {
                    case START:
                    case CHR_BODY:
                    case STR_BODY:
                    case UNSTR_BODY:
                }
            }
//            result.add(fieldValue.toString());

        }


        

    public static String GetFromFileForNumbers() {
        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\Reg\\input.txt");
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static String GetFromFileForAvtomat() {
        Path filePath = Path.of("C:\\Users\\user\\IdeaProjects\\Reg\\inputForAvtomat.txt");
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}