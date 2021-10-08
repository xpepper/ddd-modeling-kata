import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public interface Screenings {
    Screening byTime(LocalDateTime time);
}
