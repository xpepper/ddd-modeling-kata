import java.time.LocalDateTime;
import java.util.List;

public class ReserveSeatsForScreeningCommand {
    public final List<Integer> seats;
    public final LocalDateTime time;

    public ReserveSeatsForScreeningCommand(List<Integer> seats, LocalDateTime time) {
        this.seats = seats;
        this.time = time;
    }
}
