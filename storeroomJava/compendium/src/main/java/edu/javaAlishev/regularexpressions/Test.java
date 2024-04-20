package edu.javaAlishev.regularexpressions;

public class Test {
    public static void main(String[] args) {
        /*
           \\d - одна цифра
           \\w - одна буква

           + - 1 или более
           * - 0 или более
           ? - 0 или 1 символов до

           (x|y|z) - одна строка из множества трех

           [a-zA-Z] - все английские буквы
           [0 - 9] - \\d
           [^] - отрицания [^abc] - мы хотим все символы кроме [abc]
           . - любой символ

           {2} - 2 символа до (\\d{2})
           {2, } - 2 или более символов (\\d{2,})
           {2,4} - от 2 до 4 символов (\\d{2,4})
         */
        String a = "-13211";
        String b = "13211";
        String c = "+13211";
        System.out.println(a.matches("(-|\\+)?\\d*"));
        System.out.println(b.matches("([-+])?\\d*"));
        System.out.println(c.matches("([-+])?\\d*"));

        String d = "adf31sdf123456";
        System.out.println(d.matches("[a-zA-Z31]+\\d+"));

        String e = "sdf";
        System.out.println(e.matches("[^abc]*"));

        String url = "http://www.google.com";
        String url2 = "http://www.ya.ru";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));

        String f = "12";
        System.out.println(f.matches("\\d{2}"));


    }
}
