package com.getsmarter.LearnSpringBoot.services.implement;

import com.getsmarter.LearnSpringBoot.entity.Command;

import java.util.List;

public interface CommandServiceImpl {

    //Enregistrer une commande
    Command saveCategory(Command command);

    //Afficher les commandes
    List<Command> getAllCategory();

    //Afficher une commande par son id
    Command getCategory(Long id);

    //MAJ des données de la commande
    Command updateCategory( Long id ,Command command);

    //Suppression de toutes les commandes
    void deleteCategory();

    //Suppression d'une commande par id
    void deleteCategoryById(Long id);
}
