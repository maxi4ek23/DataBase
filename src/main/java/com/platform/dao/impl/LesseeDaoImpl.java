package com.platform.dao.impl;

import com.platform.dao.LesseeDao;
import com.platform.domain.Lessee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LesseeDaoImpl implements LesseeDao {
    private static final String FIND_ALL = "SELECT * FROM lessee";
    private static final String CREATE = "INSERT lessee(name,surname,platform_user_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE lessee SET name=?,surname=?,platform_user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lessee WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM lessee WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Lessee> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Lessee.class));
    }

    @Override
    public Optional<Lessee> findById(Integer id) {
        Optional<Lessee> lessee;
        try {
        	lessee = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Lessee.class), id));
        } catch (EmptyResultDataAccessException e) {
        	lessee = Optional.empty();
        }
        return lessee;
    }

    @Override
    public int create(Lessee lessee) {
        return jdbcTemplate.update(CREATE, lessee.getName(), lessee.getSurname(), lessee.getPlatformUserId());
    }

    @Override
    public int update(Integer id, Lessee lessee) {
        return jdbcTemplate.update(UPDATE, lessee.getName(), lessee.getSurname(), lessee.getPlatformUserId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
