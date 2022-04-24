package genericsExercise;

/**
 * Klasa Osoba posiada pola okreslajace nazwisko oraz wiek, implementuje interfejs Comparable
 */

public class Osoba implements Comparable<Osoba> {
    private String surname;
    private int age;

    public Osoba(String surname, int age) {
        this.surname = surname;
        this.age = age;
    }

    /**
     * Metoda compareTo porownuje dwa obiekty klasy Osoba wedlug zdefiniowanego porzadku: na początku porownuje naziwska, nastepnie wiek(jezeli nazwiska sa takie same)
     * @param o
     * @return
     */
    @Override
    public int compareTo(Osoba o) {
        if (age > o.getAge()) {
            return 1;
        } else if (age < o.getAge()) {
            return -1;
        } else {
            return this.surname.compareTo(o.getSurname());
        }
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
