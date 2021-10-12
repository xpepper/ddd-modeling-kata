import java.time.LocalDateTime;
import java.util.List;

public class ReserveSeatsCommand {
    public final List<Integer> seats;
    public final LocalDateTime time;

    public ReserveSeatsCommand(List<Integer> seats, LocalDateTime time) {
        this.seats = seats;
        this.time = time;
    }
}
