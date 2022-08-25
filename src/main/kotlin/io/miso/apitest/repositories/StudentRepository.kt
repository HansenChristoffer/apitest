package io.miso.apitest.repositories

import io.miso.apitest.models.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findByName(name: String): Collection<Student>
    fun findByCountry(country: String): Collection<Student>
    fun findByCity(city: String): Collection<Student>
    fun findByAddress(address: String): Collection<Student>
    fun findByPostnumber(postnumber: Long): Collection<Student>
    fun findByAge(age: Long): Collection<Student>
    fun findByMajor(major: String): Collection<Student>
    fun findByNameAndCountryAndCityAndAddressAndPostnumberAndAgeAndMajor(
        name: String,
        country: String,
        city: String,
        address: String,
        postnumber: Long,
        age: Long,
        major: String
    ): Collection<Student>
}
