import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepository {
    Screening byTime(LocalDateTime time);
}
