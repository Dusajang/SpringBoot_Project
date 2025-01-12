package org.sist.erp_project.consultationSchedule;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationScheduleRepository extends JpaRepository<ConsultationSchedule, Integer> {

	// 페이징 처리 ( ***암기 )
	Page<ConsultationSchedule> findAll(Pageable pageable);
}
