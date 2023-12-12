package org.example.task3.model;

import org.example.task3.Column;

import java.util.UUID;

@org.example.task3.Entity
public class Entity {
    @Column(name = "id", primaryKey = true)
    private UUID id;
}
