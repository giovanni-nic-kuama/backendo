package com.tromario.backendo.modules.todo.dtos

import java.time.LocalDate

class TodoReadDto(
    var id: Long,
    var title: String,
    var message: String?,
    var createdAt: LocalDate,
    var updatedAt: LocalDate?,
    var deletedAt: LocalDate?,
)