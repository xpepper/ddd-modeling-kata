import java.util.List;

public class ScreeningSeatsReserved extends Event {
    public final List<Integer> seatNumbers;

    public ScreeningSeatsReserved(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}
