package com.tromario.backendo.modules.todo.repositories

import com.tromario.backendo.modules.todo.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository: JpaRepository<Todo, Long> {
}