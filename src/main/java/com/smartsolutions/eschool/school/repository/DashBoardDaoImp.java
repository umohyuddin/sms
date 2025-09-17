package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DashBoardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DashBoardDaoImp implements DashBoardDao{

    private final JdbcTemplate jdbcTemplate;
    public DashBoardDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public DashBoardEntity getDashboard(String category, Long  id,String type, int year, int month) {
        DashBoardEntity dashBoardEntity = new DashBoardEntity();
        switch (category){
            case "campus":
                switch (type){
                    case "annually":
                        dashBoardEntity = getCampusByYear(id,year);
                        break;
                    case "monthly":
                        dashBoardEntity = getCampusByMonth(id,year,month);
                        break;
                }
                break;
            case "institute":
                switch (type){
                    case "annually":
                        dashBoardEntity = getInstituteByYear(id,year);
                        break;
                    case "monthly":
                        dashBoardEntity = getInstituteByMonth(id,year,month);
                        break;
                }
                break;
        }
        return dashBoardEntity;
    }

    @Override
    public DashBoardEntity getCampusByMonth( Long  id, int year, int month) {
        String sql = """
                    SELECT
                            COUNT(DISTINCT s.student_id) AS totalstudent,
                            COUNT(DISTINCT e.employee_id) AS totalemployee,
                            COALESCE(SUM(CASE WHEN f.status = 'Paid' THEN f.t_amount ELSE 0 END), 0) AS revenue,
                            COALESCE(SUM(CASE WHEN f.status != 'Paid' THEN f.t_amount ELSE 0 END), 0) AS remaining,
                            COALESCE(SUM(CASE WHEN sl.status = 'Paid' THEN sl.amount ELSE 0 END), 0) AS expenses,
                            COALESCE(SUM(CASE WHEN sl.status != 'Paid' THEN sl.amount ELSE 0 END), 0) AS remainingExpenses
                        FROM students s
                        INNER JOIN campuses c ON s.cmp_id = c.campus_id
                        LEFT JOIN employee e ON e.cmp_id = c.campus_id
                        LEFT JOIN fee f ON f.std_id = s.student_id AND f.year = :year AND f.month = :month
                        LEFT JOIN salary sl ON sl.emp_id = e.employee_id AND sl.year = :year AND sl.month = :month
                        WHERE c.campus_id = :cmpId
                    """;

        Tuple result = (Tuple) entityManager
                .createNativeQuery(sql, Tuple.class)
                .setParameter("cmpId", id)
                .setParameter("year", year)
                .setParameter("month", month)
                .getSingleResult();

        return mapToDashboardEntity(result);
    }

    @Override
    public DashBoardEntity getCampusByYear( Long  id, int year) {
        String sql = """
                    SELECT
                            COUNT(DISTINCT s.student_id) AS totalstudent,
                            COUNT(DISTINCT e.employee_id) AS totalemployee,
                            COALESCE(SUM(CASE WHEN f.status = 'Paid' THEN f.t_amount ELSE 0 END), 0) AS revenue,
                            COALESCE(SUM(CASE WHEN f.status != 'Paid' THEN f.t_amount ELSE 0 END), 0) AS remaining,
                            COALESCE(SUM(CASE WHEN sl.status = 'Paid' THEN sl.amount ELSE 0 END), 0) AS expenses,
                            COALESCE(SUM(CASE WHEN sl.status != 'Paid' THEN sl.amount ELSE 0 END), 0) AS remainingExpenses
                        FROM students s
                        INNER JOIN campuses c ON s.cmp_id = c.campus_id
                        LEFT JOIN employee e ON e.cmp_id = c.campus_id
                        LEFT JOIN fee f ON f.std_id = s.student_id AND f.year = :year
                        LEFT JOIN salary sl ON sl.emp_id = e.employee_id AND sl.year = :year
                        WHERE c.campus_id = :cmpId
                    """;

        Tuple result = (Tuple) entityManager
                .createNativeQuery(sql, Tuple.class)
                .setParameter("cmpId", id)
                .setParameter("year", year)
                .getSingleResult();

        return mapToDashboardEntity(result);
    }

    @Override
    public DashBoardEntity getInstituteByMonth( Long  id, int year, int month) {
        String sql = """
                    SELECT
                            COUNT(DISTINCT s.student_id) AS totalstudent,
                            COUNT(DISTINCT e.employee_id) AS totalemployee,
                            COALESCE(SUM(CASE WHEN f.status = 'Paid' THEN f.t_amount ELSE 0 END), 0) AS revenue,
                            COALESCE(SUM(CASE WHEN f.status != 'Paid' THEN f.t_amount ELSE 0 END), 0) AS remaining,
                            COALESCE(SUM(CASE WHEN sl.status = 'Paid' THEN sl.amount ELSE 0 END), 0) AS expenses,
                            COALESCE(SUM(CASE WHEN sl.status != 'Paid' THEN sl.amount ELSE 0 END), 0) AS remainingExpenses
                        FROM students s
                        INNER JOIN campuses c ON s.cmp_id = c.campus_id
                        LEFT JOIN employee e ON e.cmp_id = c.campus_id
                        LEFT JOIN fee f ON f.std_id = s.student_id AND f.year = :year AND f.month = :month
                        LEFT JOIN salary sl ON sl.emp_id = e.employee_id AND sl.year = :year AND sl.month = :month
                        WHERE c.inst_id = :instId
                    """;

        Tuple result = (Tuple) entityManager
                .createNativeQuery(sql, Tuple.class)
                .setParameter("instId", id)
                .setParameter("year", year)
                .setParameter("month", month)
                .getSingleResult();

        return mapToDashboardEntity(result);
    }

    @Override
    public DashBoardEntity getInstituteByYear( Long  id, int year) {
        String sql = """
                    SELECT
                            COUNT(DISTINCT s.student_id) AS totalstudent,
                            COUNT(DISTINCT e.employee_id) AS totalemployee,
                            COALESCE(SUM(CASE WHEN f.status = 'Paid' THEN f.t_amount ELSE 0 END), 0) AS revenue,
                            COALESCE(SUM(CASE WHEN f.status != 'Paid' THEN f.t_amount ELSE 0 END), 0) AS remaining,
                            COALESCE(SUM(CASE WHEN sl.status = 'Paid' THEN sl.amount ELSE 0 END), 0) AS expenses,
                            COALESCE(SUM(CASE WHEN sl.status != 'Paid' THEN sl.amount ELSE 0 END), 0) AS remainingExpenses
                        FROM students s
                        INNER JOIN campuses c ON s.cmp_id = c.campus_id
                        LEFT JOIN employee e ON e.cmp_id = c.campus_id
                        LEFT JOIN fee f ON f.std_id = s.student_id AND f.year = :year
                        LEFT JOIN salary sl ON sl.emp_id = e.employee_id AND sl.year = :year
                        WHERE c.inst_id = :instId
                    """;

        Tuple result = (Tuple) entityManager
                .createNativeQuery(sql, Tuple.class)
                .setParameter("instId", id)
                .setParameter("year", year)
                .getSingleResult();

        return mapToDashboardEntity(result);
    }

    private DashBoardEntity mapToDashboardEntity(Tuple tuple) {

        DashBoardEntity dashBoardEntity = new DashBoardEntity();
        dashBoardEntity.setTotalStudents(((Number)tuple.get("totalstudent")).intValue());
        dashBoardEntity.setTotalEmployees(((Number)tuple.get("totalemployee")).intValue());
        dashBoardEntity.setRevenue(((Number) tuple.get("revenue")).longValue());
        dashBoardEntity.setRemaining(((Number) tuple.get("remaining")).longValue());
        dashBoardEntity.setExpenses(((Number) tuple.get("expenses")).longValue());
        dashBoardEntity.setRemainingExpenses(((Number) tuple.get("remainingExpenses")).longValue());
        return dashBoardEntity;
    }
}
