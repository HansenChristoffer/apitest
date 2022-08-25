package io.miso.apitest.models

import java.util.*
import javax.persistence.*

@Table(name = "student")
@Entity
class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    var name: String,
    var country: String,
    var city: String,
    var address: String,
    var postnumber: Long,
    var age: Long,
    var major: String
) {


    override fun hashCode(): Int {
        return Objects.hash(id, name, country, city, address, postnumber, age, major)
    }

    override fun equals(other: Any?): Boolean {
        if (other != null && other is Student) {
            return other.id == id
                    && other.name == name
                    && other.country == country
                    && other.city == city
                    && other.address == address
                    && other.postnumber == postnumber
                    && other.age == age
                    && other.major == major
        }

        return false;
    }

    override fun toString(): String {
        return """{ "id": $id, "name": "$name", "country": "$country", "city": "$city", "address": "$address", "postnumber": $postnumber, "age": $age, "major": "$major" }"""
    }

}
