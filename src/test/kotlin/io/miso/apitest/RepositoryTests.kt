package io.miso.apitest

import io.miso.apitest.models.Student
import io.miso.apitest.repositories.StudentRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoryTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val studentRepository: StudentRepository
) {

    @Test
    @Order(1)
    fun findStudentById() {
        val expected =
            Student(
                3, "Johnny Bravo",
                "United states of America", "Miami",
                "5th Mimi road", 13253,
                22, "Computer Science"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findById(expected.id);
        assertThat(actual.get()).isNotNull
        assertThat(actual.get()).isEqualTo(expected)
    }

    @Test
    @Order(2)
    fun findStudentByName() {
        val expected =
            Student(
                9, "Tommy Bravo",
                "Bulgaria", "Bulga",
                "5th Bobo road", 45980,
                29, "Medical sciences"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByName(expected.name)
        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

    @Test
    @Order(3)
    fun findStudentByCountry() {
        val expected =
            Student(
                1, "Matty Bravo",
                "Romania", "Roro",
                "5th Roro road", 6537,
                98, "Mathematics"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByCountry(expected.country)
        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

    @Test
    @Order(4)
    fun findStudentByCity() {
        val expected =
            Student(
                8, "Delta Bravo",
                "Denmark", "Copenhagen",
                "5th Didi road", 11420,
                32, "Drinking sciences"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByCity(expected.city)
        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

    @Test
    @Order(5)
    fun findStudentByAddress() {
        val expected =
            Student(
                5, "Alpha Bravo",
                "Kuwait", "Jimja",
                "5th Kiki road", 132,
                65, "Oiler"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByAddress(expected.address)
        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

    @Test
    @Order(6)
    fun findStudentByPostnumber() {
        val expected =
            Student(
                7, "Dickward Bravo",
                "Finland", "Luopekakakakakzekolme",
                "5th Zizi road", 53423,
                24, "Female studies"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByPostnumber(expected.postnumber)
        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

    @Test
    @Order(7)
    fun findStudentByAge() {
        val expected =
            Student(
                4, "Blonde Bravo",
                "Poland", "Warzaw",
                "5th Titi road", 32412,
                18, "Math"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByAge(expected.age)
        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

    @Test
    @Order(8)
    fun findStudentByMajor() {
        val expected =
            Student(
                6, "What Bravo",
                "Sweden", "Malmö",
                "5th Bibi road", 24352,
                42, "Finance"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByMajor(expected.major)

        println(actual.toString())

        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

    @Test
    @Order(9)
    fun findStudentByStudent() {
        val expected =
            Student(
                2, "What Bravo",
                "Sweden", "Malmö",
                "5th Bibi road", 24352,
                42, "Finance"
            )
        entityManager.merge(expected);
        entityManager.flush()

        val actual = studentRepository.findByNameAndCountryAndCityAndAddressAndPostnumberAndAgeAndMajor(
            expected.name,
            expected.country,
            expected.city,
            expected.address,
            expected.postnumber,
            expected.age,
            expected.major
        )

        assertThat(actual.elementAt(0)).isEqualTo(expected)
    }

}
