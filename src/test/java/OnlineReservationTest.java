import com.cinemarcos.domain.OnlineReservation;
import com.cinemarcos.domain.valueobject.Screening;
import com.cinemarcos.domain.valueobject.TimeInterval;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlineReservationTest {

    @Test
    void the_system_lists_movies_available_in_the_given_time_interval() {
        OnlineReservation reservation = new OnlineReservation();

        LocalDateTime starting = LocalDateTime.now();
        LocalDateTime ending = LocalDateTime.now().plusMonths(10);

        TimeInterval timeInterval = TimeInterval.between(starting, ending);

        List<Screening> availableScreenings = reservation.availableMoviesAt(timeInterval);

        assertThat(availableScreenings).isNotEmpty();
    }
}
