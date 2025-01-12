package org.sist.erp_project.consultationSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultationScheduleService {

    private final ConsultationScheduleRepository consultationScheduleRepository;
    
    // 상담 신청 처리...
    public void saveSchedule(ConsultationSchedule consultationSchedule) {
        // 예약 상태 기본값 처리
        if (consultationSchedule.getReservationStatus() == null) {
            consultationSchedule.setReservationStatus(ReservationStatus.CONFIRMED);
        }
        consultationScheduleRepository.save(consultationSchedule);
    }

    //페이징 처리 X
    public List<ConsultationSchedule> getAllSchedules() {
        return consultationScheduleRepository.findAll();
    }
    
    // 페이징 처리 + 목록 / 1번 페이지를 주고 싶으면 0을 줘야된다.
 	public Page<ConsultationSchedule> getList(int page) {
 								// pageNumber : 현재 페이지, pageSize : 한 페이지에 몇개
 		// 		Pageable pageable = PageRequest.of(page, 10);
 		
 		List<Sort.Order> sorts = new ArrayList<>();
 		
 		sorts.add(Sort.Order.desc("id"));
 		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
 		return this.consultationScheduleRepository.findAll(pageable);
 	} //
 	
 	// id에 해당하는 상담자 상세정보
 	public ConsultationSchedule getSchedule(Integer id) {
 		Optional<ConsultationSchedule> oCon = this.consultationScheduleRepository.findById(id);
 		return oCon.get();
 	} //
 	
 	//아이디로 조회..(1개)
 	public Optional<ConsultationSchedule> getScheduleById(Integer id) {
 	    return consultationScheduleRepository.findById(id);
 	}
 	
 	public void save(ConsultationSchedule schedule) {
 	    consultationScheduleRepository.save(schedule);
 	}
 	
 	// 기존 데이터 업데이트 메서드
 	public void updateSchedule(ConsultationSchedule existingSchedule, ConsultationSchedule updatedSchedule) {
 	    existingSchedule.setName(updatedSchedule.getName());
 	    existingSchedule.setEmail(updatedSchedule.getEmail());
 	    existingSchedule.setTel(updatedSchedule.getTel());
 	    existingSchedule.setReservationDate(updatedSchedule.getReservationDate());
 	    existingSchedule.setReservationTime(updatedSchedule.getReservationTime());
 	    existingSchedule.setEtc(updatedSchedule.getEtc());
 	    existingSchedule.setCenter(updatedSchedule.getCenter());
 	}
 	
 	// 삭제 처리..
 	public void deleteById(Integer id) {
        consultationScheduleRepository.deleteById(id);
    }
 	
 	// 예약 상태를 '취소'로 업데이트하는 메서드
    public void cancelReservation(Integer id) {
    	Optional<ConsultationSchedule> optionalSchedule = consultationScheduleRepository.findById(id);
        
        if (!optionalSchedule.isPresent()) {
            throw new IllegalArgumentException("Invalid consultation schedule ID: " + id);
        }

        ConsultationSchedule schedule = optionalSchedule.get();

        // 예약 상태를 '취소'로 변경
        schedule.setReservationStatus(ReservationStatus.CANCELED);

        // 변경된 상태를 저장
        consultationScheduleRepository.save(schedule);
    }
 	
}
