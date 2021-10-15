import java.util.Random;
import java.util.Scanner;

public class n2SortingAlgorithms {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String sortingChoice = "";
        int arrLength = 0;
        int size = 0;

        //input validation for the first user input
        do{
            System.out.println("What type of sorting algorithm do you want to apply? Type 'b' for Bubble Sort, 's' for Selection Sort or 'i' for Insertion Sort");
            sortingChoice = scanner.nextLine();
        } while(!(sortingChoice.equalsIgnoreCase("b") || sortingChoice.equalsIgnoreCase("s") || sortingChoice.equalsIgnoreCase("i")));

        //input validation for the second user input
        do {
            System.out.println("Please enter a number for the length of the array");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            size = scanner.nextInt();
        } while (size <= 0);

        arrLength = size;
        int[] myArray = new int[arrLength];

        // filling the array with random numbers from 1 to 10000
        for(int i = 0; i <myArray.length; i++){
            myArray[i] = random.nextInt(10000 - 1) + 1;;
        }
        System.out.print("Initial array: ");
        printArray(myArray);   //the original array

        //Use the corresponding algorithm based on the user's choice
        if(sortingChoice.equalsIgnoreCase("b")){
            bubbleSort(myArray);
        } else if (sortingChoice.equalsIgnoreCase("s")){
            selectionSort(myArray);
        } else {
            insertionSort(myArray);
        }
        System.out.print("Sorted array: ");
        printArray(myArray);   //the sorted array
    }

    /**
     *
     * @param arr
     * @return the sorted array
     */
    public static int[] bubbleSort(int[]arr){
        for(int i = 0; i <arr.length; i ++){
            for(int j = 0; j<arr.length - 1; j++){
                //swapping the adjacent elements
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     *
     * @param arr
     * @return the sorted array
     */
    public static int[] selectionSort(int [] arr){
        for(int i = 0; i <arr.length; i ++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = i; j<arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
        return arr;
    }

    /**
     *
     * @param arr
     * @return the sorted array
     */
    public static int[] insertionSort (int [] arr){
        for(int i = 1; i < arr.length; i++){
            int currentValue = arr[i];
            int k = i-1;

            while(k >=0 && arr[k] > currentValue){
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = currentValue;
        }
        return arr;
    }

    /**
     * Prints out an array
     * @param arr
     */
    public static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
