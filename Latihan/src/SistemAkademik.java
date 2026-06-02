import java.io.FileNotFoundException;

public class SistemAkademik {

    //Soal 4
    public void gabungKelas(String kodeKelas, int kuotaTersedia) throws KelasPenuhException {
        if (kuotaTersedia <= 0) {
            throw new KelasPenuhException("Error! Kelas " + kodeKelas + " sudah penuh!");
        }
        System.out.println("Berhasil bergabung dengan kelas " + kodeKelas);
    }

    //Soal 5
    public void cetakDokrumenKrs(String namaFile) throws FileNotFoundException {
        if (!namaFile.equals("krs_valid.txt")) {
            throw new FileNotFoundException("Error! File " + namaFile + " tidak ditemukan dalam sistem!");
        }
        System.out.println("Dokumen " + namaFile + " berhasil dicetak.");
    }
}
