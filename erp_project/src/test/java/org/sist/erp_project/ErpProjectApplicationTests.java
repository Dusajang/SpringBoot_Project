package org.sist.erp_project;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.sist.erp_project.consultationSchedule.CenterType;
import org.sist.erp_project.consultationSchedule.ConsultationSchedule;
import org.sist.erp_project.consultationSchedule.ConsultationScheduleRepository;
import org.sist.erp_project.consultationSchedule.EduKind;
import org.sist.erp_project.consultationSchedule.Edutype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ErpProjectApplicationTests {

	@Autowired
    private ConsultationScheduleRepository consultationScheduleRepository;

    @Test
    void testInsertMultipleConsultationSchedules() {
        // Step 1: 115개의 더미 데이터 생성 및 저장
        for (int i = 1; i <= 115; i++) {
            ConsultationSchedule schedule = new ConsultationSchedule();
            
            // 기본 데이터 설정
            schedule.setName("테스트 사용자 " + i); // 이름에 번호 추가
            schedule.setPassword("password" + i + "123"); // 비밀번호에 번호 추가
            schedule.setCell("010-1234-" + String.format("%04d", i)); // 번호를 고유하게
            schedule.setEmail("user" + i + "@example.com"); // 이메일 고유화
            schedule.setEdutype(i % 2 == 0 ? Edutype.MAJOR : Edutype.NON_MAJOR); // 전공 여부를 홀짝으로 설정
            schedule.setCenter(i % 2 == 0 ? CenterType.GANGNAM : CenterType.GANGBUK); // 지점을 홀짝으로 설정
            schedule.setEduKind(i % 3 == 0 ? EduKind.EMPLOYED : (i % 3 == 1 ? EduKind.JOB_SEEKER : EduKind.OTHER)); // 교육 과정을 순환적으로 설정
            
            // 날짜와 시간 설정
            schedule.setReservationDate(LocalDate.now().plusDays(i)); // 예약 날짜를 매번 다르게 설정
            schedule.setReservationTime(LocalTime.of(9 + (i % 8), 0)); // 예약 시간을 9시부터 순환적으로 설정

            schedule.setEtc("테스트 데이터 " + i + "에 대한 설명입니다."); // 기타 설명

            // 저장
            ConsultationSchedule savedSchedule = consultationScheduleRepository.save(schedule);

            // Step 2: 데이터 검증
            /*
            assertNotNull(savedSchedule.getId()); // ID가 null이 아닌지 확인
            assertEquals("테스트 사용자 " + i, savedSchedule.getName()); // 이름 확인
            assertEquals("password" + i + "123", savedSchedule.getPassword()); // 비밀번호 확인
            assertEquals("010-1234-" + String.format("%04d", i), savedSchedule.getCell()); // 휴대폰 번호 확인
            assertEquals("user" + i + "@example.com", savedSchedule.getEmail()); // 이메일 확인
            assertEquals(i % 2 == 0 ? Edutype.MAJOR : Edutype.NON_MAJOR, savedSchedule.getEdutype()); // 전공 여부 확인
            assertEquals(i % 2 == 0 ? CenterType.GANGNAM : CenterType.GANGBUK, savedSchedule.getCenter()); // 지점 확인
            assertEquals(i % 3 == 0 ? EduKind.EMPLOYED : (i % 3 == 1 ? EduKind.JOB_SEEKER : EduKind.OTHER), savedSchedule.getEduKind()); // 교육 과정 확인
            assertEquals(LocalDate.now().plusDays(i), savedSchedule.getReservationDate()); // 예약 날짜 확인
            assertEquals(LocalTime.of(9 + (i % 8), 0), savedSchedule.getReservationTime()); // 예약 시간 확인
            assertEquals("확인", savedSchedule.getReservationStatus()); // 기본값 확인
            assertEquals(false, savedSchedule.getIsCanceled()); // 예약 취소 기본값 확인
            assertEquals("테스트 데이터 " + i + "에 대한 설명입니다.", savedSchedule.getEtc()); // 기타 설명 확인
            */
        }
    }

}
