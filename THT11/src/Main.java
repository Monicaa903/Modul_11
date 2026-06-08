import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        SistemReservasi sistem = new SistemReservasi();
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        try {
            while (berjalan) {
                System.out.println("\n=== SISTEM RESERVASI JAVA EXPRESS ===");
                System.out.println("1. Lihat Jadwal & Sisa Kursi");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");

                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

                    if (pilihan == 1) {
                        System.out.println("\n--- JADWAL KERETA API ---");
                        for (Kereta k : sistem.getDaftarKereta()) {
                            System.out.println("Kode: " + k.getKodeKereta() + 
                                               " | Nama: " + k.getNamaKereta() + 
                                               " | Rute: " + k.getRute() + 
                                               " | Sisa Kursi: " + k.getSisaKursi());
                        }
                    } else if (pilihan == 2) {
                        System.out.print("Masukkan Kode Kereta: ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan NIK: ");
                        String nik = scanner.nextLine();
                        System.out.print("Masukkan Nama Penumpang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Jumlah Tiket: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        sistem.pesanTiket(kode, nik, nama, jumlah);
                    } else if (pilihan == 3) {
                        berjalan = false;
                    } else {
                        System.out.println("Pilihan menu tidak valid!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input harus berupa angka!");
                    scanner.nextLine();
                } catch (DataPenumpangTidakValidException e) {
                    System.out.println("Error Validasi Penumpang: " + e.getMessage());
                } catch (RuteTidakDitemukanException e) {
                    System.out.println("Error Rute: " + e.getMessage());
                } catch (TiketHabisException e) {
                    System.out.println("Error Ketersediaan: " + e.getMessage());
                    System.out.println("Kereta: " + e.getNamaKereta() + " | Sisa Kursi: " + e.getSisaKursi());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error Input: " + e.getMessage());
                }
            }
        } finally {
            scanner.close();
            System.out.println("\nTerima kasih telah menggunakan layanan JAVA EXPRESS!");
        }
    }
}
