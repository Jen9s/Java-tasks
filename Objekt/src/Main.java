import java.io.Console;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Book a1 = new Book("Name1","Author1");
        Book a2 = new Book("Name2","Author2");
        Book a3 = new Book("Name3","Author2");
//        Book a3 = new Book("Name3","Author3");
        Shelf shelf = new Shelf();
        shelf.Insert(a2);
        shelf.Insert(a1);
        shelf.Insert(a3);

//        shelf.Sort();
//        System.out.println(shelf.BinSearch(a3));
//        shelf.Print();
        shelf.GroupByName();
        shelf.FilterByName("Name1");

    }
}

class Book implements Comparable<Book>{
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

    public void FilterByName(String name){
//            List<Integer> list = IntStream.of(2, 4, 6, 8, 10, 12)
//                    .boxed()
//                    .collect(Collectors.filtering(i -> i % 4 == 0,
//                            Collectors.toList()));

//        int count = (int) books_.stream().filter(b -> b.author.equals("bob")).count();
        List<Book> FilterByFirm = books.stream().filter(i -> Objects.equals(i.getName(), name)).toList();
        for (Book book : FilterByFirm) {
            System.out.println(book);
        }
//        groupByFirm.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void GroupByName(){
        Map<String, List<Book>> groupByFirm = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
        groupByFirm.forEach((key, value) -> System.out.println(key + " " + value));
    }

}

class Comp implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.compareTo(o2);
    }
}