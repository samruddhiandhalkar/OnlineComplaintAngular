package Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
