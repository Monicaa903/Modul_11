public class Mahasiswa {
    private String nama;
    private int sisaSks;

    public Mahasiswa(String nama, int sksAwal) {
        this.nama = nama;
        this.sisaSks = sksAwal;
    }
   
    public void setSksMaksimal(int sks) {
        if (sks < 2 || sks > 24) {
            throw new IllegalArgumentException("Kesalahan sistem: Batas SKS tidak valid (harus antara 2 - 24 SKS)!");
        }
        System.out.println("SKS Maksimal berhasil diatur: " + sks + " SKS.");
    }

    
    public void ambilMataKuliah(String namaMatkul, int bebanSks) {
        if (bebanSks > sisaSks) {
            throw new SksTidakCukupException("Error! SKS tidak mencukupi untuk mengambil " + namaMatkul + "!");
        }
        sisaSks -= bebanSks;
        System.out.println(nama + " berhasil mengambil " + namaMatkul + ". Sisa SKS: " + sisaSks);
    }
}
