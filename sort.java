import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        int n;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of names to be sorted:");
         try {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input for the number of names.");
            return;
        }
        
        String names[] = new String[n];
        System.out.println("Enter the names:");
        try {
            for (int i = 0; i < n; i++) {
                names[i] = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading input names.");
            return;
        }
       
        Sort s1 = new Sort(names);
        s1.quicksort(0, names.length - 1);
        s1.printNames();
    }
}

class Sort {
    String s[];

    public Sort(String s[]) {
        this.s = s;
    }

    public void quicksort(int low, int high) {
        if (s == null || s.length == 0) {
            return;
        }

        if (low < high) {
            int index = partition(low, high);
            quicksort(low, index - 1);
            quicksort(index + 1, high);
        }
    }

    private int partition(int low, int high) {
        String pivot = s[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (s[j].compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i, low);
        return i;
    }

    private void swap(int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public void printNames() {
        System.out.println("Names in ascending order are:");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
