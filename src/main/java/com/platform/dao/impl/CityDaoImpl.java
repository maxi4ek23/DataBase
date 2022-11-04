package com.platform.dao.impl;

import com.platform.dao.CityDao;
import com.platform.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityDaoImpl implements CityDao {
    private static final String FIND_ALL = "SELECT * FROM city";
    private static final String CREATE = "INSERT city(name,population,region_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE city SET name=?,population=?,region_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM city WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM city WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<City> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(City.class));
    }

    @Override
    public Optional<City> findById(Integer id) {
        Optional<City> city;
        try {
            city = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(City.class), id));
        } catch (EmptyResultDataAccessException e) {
            city = Optional.empty();
        }
        return city;
    }

    @Override
    public int create(City city) {
        return jdbcTemplate.update(CREATE, city.getName(), city.getPopulation(), city.getRegionId());
    }

    @Override
    public int update(Integer id, City city) {
        return jdbcTemplate.update(UPDATE, city.getName(), city.getPopulation(), city.getRegionId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}