package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HerokuAppExpectedDataPojo {
    private int bookingid;
    private BookingPojo booking;
}
