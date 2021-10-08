import java.time.LocalDateTime;
import java.util.List;

public interface Seats {
    Boolean reserveAt(LocalDateTime time, List<Integer> seats, Customer customer);
}
