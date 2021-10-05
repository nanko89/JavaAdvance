package Jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> stringJar = new Jar<String>();
        Jar<Integer> integerJar = new Jar<Integer>();

        stringJar.add("Hello");
        stringJar.add("word");
        integerJar.add(46);
        integerJar.add(12);

        System.out.println(stringJar.remove());
        System.out.println(stringJar.remove());
        System.out.println(integerJar.remove());
        System.out.println(integerJar.remove());
    }
}
