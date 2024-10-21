package jimfish.rsvp;

import com.zw.jimfish.rsvp.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
}
