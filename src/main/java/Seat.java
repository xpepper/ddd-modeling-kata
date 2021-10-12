import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Seat {
    final int seatNumber;
    private boolean isReserved;

    public Seat(int seatNumber, boolean isReserved) {
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        return new EqualsBuilder().append(seatNumber, seat.seatNumber).append(isReserved, seat.isReserved).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(seatNumber).append(isReserved).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("seatNumber", seatNumber)
            .append("isReserved", isReserved)
            .toString();
    }
}
