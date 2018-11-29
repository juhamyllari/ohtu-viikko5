package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntJoukko {

    private final static int DEFAULT_INITIAL_CAPACITY = 5;
    private final static int DEFAULT_INCREMENT = 5;
    private int increment;
    private int[] array;
    private int size;

    public IntJoukko() {
        array = new int[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        size = 0;
        this.increment = DEFAULT_INCREMENT;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        array = new int[kapasiteetti];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        size = 0;
        this.increment = DEFAULT_INCREMENT;
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        array = new int[kapasiteetti];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        size = 0;
        this.increment = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (contains(luku)) {
            return false;
        }
        if (size == array.length) {
            extendArray();
        }
        array[size] = luku;
        size++;
        return true;
    }

    private void extendArray() {
        int[] newArray = new int[array.length + increment];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public boolean contains(int luku) {
        for (int i : array) {
            if (i == luku) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        if (!contains(luku)) {
            return false;
        }
        List<Integer> lst = Arrays.stream(array).boxed().collect(Collectors.toList());
        int index = lst.indexOf((Integer) luku);
        int[] newArray = new int[array.length];
        System.arraycopy(array, index + 1, newArray, index, size - index - 1);
        array = newArray;
        size--;
        return true;
    }

    public int mahtavuus() {
        return size;
    }

    @Override
    public String toString() {
        int[] elements = toIntArray();
        String elementsAsString = Arrays.stream(elements)
                .boxed()
                .map(i -> i.toString())
                .collect(Collectors.joining(", "));
        return "{" + elementsAsString + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[size];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = array[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko newJoukko = new IntJoukko();
        for (int i : a.toIntArray()) {
            newJoukko.lisaa(i);
        }
        for (int i : b.toIntArray()) {
            newJoukko.lisaa(i);
        }
        return newJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko newJoukko = new IntJoukko();
        int[] elementsOfA = a.toIntArray();
        for (int i : elementsOfA) {
            if (b.contains(i)) {
                newJoukko.lisaa(i);
            }
        }
        return newJoukko;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko newJoukko = new IntJoukko();
        int[] elementsOfA = a.toIntArray();
        for (int i : elementsOfA) {
            if (!b.contains(i)) {
                newJoukko.lisaa(i);
            }
        }
        return newJoukko;
    }

}
