package com.tromario.backendo.modules.todo.mappings

import com.tromario.backendo.modules.todo.dtos.TodoCreateDto
import com.tromario.backendo.modules.todo.dtos.TodoReadDto
import com.tromario.backendo.modules.todo.dtos.TodoUpdateDto
import com.tromario.backendo.modules.todo.entities.Todo
import java.time.LocalDate

object TodoMappings {

    fun Map(todo: Todo): TodoReadDto {
        return TodoReadDto(
            id = todo.id,
            title = todo.title,
            message = todo.message,
            createdAt = todo.createdAt,
            updatedAt = todo.updatedAt,
            deletedAt = todo.deletedAt,
        )
    }

    fun Map(createDto: TodoCreateDto): Todo {
        return Todo(
            title = createDto.title,
            message = createDto.message,
            createdAt = LocalDate.now()
        )
    }

    fun Map(entity: Todo, updateDto: TodoUpdateDto) {
        entity.title = updateDto.title
        entity.message = updateDto.message
        entity.updatedAt = LocalDate.now()
    }
}