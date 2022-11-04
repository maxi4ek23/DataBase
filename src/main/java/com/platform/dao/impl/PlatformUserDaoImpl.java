package com.platform.dao.impl;

import com.platform.dao.PlatformUserDao;
import com.platform.domain.PlatformUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlatformUserDaoImpl implements PlatformUserDao {
    private static final String FIND_ALL = "SELECT * FROM platform_user";
    private static final String CREATE = "INSERT platform_user(email,phone) VALUES (?,?)";
    private static final String UPDATE = "UPDATE platform_user SET email=?,phone=? WHERE id=?";
    private static final String DELETE = "DELETE FROM platform_user WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM platform_user WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PlatformUser> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(PlatformUser.class));
    }

    @Override
    public Optional<PlatformUser> findById(Integer id) {
        Optional<PlatformUser> platformUser;
        try {
        	platformUser = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(PlatformUser.class), id));
        } catch (EmptyResultDataAccessException e) {
        	platformUser = Optional.empty();
        }
        return platformUser;
    }

    @Override
    public int create(PlatformUser platformUser) {
        return jdbcTemplate.update(CREATE, platformUser.getEmail(), platformUser.getPhone());
    }

    @Override
    public int update(Integer id, PlatformUser platformUser) {
        return jdbcTemplate.update(UPDATE, platformUser.getEmail(), platformUser.getPhone(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
