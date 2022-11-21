package com.platform.dao.impl;

import com.platform.dao.DwellingOwnerDao;
import com.platform.domain.DwellingOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DwellingOwnerDaoImpl implements DwellingOwnerDao {
    private static final String FIND_ALL = "SELECT * FROM dwelling_owner";
    private static final String CREATE = "INSERT dwelling_owner(name,surname,platform_user_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE dwelling_owner SET name=?,surname=?,platform_user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dwelling_owner WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM dwelling_owner WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DwellingOwner> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(DwellingOwner.class));
    }

    @Override
    public Optional<DwellingOwner> findById(Integer id) {
        Optional<DwellingOwner> dwellingOwner;
        try {
        	dwellingOwner = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(DwellingOwner.class), id));
        } catch (EmptyResultDataAccessException e) {
        	dwellingOwner = Optional.empty();
        }
        return dwellingOwner;
    }

    @Override
    public int create(DwellingOwner dwellingOwner) {
        return jdbcTemplate.update(CREATE, dwellingOwner.getName(), dwellingOwner.getSurname(),
        		dwellingOwner.getPlatformUserId());
    }

    @Override
    public int update(Integer id, DwellingOwner dwellingOwner) {
        return jdbcTemplate.update(UPDATE, dwellingOwner.getName(), dwellingOwner.getSurname(),
        		dwellingOwner.getPlatformUserId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
