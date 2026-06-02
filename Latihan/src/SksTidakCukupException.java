// Soal 3: Custom Exception bertipe Unchecked
public class SksTidakCukupException extends RuntimeException {
    public SksTidakCukupException(String pesan) {
        super(pesan);
    }
}
