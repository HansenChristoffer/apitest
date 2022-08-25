package io.miso.apitest.services

import io.miso.apitest.models.Student
import io.miso.apitest.repositories.StudentRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(studentRepository: StudentRepository) {

    private val logger = KotlinLogging.logger {}
    private val studentRepository = studentRepository

    // getters
    fun getAll(): ArrayList<Student> {
        logger.info { "Get all students endpoint called..." }
        val listOfStudents = studentRepository.findAll() as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList()
    }

    fun getStudentById(id: Long): Student? {
        logger.info { "Get student by id endpoint called..." }
        val student: Optional<Student> = studentRepository.findById(id)
        return if (student.isPresent) student.get() else null
    }

    fun getStudentByName(name: String): ArrayList<Student> {
        logger.info { "Get list of students by name endpoint called..." }
        val listOfStudents = studentRepository.findByName(name) as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList<Student>()
    }

    fun getStudentByCountry(country: String): ArrayList<Student> {
        logger.info { "Get list of students by country endpoint called..." }
        val listOfStudents = studentRepository.findByCountry(country) as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList<Student>()
    }

    fun getStudentByCity(city: String): ArrayList<Student> {
        logger.info { "Get list of students by city endpoint called..." }
        val listOfStudents = studentRepository.findByCity(city) as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList<Student>()
    }

    fun getStudentByAddress(address: String): ArrayList<Student> {
        logger.info { "Get list of students by address endpoint called..." }
        val listOfStudents = studentRepository.findByAddress(address) as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList<Student>()
    }

    fun getStudentByPostnumber(postnumber: Long): ArrayList<Student> {
        logger.info { "Get list of students by postnumber endpoint called..." }
        val listOfStudents = studentRepository.findByPostnumber(postnumber) as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList<Student>()
    }

    fun getStudentByAge(age: Long): ArrayList<Student> {
        logger.info { "Get list of students by age endpoint called..." }
        val listOfStudents = studentRepository.findByAge(age) as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList<Student>()
    }

    fun getStudentByMajor(major: String): ArrayList<Student> {
        logger.info { "Get list of students by major endpoint called..." }
        val listOfStudents: ArrayList<Student> = studentRepository.findByMajor(major) as ArrayList<Student>
        return if (listOfStudents.size > 0) listOfStudents else ArrayList<Student>()
    }

    fun getStudentByStudent(student: Student): Student? {
        logger.info { "Get student by student endpoint called..." }
        val rtnStudent = studentRepository.findByNameAndCountryAndCityAndAddressAndPostnumberAndAgeAndMajor(
            student.name, student.country, student.city, student.address, student.postnumber, student.age, student.major
        )
        return if (rtnStudent != null && rtnStudent.isNotEmpty() && rtnStudent.elementAt(0) == student) rtnStudent.elementAt(
            0
        ) else null
    }

    // setters
    fun saveStudent(student: Student): Student {
        logger.info { "Save student endpoint called..." }
        return studentRepository.saveAndFlush(student)
    }

    fun saveListOfStudents(listOfStudents: Collection<Student>): Collection<Student> {
        logger.info { "Save list of students endpoint called..." }
        return studentRepository.saveAllAndFlush(listOfStudents)
    }
}
