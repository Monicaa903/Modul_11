public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;
    private final double limitHarian = 10000000.0;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0.0;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalTransferHariIni() {
        return totalTransferHariIni;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException("Error: Saldo tidak mencukupi untuk penarikan!", kekurangan);
        }
        saldo -= nominal;
        System.out.println("Tarik tunai berhasil: Rp " + nominal + " | Sisa saldo: Rp " + saldo);
    }

    public void transfer(AkunBank tujuan, double nominal) throws SaldoTidakMencukupiException, BatasTransferHarianException {
        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException("Error! Saldo tidak mencukupi untuk transfer!", kekurangan);
        }
        if (totalTransferHariIni + nominal > limitHarian) {
            throw new BatasTransferHarianException("Error! Transaksi gagal! Akumulasi transfer melampaui limit harian Rp 10.000.000");
        }
        saldo -= nominal;
        totalTransferHariIni += nominal;
        tujuan.saldo += nominal;
        System.out.println("Transfer ke : " + tujuan.getNomorRekening() + " berhasil: Rp " + nominal + " | Sisa saldo: Rp " + saldo);
    }
}
