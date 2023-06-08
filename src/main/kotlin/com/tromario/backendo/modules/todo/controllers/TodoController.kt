package com.tromario.backendo.modules.todo.controllers

import com.tromario.backendo.modules.common.RecordNotFoundException
import com.tromario.backendo.modules.todo.dtos.TodoCreateDto
import com.tromario.backendo.modules.todo.dtos.TodoReadDto
import com.tromario.backendo.modules.todo.dtos.TodoUpdateDto
import com.tromario.backendo.modules.todo.services.TodoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

private const val controllerPath = "api/todo"


@RestController
@RequestMapping(controllerPath)
class TodoController(private val todoService: TodoService) {
    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): ResponseEntity<TodoReadDto> {
        val readDto = todoService.getById(id)

        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(readDto)
    }

    @GetMapping("")
    fun getAll(pageable: Pageable): ResponseEntity<Page<TodoReadDto>> {
        val page = todoService.getAll(pageable)

        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(page)
    }

    @PostMapping("")
    fun create(@Validated @RequestBody todoCreateDto: TodoCreateDto): ResponseEntity<TodoReadDto> {
        val readDto = todoService.create(todoCreateDto)

        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(readDto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Validated @RequestBody todoUpdateDto: TodoUpdateDto): ResponseEntity<TodoReadDto> {
        val readDto = todoService.update(id, todoUpdateDto)

        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(readDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        todoService.delete(id)

        return ResponseEntity.noContent().build()
    }

    @ExceptionHandler(RecordNotFoundException::class)
    fun handleRecordNotFoundException(ex: RecordNotFoundException): ResponseEntity<Void> {
        return ResponseEntity.notFound().build()
    }
}