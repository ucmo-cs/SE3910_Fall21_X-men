import com.example.commerce.repository.JPACubicleRepository;
import com.example.commerce.repository.JPAReservationRepository;
import com.example.commerce.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CancelController
{
    @GetMapping("main/cancel")
    public String login(){
        return "commerce/user-cancel";
    }

    private final JPACubicleRepository cubicleRepository;
    private final JPAReservationRepository reservationRepository;
    private final ReservationService reservationService;

    public CancelController(JPACubicleRepository cubicleRepository, JPAReservationRepository reservationRepository, ReservationService reservationService) {
        this.cubicleRepository = cubicleRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }
}


