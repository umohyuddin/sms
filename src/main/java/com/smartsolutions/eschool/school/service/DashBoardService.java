package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.model.DashBoardEntity;
import com.smartsolutions.eschool.school.repository.DashBoardDao;
import org.springframework.stereotype.Service;


@Service
public class DashBoardService {
    private final DashBoardDao nDashBoardDao;

    public DashBoardService(DashBoardDao pDashBoardDao) {
        this.nDashBoardDao = pDashBoardDao;
    }
    public DashBoardEntity getDashboard(String category, Long  id, String type, int year, int month) {
        return nDashBoardDao.getDashboard(category, id, type, year, month);
    }
}
