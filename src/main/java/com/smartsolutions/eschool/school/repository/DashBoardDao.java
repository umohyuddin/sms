package com.smartsolutions.eschool.school.repository;
import com.smartsolutions.eschool.school.model.DashBoardEntity;


public interface DashBoardDao {
    DashBoardEntity getDashboard(String category, Long  id, String type, int year, int month);
    DashBoardEntity getCampusByMonth( Long  id, int year, int month);
    DashBoardEntity getCampusByYear( Long  id, int year);
    DashBoardEntity getInstituteByMonth( Long  id, int year, int month);
    DashBoardEntity getInstituteByYear( Long  id, int year);
}
