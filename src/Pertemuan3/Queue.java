package Pertemuan3;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Created by Hanafi Nst on 4/4/2017.
 */
public class Queue<T> {
    public T[] element;
    public int pointer =0;

    Queue(Class<?> namaClass, int size) { element = (T[]) Array.newInstance(namaClass, size); }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new Queue<>(Integer.class, 10);
        int n;
        do {
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.Show");
            System.out.println("4.Exit");
            System.out.println("Choose : ");
            n = scanner.nextInt();

            if(n == 1) {
                System.out.println("Input : ");
                queue.enqueue(scanner.nextInt());
            }
            else if(n == 2) {
                queue.dequeue();
            }
            else if(n == 3) {
                queue.show();
            }
        } while(n != 4);
    }

    public void show(){
        if(pointer == 0) {
            System.out.println("Queue Empty");
        }
        else{
            for(int i=0; i<pointer; i++){
                System.out.println(element[i]);
            }
        }
    }

    public T[] enqueue(T elements){
        if (pointer == 10){
            System.out.println("Queue Full");
        } else {
            element[pointer++] = elements;
        }
        return element;
    }

    public void dequeue() {
        try{
            if (pointer == 0) {
                System.out.println("Queue Empty");
            }
            else {
                for(int i=1; i<pointer; i++) {
                    element[i] = element[i + 1];
                }
                pointer--;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            pointer--;
            System.out.println(" ");
        }
    }
}