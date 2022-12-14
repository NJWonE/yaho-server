package com.noh.yaho.member.query.repository;

import com.noh.yaho.member.query.data.WorkTimeData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WorkTimeDataRepository extends JpaRepository<WorkTimeData, Integer> {
    public List<WorkTimeData> findByMemberNoAndWorkStartTimeBetween(int memberNo, Date startDateTime, Date endDateTime);
}
