package genericsExercise;

public class Main {
    public static void main(String[] args) {

        /**
         * Utworzenie ArrayBox'a "bo" z poczatkowa wielkoscia 2
         */
        ArrayBox<Osoba> bo = new ArrayBox<>(2);

        /**
         * Dodanie elementow do listy
         */
        bo.add(new Osoba("Kowalski", 19));
        bo.add(new Student("Kowalska", 18, 100));
        bo.add(new Student("Kowalska", 20, 200));

        /**
         * Utworzenie tablicy elementow oraz dodanie do niej dwoch obiektow klasy Osoba oraz Student
         */
        Osoba[] to = new Osoba[]{new Osoba("Nowak", 21), new Student("Nowak", 22, 200)};

        /**
         * Dodanie tablicy "to" do ArrayBox'a "bo"
         */
        bo.addAll(to);

        /**
         * Wyswietlenie minimum z ArrayBox "bo"
         */
        System.out.println(bo.min());

        /**
         * Utworzenie ArrayBox'a "bst" z poczatkowa wielkoscia 1 oraz dodanie do niego 3 obiektow klasy Student
         */
        ArrayBox<Student> bst = new ArrayBox<>(1);
        bst.add(new Student("Nowacka", 24, 100));
        bst.add(new Student("Nowacka", 24, 300));
        bst.add(new Student("Nowacka", 24, 200));

        /**
         * Wyswietlenie maximum z ArrayBox'a o nazwie "bst"
         */
        System.out.println(bst.max());

        /**
         * Utworzenie ArrayBox'a "bi" z poczatkowa wielkoscia 2
         */
        ArrayBox<Integer> bi = new ArrayBox<>(2);

        /**
         * Utworzenie tablicy "ti" z 3 elementami
         */
        Integer[] ti = new Integer[]{Integer.valueOf(1), 2, 3};

        /**
         * Dodanie tablicy "ti" do ArrayBox'a "bi"
         */
        bi.addAll(ti);

        /**
         * Wyswietlenie elementow z ArrayBox'a "bi"
         */
        bi.print();

        /**
         * Utworzenie ArrayBox'a bs z poczatkowa wielkoscia 1
         */
        ArrayBox<String> bs = new ArrayBox<>(1);

        /**
         * Utworzenie tablicy "ts" z 2 elementami
         */
        String[] ts = new String[]{"cpp", new String("java")};

        /**
         * Dodanie tablicy "ts" do ArrayBox'a "bs"
         */
        bs.addAll(ts);

        /**
         * Zamiana miejscami elementow z indexow 0 oraz 1 w ArrayBox "bs"
         */
        bs.swap(0, 1);

        /**
         * Wyswietlenie zawartosci ArrayBox'a "bs"
         */
        bs.print();
    }

}