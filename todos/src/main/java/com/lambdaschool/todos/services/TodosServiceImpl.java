package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService{
    @Autowired
    private TodosRepository todosRepository;

    @Override
    public void markComplete(long todoid) {
        Todos todo = todosRepository.findById(todoid)
                        .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " not found!"));

        todo.setCompleted(true);
        todosRepository.save(todo);
    }
}
