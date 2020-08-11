package com.ppcomp.server.repository;

import com.ppcomp.server.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface  NoticeRepository extends JpaRepository<Notice, String> {
    List<Notice> findBySite(List<String> site);
}
