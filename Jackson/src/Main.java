import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {
        Book a1 = new Book("Name1","Author1");
        Book a2 = new Book("Name2","Author2");
        Book a3 = new Book("Name3","Author3");
        Shelf shelf = new Shelf();
        shelf.Insert(a2);
        shelf.Insert(a1);
        shelf.Insert(a2);
        shelf.books.sort((Book b1, Book b2) -> (b2.getAuthor().compareTo(b1.getAuthor()))); //0
//        System.out.println(shelf.BinSearch(a3));

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable((SerializationFeature.INDENT_OUTPUT));
        FileOutputStream fout = new FileOutputStream("book.json");
        objectMapper.writeValue(fout,
                new Book("WaW","AwA"));
        fout.close();

        FileOutputStream fout_shelf = new FileOutputStream("shelf.json");
        objectMapper.writeValue(fout_shelf,shelf);
        fout_shelf.close();

        Shelf readShelf = objectMapper.readValue(new File("shelf.json"),Shelf.class);
        System.out.println(readShelf);

        Book readBook = objectMapper.readValue(new File("book.json"),Book.class);
        System.out.println(readBook);
//        shelf.Print();
//        ArrayList<Book> answer;
//        Stream<Book> stream;

//        int counter = (int)shelf.books.stream().count(Book o -> o.);

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable((SerializationFeature.INDENT_OUTPUT));
//        FileOutputStream fout = new FileOutputStream("book.jason");
//        objectMapper.writeValue(fout,
//                shelf);
//        fout.close();

//        String json = objectMapper.writeValueAsString(shelf);
//        System.out.println(json);
//
//
//        Book shelf1 = objectMapper.readValue(
//                new File("C:\\Users\\user\\IdeaProjects\\Jackson\\book.json"), Book.class
//        );

//        objectMapper.readValue(new File())

//        System.out.println(shelf1);
    }
}

class Book implements Comparable<Book>{

    public Book(){
        this.name = "name";
        this.author = "author";
    }
    private String name;
    private String author;

    public String getAuthor(){
        return author;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name + " " + author;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(name, ((Book)obj).name) && Objects.equals(author, ((Book)obj).author);
    }

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public void scan(){
        Scanner sc = new Scanner(System.in);
        name = sc.toString();
        author = sc.toString();
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo((o.name));
    }
}

class Shelf{
    public ArrayList<Book> books = new ArrayList<Book>();

    public void Insert(Book o){
        books.add(o);
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for(var i : books){
            answer.append(books.toString() + '\n');
        }
        return answer.toString();
    }


    public void Sort(){
        books.sort(new Comp());
    }

    public void Print () {
        for(var i : books){
            System.out.println(i);
        }
    }


    public boolean BinSearch (Book key){
        int left = 0;
        int right = books.size();
        while (left < right){
            int mid = (left + right) / 2;
            if(key.equals(books.get(mid))){
                return true;
            }
            else{
                if(books.get(mid).getName().compareTo(key.getName()) == 1){
                    right = mid;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }

//    public int AuthorBooks(String author_){
//        List<Book> books = Shelf.stream().filter(book -> book.getAuthor().equals(author_)).collect(Collectors.toList());
//        for (int i = 0; i < books.size(); i++) {
//            System.out.println(books.get(i));
//
//        }
//        return books.size();
//    }




}

class Comp implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.compareTo(o2);
    }
}