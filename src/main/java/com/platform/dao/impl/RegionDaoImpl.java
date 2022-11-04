package com.platform.dao.impl;

import com.platform.dao.RegionDao;
import com.platform.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RegionDaoImpl implements RegionDao {
    private static final String FIND_ALL = "SELECT * FROM region";
    private static final String CREATE = "INSERT region(name) VALUES (?)";
    private static final String UPDATE = "UPDATE region SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM region WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM region WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Region> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Region.class));
    }

    @Override
    public Optional<Region> findById(Integer id) {
        Optional<Region> region;
        try {
            region = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Region.class), id));
        } catch (EmptyResultDataAccessException e) {
            region = Optional.empty();
        }
        return region;
    }

    @Override
    public int create(Region region) {
        return jdbcTemplate.update(CREATE, region.getName());
    }

    @Override
    public int update(Integer id, Region region) {
        return jdbcTemplate.update(UPDATE, region.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
