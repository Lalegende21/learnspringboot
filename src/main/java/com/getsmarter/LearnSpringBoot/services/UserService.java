package com.getsmarter.LearnSpringBoot.services;

import com.getsmarter.LearnSpringBoot.dto.UserDTO;
import com.getsmarter.LearnSpringBoot.entity.User;
import com.getsmarter.LearnSpringBoot.repository.UserRepository;
import com.getsmarter.LearnSpringBoot.services.exception.UserNotFoundException;
import com.getsmarter.LearnSpringBoot.services.implement.UserServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //Enregistrer un utilisateur
    @Override
    public UserDTO saveUser(User user) {
        user.setCreated_at(LocalDateTime.now());
        return convertEntityToDto(this.userRepository.save(user));
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
    public User updateUser(Long id, User user) {
//        User userUpdate = this.getUser(id);
//
//        if (userUpdate.getId() == user.getId()) {
//            userUpdate.setPhoto(user.getPhoto());
//            userUpdate.setFirstname(user.getFirstname());
//            userUpdate.setLastname(user.getLastname());
//            userUpdate.setEmail(user.getEmail());
//            userUpdate.setPassword(userUpdate.getPassword());
//            userUpdate.setPhoneNumber(user.getPhoneNumber());
//            this.userRepository.save(userUpdate);
//            return userUpdate;
//        }
//
//        return userUpdate;
        return null;
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


}
