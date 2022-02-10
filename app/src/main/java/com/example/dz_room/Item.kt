package com.example.dz_room

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
class Item(
    @PrimaryKey
    @NotNull
    var key: String,

    var value: String = ""
)