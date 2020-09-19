package core;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;

import java.io.FileInputStream;
import java.io.IOException;

public class JsonPathO {
    public static void main(String [] args) throws InvalidJsonException, IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/books.json");

        Object document = Configuration.defaultConfiguration().jsonProvider().parse(fis, "UTF-8");

        String author0 = JsonPath.read(document, "$.store.book[0].author");
        String author1 = JsonPath.read(document, "$.store.book[1].author");

        Double price1 = JsonPath.read(document, "$.store.bicycle.price");
        String color = JsonPath.read(document, "$.store.bicycle.color");
        int expencive = JsonPath.read(document, "$.expensive");

        System.out.println(author0);
        System.out.println(author1);
        System.out.println(price1);
        System.out.println(color);
        System.out.println(expencive);
    }
}
