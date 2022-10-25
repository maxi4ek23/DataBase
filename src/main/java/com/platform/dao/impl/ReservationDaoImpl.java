package com.platform.dao.impl;

import com.platform.dao.ReservationDao;
import com.platform.domain.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationDaoImpl implements ReservationDao {
    private static final String FIND_ALL = "SELECT * FROM reservation";
    private static final String CREATE = "INSERT reservation(is_possible,name,time,how_long,is_confirmed,lessee_id) "
    		+ "VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE reservation SET is_possible=?,name=?,time=?,how_long=?,"
    		+ "is_confirmed=?,lessee_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM reservation WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM reservation WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Reservation> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Reservation.class));
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        Optional<Reservation> reservation;
        try {
        	reservation = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Reservation.class), id));
        } catch (EmptyResultDataAccessException e) {
        	reservation = Optional.empty();
        }
        return reservation;
    }

    @Override
    public int create(Reservation reservation) {
        return jdbcTemplate.update(CREATE, reservation.getIsPossible(), reservation.getName(),
        		reservation.getTime(), reservation.getHowLong(), reservation.getIsConfirmed(),
        		reservation.getLesseeId());
    }

    @Override
    public int update(Integer id, Reservation reservation) {
        return jdbcTemplate.update(UPDATE, reservation.getIsPossible(), reservation.getName(),
        		reservation.getTime(), reservation.getHowLong(), reservation.getIsConfirmed(),
        		reservation.getLesseeId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
