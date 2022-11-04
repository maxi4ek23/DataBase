package com.platform.dao.impl;

import com.platform.dao.OwnerFeedbackDao;
import com.platform.domain.OwnerFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OwnerFeedbackDaoImpl implements OwnerFeedbackDao {
    private static final String FIND_ALL = "SELECT * FROM owner_feedback";
    private static final String CREATE = "INSERT owner_feedback(rating,response,dwelling_owner_id)"
    		+ " VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE owner_feedback SET rating=?,response=?,"
    		+ "dwelling_owner_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM owner_feedback WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM owner_feedback WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OwnerFeedback> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(OwnerFeedback.class));
    }

    @Override
    public Optional<OwnerFeedback> findById(Integer id) {
        Optional<OwnerFeedback> ownerFeedback;
        try {
        	ownerFeedback = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(OwnerFeedback.class), id));
        } catch (EmptyResultDataAccessException e) {
        	ownerFeedback = Optional.empty();
        }
        return ownerFeedback;
    }

    @Override
    public int create(OwnerFeedback ownerFeedback) {
        return jdbcTemplate.update(CREATE, ownerFeedback.getRating(), ownerFeedback.getResponse(),
        		ownerFeedback.getDwellingOwnerId());
    }

    @Override
    public int update(Integer id, OwnerFeedback ownerFeedback) {
        return jdbcTemplate.update(UPDATE, ownerFeedback.getRating(), ownerFeedback.getResponse(),
        		ownerFeedback.getDwellingOwnerId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
