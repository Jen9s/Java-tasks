package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {
    private ArrayList<Shoe> sclad = new ArrayList<Shoe>();

    Shop(){}

    public void Insert(Shoe o){
        sclad.add(o);
    }


    public void toConsole(){
        System.out.println(this);
    }

    public  void inFile(String nameFile) throws IOException {
        FileWriter writer = new FileWriter(nameFile,false);
        writer.write(sclad.toString());
        writer.flush();
    }

    public void fromFile(String nameFile) {
        String text = GetFromFileForAvtomat(nameFile);
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        int size  = Integer.parseInt(matcher.group());
        String[] words = text.split(" ");

        int counter = 2;
        while (size > 0){
            String tmpString = words[counter];
            counter++;
            double tmpDouble = Double.parseDouble(words[counter]);
            counter++;
            int tmpInt = Integer.parseInt(words[counter]);
            counter++;
            double tmpDoubleDouble = Double.parseDouble(words[counter]);
            Shoe shoe = new Shoe(tmpString,tmpDouble,tmpInt,tmpDoubleDouble);
            sclad.add(shoe);
            counter++;
            size--;
        }
    }

    public void fromFileReg(String nameFile){

//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            StringBuilder numberFromText1 = new StringBuilder(matcher.group());
//            StringBuilder numberFromText2 = new StringBuilder(matcher.group(3));
//            StringBuilder numberFromText3 = new StringBuilder(matcher.group(2));
//            StringBuilder numberFromText4 = new StringBuilder(matcher.group(5));
//            StringBuilder numberFromText5 = new StringBuilder(matcher.group(4));
//            sclad.add(new Lekarstvo(numberFromText1.substring(1,numberFromText1.length() - 1), Integer.parseInt(numberFromText2.toString()),
//                    numberFromText3.substring(1,numberFromText3.length() - 1),Integer.parseInt(numberFromText4.toString()),Double.parseDouble(numberFromText5.toString())));

    }

//    public static double GetSum(String text){
//        double sum = 0;
//        Pattern pattern = Pattern.compile("[ ]([+-]?((\\d*\\.\\d*e-?\\d+)|(\\d+_+\\d+_*\\d*)|(\\d*\\.?\\d+[FL]?)))");
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            StringBuilder numberFromText = new StringBuilder(matcher.group());
//
//            if(numberFromText.charAt(numberFromText.length() - 1) == 'L'){
//                numberFromText.deleteCharAt(numberFromText.length() - 1);
//                long number = Long.parseLong(numberFromText.toString());
//                sum += number;
//            }

    public void SortName(){
        sclad.sort(new NameComparator());
    }

    public void BinSerchName(String name){
        int counter = Collections.binarySearch(sclad, new Shoe(name,0,0,0), Shoe::compareTo);
        if(counter < 0){
            System.out.println("Not found!");
        } else {
            System.out.println(sclad.get(counter));
        }
    }

    public void SortPriceHigh(){
        sclad.sort(new PriceHighComparator());
    }

    public void GroupByDate(){
        Map<Double, List<Shoe>> groupByFirm = sclad.stream().collect(Collectors.groupingBy(Shoe::getDate));
        groupByFirm.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public List<Shoe> ListDate(double date){
        List<Shoe> shoes = sclad.stream().filter(shoe -> shoe.getDate() == date).toList();
        return shoes;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        answer.append(sclad.toString() + '\n');
        return answer.toString();
    }

    public ArrayList<Shoe> getSclad() {
        return sclad;
    }

    public void setSclad(ArrayList<Shoe> sclad) {
        this.sclad = sclad;
    }

    public static String GetFromFileForAvtomat(String nameFile) {
        Path filePath = Path.of(nameFile);
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
