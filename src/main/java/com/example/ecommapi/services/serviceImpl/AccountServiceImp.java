package com.example.ecommapi.services.serviceImpl;


import com.example.ecommapi.entities.User;
import com.example.ecommapi.repositories.UserRepo;
import com.example.ecommapi.services.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImp implements AccountService {
    private UserRepo userRepo;
    // private PasswordEncoder passwordEncoder;


    @Override
    public User addNewUser(String name, String username, String password, String confirmPassword, String email, String phoneNumber) {
        User user = userRepo.findByUsername(username);
        if(user != null) throw new RuntimeException("This user already exist");
        if(!password.equals(confirmPassword)) throw new RuntimeException("Passwords not match");
        User user1 = new User();
        user1.setName(name);
        user1.setUsername(username);
        user1.setEmail(email);
        user1.setPhoneNumber(phoneNumber);
        user1.setPassword(new BCryptPasswordEncoder().encode(password));

        User savedUser = userRepo.save(user1);
        return savedUser;
    }

    //@Override
    //public void addUserRole(String username, String role) {
        //    User user = userRepo.findByUsername(username);
      //      AppRole appRole = appRoleRepo.findById(role).orElse(null);
    //        user.getAppRoleCollection().add(appRole);
   // }

    //@Override
    //public void removeRoleFromUser(String username, String role) {
    //    User user = userRepo.findByUsername(username);
    //    AppRole appRole = appRoleRepo.findById(role).orElse(null);
//
    //    user.getAppRoleCollection().remove(appRole);
    //}

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
