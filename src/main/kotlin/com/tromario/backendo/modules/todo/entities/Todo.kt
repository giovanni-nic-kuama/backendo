package com.tromario.backendo.modules.todo.entities

import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date

@Entity
class Todo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,
    var title: String,
    var message: String?,
    @Column(name = "createdat") var createdAt: LocalDate,
    @Column(name = "updatedat") var updatedAt: LocalDate? = null,
    @Column(name = "deletedat") var deletedAt: LocalDate? = null,
)