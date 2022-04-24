package genericsExercise;

/**
 * Klasa ArrayBox ktorej typ generyczny musi byc obiektem implementujacym interfejs Comparable.
 * Klasa posiada metody, dzieki ktorym mozemy: dodawac elementym do ArrayBox'a,
 * wyznaczyc max oraz min na podstawie metod compareTo w zaleznosci od obiektu,
 * wyszukac dany element czyli okreslic na jakim indexie sie znajduje,
 * wyswietlic wszystkie elementy z tablicy,
 * zamienic obiekty z poszczegolnych indexow miejscami,
 * usunac dany element,
 * dodac tablice elementow do ArrayBox'a,
 * @param <T>
 */
public class ArrayBox<T extends Comparable> {
    private Object[] tab;

    /**
     * Konstruktor w ktorym nalezy podac poczatkowa wielkosc ArrayBox'a
     * @param limit
     */
    public ArrayBox(int limit) {
        tab = new Object[limit];
    }

    /**
     * Metoda dodaje element do ArrayBox'a. W pierwszej kolejnosci metoda sprawdza czy element znajduje sie w tablicy za pomoca metody, nastepnie sprawdza czy mamy dostepne wolne miejsce,
     * jezeli tak dodaje element na ostatnim wolnym indexie, jezeli nie tworzy zastepcza tablice ktorej rozmiar jest o 1 wiekszy aby dodac nowy element.
     * Metoda zwraca true jezeli operacja sie udala, oraz false w przeciwnym przypadku
     * @param element
     * @return
     */
    public boolean add(T element) {
        if (search(element) != -1) {
            return false;
        } else if (isFreePlace()) {
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] == null) {
                    tab[i] = element;
                    break;
                }
            }
            return true;
        } else {
            Object[] replacementTab = new Object[tab.length + 1];
            for (int i = 0; i < tab.length; i++) {
                replacementTab[i] = tab[i];
            }
            replacementTab[tab.length] = element;
            tab = replacementTab;
            return true;
        }
    }
    /**
     * Metoda zwraca najwiekszy element z ArrayBox'a. Metoda wybiera najwiekszy elemenent na podstawie porzadku zdefiniowanego w metodzie compareTo w klasach Osoba oraz Student
     * @return
     */
    public T max() {
        T maxOfTab = (T) tab[0];
        for (int i = 0; i < tab.length; i++) {
            if (((T) tab[i]).compareTo(maxOfTab) > 0) {
                maxOfTab = (T) tab[i];
            }
        }
        return maxOfTab;
    }

    /**
     * Metoda zwraca najmniejszy element z ArrayBox'a. Metoda wybiera najmniejszy elemenent na podstawie porzadku zdefiniowanego w metodzie compareTo w klasach Osoba oraz Student
     * @return
     */
    public T min() {
        T minOfTab = (T) tab[0];
        for (int i = 0; i < tab.length; i++) {
            if (((T) tab[i]).compareTo(minOfTab) < 0) {
                minOfTab = (T) tab[i];
            }
        }
        return minOfTab;
    }

    /**
     * Metoda ktora wyszukuje element w ArrayBox'ie a nastepnie zwraca jego index, w przeciwnym wypadku zwraca -1
     * @param element
     * @return
     */
    public int search(T element) {
        int index = -1;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Metoda wyswietla zawartosc ArrayBox'a
     */
    public void print() {
        for (int i = 0; i < tab.length; i++) {
            System.out.println((T) tab[i]);
        }
    }

    /**
     * Metoda zamienia dwa obiekty o index podanych jako parametr miejscami w ArrayBox'ie. Jezeli jeden z indexow podanych do metody jest nieprawidlowy metoda zwraca false
     * @param index1
     * @param index2
     * @return
     */
    public boolean swap(int index1, int index2) {
        if (!(index1 > tab.length - 1 || index2 > tab.length - 1)) {
            Object elemenet1 = tab[index1];
            tab[index1] = tab[index2];
            tab[index2] = elemenet1;
            return true;
        }
        return false;
    }

    /**
     * Metoda usuwa podany element z ArrayBox'a oraz zmniejsza jego rozmiar o jeden
     * @param element
     * @return
     */
    public boolean delete(T element) {

        if (search(element) != -1) {
            Object[] replacementTab = new Object[tab.length - 1];
            int indexOfReplacementTab = 0;
            for (int i = 0; i < tab.length; i++) {

                if (tab[i] != element) {
                    replacementTab[indexOfReplacementTab] = tab[i];
                    indexOfReplacementTab++;
                }
            }
            tab = replacementTab;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metoda dodaje wszystkie elementy z tablicy przyjetej jako parametr do ArrayBox'a
     * @param replacementTab
     * @return
     */
    public boolean addAll(T[] replacementTab) {
        boolean result = false;
        for (int i = 0; i < replacementTab.length; i++) {
            result = add(replacementTab[i]);
        }
        return result;
    }

    /**
     * Metoda sprawdza czy w ArrayBox'ie jest dostepne miejsce, czyli czy na ktoryms index'ie jest null
     * @return
     */
    private boolean isFreePlace() {
        boolean isFreePlace = false;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                isFreePlace = true;
                break;
            }
        }
        return isFreePlace;
    }
}
