package com.getsmarter.LearnSpringBoot.service;

import com.getsmarter.LearnSpringBoot.dto.AdminCreate;
import com.getsmarter.LearnSpringBoot.dto.UserDTO;
import com.getsmarter.LearnSpringBoot.entity.Role;
import com.getsmarter.LearnSpringBoot.entity.User;
import com.getsmarter.LearnSpringBoot.exception.UserNotFoundException;
import com.getsmarter.LearnSpringBoot.repository.RoleRepository;
import com.getsmarter.LearnSpringBoot.repository.UserRepository;
import com.getsmarter.LearnSpringBoot.service.implement.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;


    //Enregistrer un utilisateur
    @Override
    public UserDTO saveUser(User user) {
        user.setCreated_at(LocalDateTime.now());
        return convertEntityToDto(this.userRepository.save(user));
    }

    @Override
    public AdminCreate createAdmin(AdminCreate adminCreate) {

        Role role = roleRepository.findById(6L).get();
        List<Role> roles = new ArrayList<>();
        roles.add(role);

        User user = new User();
        user.setEmail(adminCreate.getEmail());
        user.setFirstname(adminCreate.getFirstname());
        user.setLastname(adminCreate.getLastname());
        user.setPassword(passwordEncoder.encode(adminCreate.getPassword()));
        user.setPhoneNumber(adminCreate.getPhoneNumber());
        user.setRoles(roles);
        user.setCreated_at(LocalDateTime.now());

        userRepository.save(user);
        return adminCreate;
    }


    //Afficher tous les utilisateurs
    @Override
    public List<UserDTO> getAllUser() {
        return this.userRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


    //Afficher un utilisateur par son id
    @Override
    public UserDTO getUser(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new UserNotFoundException("Utilisateur ayant l'id " + id+ " pas trouvé!"));
        return convertEntityToDto(user);
    }


    //MAJ des données d'un utilisateur
    @Override
    public UserDTO updateUser(Long id, User user) {
        UserDTO userUpdate = this.getUser(id);

        if (userUpdate.getId() == user.getId()) {
            userUpdate.setPhoto(user.getPhoto());
            userUpdate.setFirstname(user.getFirstname());
            userUpdate.setLastname(user.getLastname());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(userUpdate.getPassword());
            userUpdate.setPhoneNumber(user.getPhoneNumber());
            userUpdate.setCreated_at(LocalDateTime.now());
            this.userRepository.save(convertDtoToEntity(userUpdate));
            return userUpdate;
        }

        return userUpdate;
    }


    //Suppression de tous les utilisateurs
    @Override
    public void deleteUser() {
        this.userRepository.deleteAll();
    }


    //Suppression d'un utilisateur par id
    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }


    //Conversion d'un utilisateur en utilisateurDTO
    @Override
    public UserDTO convertEntityToDto(User u) {
        return UserDTO.builder()
                .id(u.getId())
                .firstname(u.getFirstname())
                .lastname(u.getLastname())
                .email(u.getEmail())
                .password(u.getPassword())
                .phoneNumber(u.getPhoneNumber())
                .build();
    }



    public User convertDtoToEntity(UserDTO u) {
        User user = new User();

        user.setId(u.getId());
        user.setPhoto(u.getPhoto());
        user.setFirstname(u.getFirstname());
        user.setLastname(u.getLastname());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        user.setPhoneNumber(u.getPhoneNumber());
        user.setCreated_at(LocalDateTime.now());
        return user;
    }


}
