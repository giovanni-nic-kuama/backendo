package com.tromario.backendo.modules.todo.services

import com.tromario.backendo.modules.common.RecordNotFoundException
import com.tromario.backendo.modules.todo.dtos.TodoCreateDto
import com.tromario.backendo.modules.todo.dtos.TodoReadDto
import com.tromario.backendo.modules.todo.dtos.TodoUpdateDto
import com.tromario.backendo.modules.todo.mappings.TodoMappings
import com.tromario.backendo.modules.todo.repositories.TodoRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
@Transactional
class TodoService(private val todoRepository: TodoRepository) {
    fun getById(id: Long): TodoReadDto {
        val optionalEntity = todoRepository.findById(id)

        if (optionalEntity.isEmpty) {
            throw RecordNotFoundException("Todo not found")
        }

        return TodoMappings.Map(optionalEntity.get())
    }

    fun getAll(pageable: Pageable): Page<TodoReadDto> {
        return todoRepository.findAll(pageable).map { TodoMappings.Map(it) }
    }

    fun create(todoCreateDto: TodoCreateDto): TodoReadDto {
        val entity = TodoMappings.Map(todoCreateDto)
        val created = todoRepository.save(entity)
        return TodoMappings.Map(created)
    }

    fun update(id: Long, todoUpdateDto: TodoUpdateDto): TodoReadDto {
        val optionalEntity = todoRepository.findById(id)

        if (optionalEntity.isEmpty) {
            throw RecordNotFoundException("Todo not found")
        }

        val entity = optionalEntity.get()

        TodoMappings.Map(entity, todoUpdateDto)

        val updated = todoRepository.save(entity)

        return TodoMappings.Map(updated)
    }

    fun delete(id: Long) {
        val optionalEntity = todoRepository.findById(id)

        if (optionalEntity.isEmpty) {
            throw RecordNotFoundException("Todo not found")
        }

        val entity = optionalEntity.get()

        todoRepository.delete(entity)
    }
}