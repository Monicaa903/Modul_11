import java.util.ArrayList;
import java.util.List;

public class SistemReservasi {
    private List<Kereta> daftarKereta;

    public SistemReservasi() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }

    public List<Kereta> getDaftarKereta() {
        return daftarKereta;
    }

    public void pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket) 
            throws RuteTidakDitemukanException, TiketHabisException {
        
        if (nik.length() != 16 || !nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException("NIK harus berisi 16 digit angka!");
        }

        if (jumlahTiket <= 0) {
            throw new IllegalArgumentException("Jumlah tiket pemesanan harus lebih dari 0!");
        }

        Kereta keretaDitemukan = null;
        for (Kereta k : daftarKereta) {
            if (k.getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                keretaDitemukan = k;
                break;
            }
        }

        if (keretaDitemukan == null) {
            throw new RuteTidakDitemukanException("Kereta dengan kode " + kodeKereta + " tidak ditemukan!");
        }

        if (jumlahTiket > keretaDitemukan.getSisaKursi()) {
            throw new TiketHabisException("Sisa kursi tidak mencukupi!", keretaDitemukan.getNamaKereta(), keretaDitemukan.getSisaKursi());
        }

        keretaDitemukan.kurangiKursi(jumlahTiket);
        System.out.println("\n--- RESERVASI BERHASIL ---");
        System.out.println("Nama Penumpang : " + namaPenumpang);
        System.out.println("Kereta         : " + keretaDitemukan.getNamaKereta());
        System.out.println("Rute           : " + keretaDitemukan.getRute());
        System.out.println("Jumlah Tiket   : " + jumlahTiket);
        System.out.println("--------------------------");
    }
}
