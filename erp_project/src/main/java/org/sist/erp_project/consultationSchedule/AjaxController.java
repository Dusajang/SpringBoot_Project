package org.sist.erp_project.consultationSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AjaxController {

    private final ConsultationScheduleService consultationScheduleService;

    @GetMapping("/api/reserved-times")
    public List<String> getReservedTimes(@RequestParam("date") String date) {
        System.out.println("Received date: " + date);

        // 날짜 형식이 LocalDate인지 확인
        List<ConsultationSchedule> schedules = consultationScheduleService.getAllSchedules();

        return schedules.stream()
                .peek(schedule -> System.out.println("Fetched Date: " + schedule.getReservationDate()))
                .filter(schedule -> {
                    // 날짜 비교 로직
                    if (schedule.getReservationDate() instanceof LocalDate) {
                        return schedule.getReservationDate().isEqual(LocalDate.parse(date));
                    } else {
                        return schedule.getReservationDate().equals(date);
                    }
                })
                .map(schedule -> schedule.getReservationTime().toString()) // 시간 반환
                .collect(Collectors.toList());
    }
}

