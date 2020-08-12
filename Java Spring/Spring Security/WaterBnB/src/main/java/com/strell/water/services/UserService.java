package com.strell.water.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.strell.water.models.Pool;
import com.strell.water.models.Review;
import com.strell.water.models.Role;
import com.strell.water.models.User;
import com.strell.water.repository.RoleRepository;
import com.strell.water.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public List<Role> allRole(){
    	return roleRepository.findAll();
    }
    // 1
    public void saveWithUserRole(User user) {
    	List<Pool> pool = new ArrayList<Pool>();
    	List<Review> rev = new ArrayList<Review>();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        user.setMyPools(pool);
        user.setReviews(rev);
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
    	List<Pool> pool = new ArrayList<Pool>();
    	List<Review> rev = new ArrayList<Review>();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        user.setMyPools(pool);
        user.setReviews(rev);
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String correo) {
        return userRepository.findByUsername(correo);
    }
}
