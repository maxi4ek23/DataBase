package com.platform.dao.impl;

import com.platform.dao.DwellingDao;
import com.platform.domain.Dwelling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DwellingDaoImpl implements DwellingDao {
    private static final String FIND_ALL = "SELECT * FROM dwelling";
    private static final String CREATE = "INSERT dwelling(area,floor,rooms_number,description,adress_id,"
    		+ "dwelling_owner_id,reservation_id) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE dwelling SET area=?,floor=?,rooms_number=?,description=?,"
    		+ "adress_id=?,dwelling_owner_id=?,reservation_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dwelling WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM dwelling WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Dwelling> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Dwelling.class));
    }

    @Override
    public Optional<Dwelling> findById(Integer id) {
        Optional<Dwelling> dwelling;
        try {
        	dwelling = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Dwelling.class), id));
        } catch (EmptyResultDataAccessException e) {
        	dwelling = Optional.empty();
        }
        return dwelling;
    }

    @Override
    public int create(Dwelling dwelling) {
        return jdbcTemplate.update(CREATE, dwelling.getArea(), dwelling.getFloor(),
        		dwelling.getRoomsNumber(), dwelling.getDescription(), dwelling.getAdressId(),
        		dwelling.getDwellingOwnerId(), dwelling.getReservationId());
    }

    @Override
    public int update(Integer id, Dwelling dwelling) {
        return jdbcTemplate.update(UPDATE, dwelling.getArea(), dwelling.getFloor(),
        		dwelling.getRoomsNumber(), dwelling.getDescription(), dwelling.getAdressId(),
        		dwelling.getDwellingOwnerId(), dwelling.getReservationId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
