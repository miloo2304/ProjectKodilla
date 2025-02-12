package com.kodilla.stream;
import com.kodilla.stream.Project_7_1.SaySomething;
import com.kodilla.stream.Project_7_1.Executor;
import com.kodilla.stream.Project_7_1.Processor;
import com.kodilla.stream.Project_7_1.ExecuteSaySomething;
import com.kodilla.stream.Project_7_1.ExpressionExecutor;
import com.kodilla.stream.Project_7_1.Beautifier.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import com.kodilla.stream.Project_7_2.iterate.NumbersGenerator;
import com.kodilla.stream.Project_7_3.person.People;
import com.kodilla.stream.Project_7_3.book.Book;
import com.kodilla.stream.Project_7_3.book.BookDirectory;
import com.kodilla.stream.Project_7_3.forumuser.Forum;
import com.kodilla.stream.Project_7_3.forumuser.ForumUser;


public class StreamMain {
    public static void main(String[] args) {
        //Project 7.3
        Forum forum = new Forum();
        Map<Integer, ForumUser> par = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getAge() >= 20)
                .filter(user -> user.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));
        par.forEach((id, user) -> System.out.println(id + " -----> " + user));

        /*
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
        */

        /*
        BookDirectory theBookDirectory = new BookDirectory();
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]

        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
                .forEach(System.out::println);
         */
        // People.getList().stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        //People.getList().stream().map(String::toUpperCase).forEach(s -> System.out.println(s));          // [2]
        //People.getList().stream().filter(s -> s.length() > 11).forEach(System.out::println);
        /*
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()   // [1]
                .filter(book -> book.getYearOfPublication() > 2005)                  // [2]
                .collect(Collectors.toList());                                       // [3]

        System.out.println("# elements: " + theResultListOfBooks.size());       // [4]
        theResultListOfBooks.stream()                                           // [5]
                .forEach(System.out::println);
         */
        /*
        //Project 7.2
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        */
        /*
        //Project 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Good Morning", text -> "ABC " + text + " ABC");
        poemBeautifier.beautify("Good Morning", text -> text.toUpperCase());
        poemBeautifier.beautify("Good Morning", text -> text.toLowerCase());
        poemBeautifier.beautify("Good Morning", text -> "♥" + text + "♥"); //I will ask about that when we will talk.
        poemBeautifier.beautify("Good Morning", text -> "\u2665" + text + "\u2665");
        poemBeautifier.beautify("Good Morning", text -> "★" + text + "★");
        poemBeautifier.beautify("Good Morning", text -> "*** " + text + " ***");
        poemBeautifier.beautify("Good Morning", text -> new StringBuilder(text).reverse().toString());
        poemBeautifier.beautify("Good Morning", text -> text.substring(0, text.length()).toLowerCase());
        */

        /*
        System.out.println("Hello, World!");
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);


         */
    }
}