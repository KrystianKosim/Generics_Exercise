package genericsExercise;

/**
 * Klasa Student dziedziczy po klasie osoba, dodatkowo posiada pole okreslajace numer grupy danego studenta
 */
public class Student extends Osoba {
    private int numberOfGroup;

    public Student(String surname, int age, int numberOfGroup) {
        super(surname, age);
        this.numberOfGroup = numberOfGroup;
    }

    /**
     *Metoda compareTo, która sortuje wedlug ustalonego porzadku jezeli porownuje dwa obiekty klasy Student, w przeciwnym wypadku odwoluje sie do metody compareTo z klasy Osoba
     * @param o
     * @return
     */
    @Override
    public int compareTo(Osoba o) {
        if (o instanceof Student) {
            if (super.compareTo(o) != 0) {
                return super.compareTo(o);
            } else if (numberOfGroup > ((Student)o).getNumberOfGroup()) {
                return 1;
            } else {
                return -1;
            }
        }
        return super.compareTo(o);
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                "numberOfGroup=" + numberOfGroup +
                '}';
    }
}
