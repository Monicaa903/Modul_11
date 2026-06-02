public class SaldoTidakMencukupiException extends Exception {
    private double kekurangan;

    public SaldoTidakMencukupiException(String pesan, double kekurangan) {
        super(pesan);
        this.kekurangan = kekurangan;
    }

    public double getKekurangan() {
        return kekurangan;
    }
}
