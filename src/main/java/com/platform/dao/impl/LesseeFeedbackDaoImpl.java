package com.platform.dao.impl;

import com.platform.dao.LesseeFeedbackDao;
import com.platform.domain.LesseeFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LesseeFeedbackDaoImpl implements LesseeFeedbackDao {
    private static final String FIND_ALL = "SELECT * FROM lessee_feedback";
    private static final String CREATE = "INSERT lessee_feedback(rating,response,lessee_id)"
    		+ " VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE lessee_feedback SET rating=?,response=?,"
    		+ "lessee_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lessee_feedback WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM lessee_feedback WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LesseeFeedback> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(LesseeFeedback.class));
    }

    @Override
    public Optional<LesseeFeedback> findById(Integer id) {
        Optional<LesseeFeedback> lesseeFeedback;
        try {
        	lesseeFeedback = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(LesseeFeedback.class), id));
        } catch (EmptyResultDataAccessException e) {
        	lesseeFeedback = Optional.empty();
        }
        return lesseeFeedback;
    }

    @Override
    public int create(LesseeFeedback lesseeFeedback) {
        return jdbcTemplate.update(CREATE, lesseeFeedback.getRating(), lesseeFeedback.getResponse(),
        		lesseeFeedback.getLesseeId());
    }

    @Override
    public int update(Integer id, LesseeFeedback lesseeFeedback) {
        return jdbcTemplate.update(UPDATE, lesseeFeedback.getRating(), lesseeFeedback.getResponse(),
        		lesseeFeedback.getLesseeId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
