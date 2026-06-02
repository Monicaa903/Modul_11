import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AkunBank dompetNasabah = new AkunBank("123456", 5000000.0);
        AkunBank rekeningTujuan = new AkunBank("789012", 1000000.0);

        System.out.println("~~~ SIMULASI ATM DIGITAL ~~~");
        System.out.println("Saldo Awal Nasabah: Rp " + dompetNasabah.getSaldo());

        try {
            dompetNasabah.tarikTunai(3000000.0);
            dompetNasabah.tarikTunai(2000000.0);
            dompetNasabah.tarikTunai(50000.0);
        } catch (SaldoTidakMencukupiException e) {
            System.out.println(e.getMessage());
            System.out.println("Kekurangan dana sebesar: Rp " + e.getKekurangan());
        }

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        AkunBank nasabahKedua = new AkunBank("555555", 15000000.0);
        System.out.println("Saldo Awal Nasabah Kedua: Rp " + nasabahKedua.getSaldo());

        try {
            nasabahKedua.transfer(rekeningTujuan, 4000000.0);
            nasabahKedua.transfer(rekeningTujuan, 7000000.0);
        } catch (SaldoTidakMencukupiException e) {
            System.out.println(e.getMessage());
            System.out.println("Kekurangan dana sebesar: Rp " + e.getKekurangan());
        } catch (BatasTransferHarianException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nSesi transaksi ATM Anda telah diakhiri. Kartu dikeluarkan otomatis.");
        }
    }
}
