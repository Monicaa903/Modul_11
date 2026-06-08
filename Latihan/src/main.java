import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("   SIMULASI SISTEM RENCANA STUDI (KRS)   ");
        System.out.println("=========================================");
       
        System.out.println("\n[Soal 1: Input Kuota Kelas]");
        int[] kuotaMatkul = new int[3];
        
        for (int i = 0; i < 4; i++) { 
            try {
                System.out.print("Masukkan kuota mata kuliah ke-" + (i + 1) + ": ");
                int kuota = scanner.nextInt();
                kuotaMatkul[i] = kuota;
                System.out.println("Kuota disimpan di indeks ke-" + i);
            } catch (InputMismatchException e) {
                System.out.println("Ditangkap: Error! Input harus berupa angka integer!");
                scanner.nextLine(); 
                i--; 
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ditangkap Error: Terjadi kesalahan batas array! " + e.getMessage());
            }
        }

        System.out.println("\n[Validasi Batas SKS]");
        Mahasiswa mhs = new Mahasiswa("Budi", 22);
        try {
            System.out.println("Mencoba set SKS ke 25 (melebihi batas)...");
            mhs.setSksMaksimal(25); 
        } catch (IllegalArgumentException e) {
            System.out.println("Ditangkap : " + e.getMessage());
        }
        
        System.out.println("\n[Pengambilan Mata Kuliah]");
        try {
            mhs.ambilMataKuliah("Pemrograman Berorientasi Objek", 4); 
            System.out.println("Mencoba mengambil kelas Tugas Akhir (20 SKS)...");
            mhs.ambilMataKuliah("Tugas Akhir", 20); 
        } catch (SksTidakCukupException e) {
            System.out.println("Ditangkap : " + e.getMessage());
        }

        System.out.println("\n[Pengecekan Kapasitas Kelas]");
        SistemAkademik sistem = new SistemAkademik();
        try {
            System.out.println("Mencoba gabung ke kelas dengan kuota 0...");
            sistem.gabungKelas("IF-301", 0); 
        } catch (KelasPenuhException e) {
            System.out.println("Ditangkap : " + e.getMessage());
        }

        System.out.println("\n[Cetak KRS & Penutupan Sesi]");
        try {
            System.out.print("Masukkan nama file KRS yang ingin dicetak: ");
            scanner.nextLine(); 
            String namaFile = scanner.nextLine(); 
            
            sistem.cetakDokumenKrs(namaFile); 
        } catch (FileNotFoundException e) {
            System.out.println("Ditangkap : " + e.getMessage());
        } finally {
            System.out.println("\n>> Sesi Sistem Rencana Studi telah ditutup. Koneksi database diputuskan.");
        }

        scanner.close();
    }
}

