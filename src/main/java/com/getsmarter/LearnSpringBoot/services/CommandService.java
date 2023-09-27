package com.getsmarter.LearnSpringBoot.services;

import com.getsmarter.LearnSpringBoot.entity.Command;
import com.getsmarter.LearnSpringBoot.repository.CommandRepository;
import com.getsmarter.LearnSpringBoot.services.exception.CommandNotFoundException;
import com.getsmarter.LearnSpringBoot.services.implement.CommandServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommandService implements CommandServiceImpl {

    private CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }


    // La methodde pour inserer les commandes (Create du crud)
    @Override
    public Command saveCategory(Command command) {
        command.setCreated_at(LocalDateTime.now());
        this.commandRepository.save(command);
        return command;
    }


    // La methodde pour lire les commandes (Read du crud)
    @Override
    public List<Command> getAllCategory() {
        return this.commandRepository.findAll();
    }


    // La methode pour lire les commandes par id
    @Override
    public Command getCategory(Long id) {
        Optional<Command> optionalCommand = this.commandRepository.findById(id);

        return optionalCommand.orElseThrow(() -> new CommandNotFoundException("Commande ayant l'id " +id+ " pas trouvé !"));
    }


    // La methode pour faire la mise à jour des données des commandes
    @Override
    public Command updateCategory(Long id, Command command) {
        Command commandUpdate = this.getCategory(id);

        if (commandUpdate.getId() == command.getId()) {
            commandUpdate.setUser(command.getUser());
            commandUpdate.setProduct(command.getProduct());
            this.commandRepository.save(commandUpdate);
        }
        return commandUpdate;
    }


    // La methode pour supprimer toutes les commandes
    @Override
    public void deleteCategory() {
        this.commandRepository.deleteAll();
    }


    // La methode pour supprimer un commandes par son id
    @Override
    public void deleteCategoryById(Long id) {
        this.commandRepository.deleteById(id);
    }
}
