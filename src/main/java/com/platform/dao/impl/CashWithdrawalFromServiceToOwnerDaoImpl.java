package com.platform.dao.impl;

import com.platform.dao.CashWithdrawalFromServiceToOwnerDao;
import com.platform.domain.CashWithdrawalFromServiceToOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CashWithdrawalFromServiceToOwnerDaoImpl implements CashWithdrawalFromServiceToOwnerDao {
    private static final String FIND_ALL = "SELECT * FROM cash_withdrawal_from_service_to_owner";
    private static final String CREATE = "INSERT cash_withdrawal_from_service_to_owner(price,"
    		+ "cash_withdrawal_from_lessee_to_service_id) VALUES (?,?)";
    private static final String UPDATE = "UPDATE cash_withdrawal_from_service_to_owner SET price=?,"
    		+ "cash_withdrawal_from_lessee_to_service_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM cash_withdrawal_from_service_to_owner WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM cash_withdrawal_from_service_to_owner WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CashWithdrawalFromServiceToOwner> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(CashWithdrawalFromServiceToOwner.class));
    }

    @Override
    public Optional<CashWithdrawalFromServiceToOwner> findById(Integer id) {
        Optional<CashWithdrawalFromServiceToOwner> cashWithdrawalFromServiceToOwner;
        try {
        	cashWithdrawalFromServiceToOwner = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(CashWithdrawalFromServiceToOwner.class), id));
        } catch (EmptyResultDataAccessException e) {
        	cashWithdrawalFromServiceToOwner = Optional.empty();
        }
        return cashWithdrawalFromServiceToOwner;
    }

    @Override
    public int create(CashWithdrawalFromServiceToOwner cashWithdrawalFromServiceToOwner) {
        return jdbcTemplate.update(CREATE, cashWithdrawalFromServiceToOwner.getPrice(),
        		cashWithdrawalFromServiceToOwner.getCashWithdrawalFromLesseeToServiceId());
    }

    @Override
    public int update(Integer id, CashWithdrawalFromServiceToOwner cashWithdrawalFromServiceToOwner) {
        return jdbcTemplate.update(UPDATE, cashWithdrawalFromServiceToOwner.getPrice(),
        		cashWithdrawalFromServiceToOwner.getCashWithdrawalFromLesseeToServiceId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
