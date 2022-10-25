package com.platform.dao.impl;

import com.platform.dao.AdressDao;
import com.platform.domain.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdressDaoImpl implements AdressDao {
    private static final String FIND_ALL = "SELECT * FROM adress";
    private static final String CREATE = "INSERT adress(street,house_number,city_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE adress SET street=?,house_number=?,city_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM adress WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM adress WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Adress> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Adress.class));
    }

    @Override
    public Optional<Adress> findById(Integer id) {
        Optional<Adress> adress;
        try {
        	adress = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Adress.class), id));
        } catch (EmptyResultDataAccessException e) {
        	adress = Optional.empty();
        }
        return adress;
    }

    @Override
    public int create(Adress adress) {
        return jdbcTemplate.update(CREATE, adress.getStreet(), adress.getHouseNumber(), adress.getCityId());
    }

    @Override
    public int update(Integer id, Adress adress) {
        return jdbcTemplate.update(UPDATE, adress.getStreet(), adress.getHouseNumber(),
        		adress.getCityId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
