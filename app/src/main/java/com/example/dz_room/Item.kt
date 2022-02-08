package com.example.dz_room

@Entity
@TypeConverters(DateConverter::class)
class Item(
    var key: Int? = null,
    var value: String = ""
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}