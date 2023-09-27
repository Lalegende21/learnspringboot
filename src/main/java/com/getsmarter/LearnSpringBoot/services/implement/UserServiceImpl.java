package com.getsmarter.LearnSpringBoot.services.implement;

import com.getsmarter.LearnSpringBoot.dto.UserDTO;
import com.getsmarter.LearnSpringBoot.entity.User;

import java.util.List;

public interface UserServiceImpl {

    //Enregistrer un utilisateur
    UserDTO saveUser(User user);

    //Afficher tous les utilisateurs
    List<UserDTO> getAllUser();

    //Afficher un utilisateur par son id
    UserDTO getUser(Long id);

    //MAJ des données d'un utilisateur
    User updateUser( Long id ,User user);

    //Suppression de tous les utilisateurs
    void deleteUser();

    //Suppression d'un utilisateur par id
    void deleteUserById(Long id);

    //Conversion d'un utilisateur en utilisateurDTO
    UserDTO convertEntityToDto(User u);

}
