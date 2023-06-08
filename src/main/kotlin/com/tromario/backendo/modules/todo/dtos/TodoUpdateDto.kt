package com.tromario.backendo.modules.todo.dtos

import jakarta.validation.constraints.Size

class TodoUpdateDto(
    @field:Size(min = 2)
    @field:Size(max = 200)
    var title: String,

    @field:Size(min = 2)
    @field:Size(max = 200)
    var message: String?,
)