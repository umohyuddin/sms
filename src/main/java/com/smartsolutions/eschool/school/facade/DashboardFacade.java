package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.model.DashBoardEntity;
import com.smartsolutions.eschool.school.service.DashBoardService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class DashboardFacade {
    private static final Log LOG = LogFactory.getLog(DashboardFacade.class);
    @Autowired
    @Lazy
    private final DashBoardService nDashBoardService;

    public DashboardFacade(DashBoardService pDashBoardService) {
        this.nDashBoardService = pDashBoardService;
    }


    public DashBoardEntity getDashboard(String category, Long  id, String type, int year, int month) {
        return nDashBoardService.getDashboard(category, id, type, year, month);
    }

}
