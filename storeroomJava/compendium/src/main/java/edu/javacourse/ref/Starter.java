package edu.javacourse.ref;

public class Starter {
    public static void main(String[] args) {
        Starter st = new Starter();

        int a1 = 10;
        Simple s = new Simple(99l, "First");
        System.out.println("EXT 1:" + s);

        st.test(a1, s);

//        System.out.println("ID ext:" + a1);
        System.out.println("EXT 2:" + s);
    }

    private void test(int id, Simple simple) {
//        System.out.println("ID int:" + id);
        System.out.println("INT 1:" + simple);
//        simple = new Simple(44l, "Second");
        simple.setId(44l);
        System.out.println("INT 2:" + simple);

    }
}
