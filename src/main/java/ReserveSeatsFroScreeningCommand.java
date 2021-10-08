import java.time.LocalDateTime;
import java.util.List;

public class ReserveSeatsFroScreeningCommand {
    public final List<Integer> seats;
    public final LocalDateTime time;

    public ReserveSeatsFroScreeningCommand(List<Integer> seats, LocalDateTime time) {
        this.seats = seats;
        this.time = time;
    }
}
