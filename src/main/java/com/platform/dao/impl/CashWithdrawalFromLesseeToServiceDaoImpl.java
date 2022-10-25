package com.platform.dao.impl;

import com.platform.dao.CashWithdrawalFromLesseeToServiceDao;
import com.platform.domain.CashWithdrawalFromLesseeToService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CashWithdrawalFromLesseeToServiceDaoImpl implements CashWithdrawalFromLesseeToServiceDao {
    private static final String FIND_ALL = "SELECT * FROM cash_withdrawal_from_lessee_to_service";
    private static final String CREATE = "INSERT cash_withdrawal_from_lessee_to_service(price,reservation_id) VALUES (?,?)";
    private static final String UPDATE = "UPDATE cash_withdrawal_from_lessee_to_service SET price=?,"
    		+ "reservation_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM cash_withdrawal_from_lessee_to_service WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM cash_withdrawal_from_lessee_to_service WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CashWithdrawalFromLesseeToService> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(CashWithdrawalFromLesseeToService.class));
    }

    @Override
    public Optional<CashWithdrawalFromLesseeToService> findById(Integer id) {
        Optional<CashWithdrawalFromLesseeToService> cashWithdrawalFromLesseeToService;
        try {
        	cashWithdrawalFromLesseeToService = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(CashWithdrawalFromLesseeToService.class), id));
        } catch (EmptyResultDataAccessException e) {
        	cashWithdrawalFromLesseeToService = Optional.empty();
        }
        return cashWithdrawalFromLesseeToService;
    }

    @Override
    public int create(CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService) {
        return jdbcTemplate.update(CREATE, cashWithdrawalFromLesseeToService.getPrice(),
        		cashWithdrawalFromLesseeToService.getReservationId());
    }

    @Override
    public int update(Integer id, CashWithdrawalFromLesseeToService cashWithdrawalFromLesseeToService) {
        return jdbcTemplate.update(UPDATE, cashWithdrawalFromLesseeToService.getPrice(),
        		cashWithdrawalFromLesseeToService.getReservationId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
