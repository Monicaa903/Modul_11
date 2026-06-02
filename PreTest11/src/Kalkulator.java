import java.util.Scanner;
import java.util.InputMismatchException;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            
            System.out.print("Masukkan angka pertama (pembilang): ");
            int pembilang = scanner.nextInt();
            
            System.out.print("Masukkan angka kedua (penyebut): ");
            int penyebut = scanner.nextInt();
            
            int hasil = pembilang / penyebut;
            System.out.println("Hasil pembagian: " + hasil);
            
        } catch (ArithmeticException e) {
            System.out.println("Error! Tidak dapat melakukan pembagian dengan 0!");
        } catch (InputMismatchException e) {
            System.out.println("Error! Input yang Anda masukkan harus berupa angka!");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}
