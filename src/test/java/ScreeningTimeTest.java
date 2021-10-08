import com.cinemarcos.domain.valueobject.ScreeningTime;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ScreeningTimeTest {

    @Test
    void ignore_seconds_in_start_time() {
        LocalDateTime startTime = LocalDateTime.of(2021, Month.APRIL, 12, 22, 0, 45);

        ScreeningTime screeningTime = ScreeningTime.from(startTime);

        assertThat(screeningTime.startingTime()).isEqualTo(LocalDateTime.of(2021, Month.APRIL, 12, 22, 0));
    }
}
