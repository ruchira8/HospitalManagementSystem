package com.ooad.service;

import com.ooad.dao.AdminDAO;
import com.ooad.dao.PatientDAO;
import com.ooad.dao.StaffDAO;
import com.ooad.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PatientDAO patientDAO;
    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private StaffDAO staffDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = patientDAO.findByUserName(userName);
        if (user == null) {
            user = adminDAO.findByUserName(userName);
            if (user == null) {
                user = staffDAO.findByUserName(userName);
                if (user == null) {
                    throw new UsernameNotFoundException("Username not found");
                }
            }
        }
        System.out.println(user.getUsername());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getType()));
        return authorities;
    }

}
