package io.miso.apitest.controllers

import io.miso.apitest.models.Student
import io.miso.apitest.services.StudentService
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/student")
class StudentController(studentService: StudentService) {

    private val logger = KotlinLogging.logger {}
    private val studentService: StudentService = studentService

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun index(): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getAll()
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/byid/{id}", "/byId/{id}")
    fun respondWithStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) ResponseEntity.ok().body(student) else ResponseEntity.notFound().build()
    }

    @GetMapping("/byname/{name}", "/byName/{name}")
    fun respondWithStudentByName(@PathVariable name: String): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getStudentByName(name)
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/bycountry/{country}", "/byCountry/{country}")
    fun respondWithStudentByCountry(@PathVariable country: String): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getStudentByCountry(country)
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/bycity/{city}", "/byCity/{city}")
    fun respondWithStudentByCity(@PathVariable city: String): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getStudentByCity(city)
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/byaddress/{address}", "/byAddress/{address}")
    fun respondWithStudentByAddress(@PathVariable address: String): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getStudentByAddress(address)
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/bypostnumber/{postnumber}", "/byPostnumber/{postnumber}")
    fun respondWithStudentByPostnumber(@PathVariable postnumber: Long): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getStudentByPostnumber(postnumber)
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/byage/{age}", "/byAge/{age}")
    fun respondWithStudentByAge(@PathVariable age: Long): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getStudentByAge(age)
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/bymajor/{major}", "/byMajor/{major}")
    fun respondWithStudentByMajor(@PathVariable major: String): ResponseEntity<Collection<Student>> {
        val listOfStudents = studentService.getStudentByMajor(major)
        return if (listOfStudents.isNotEmpty()) ResponseEntity.ok().body(listOfStudents) else ResponseEntity.notFound()
            .build()
    }

    @GetMapping("/test")
    fun testRespond(@RequestBody student: Student): ResponseEntity<Student> {
        val stud = studentService.getStudentByStudent(student)
        return if (stud != null) ResponseEntity.ok().body(stud) else ResponseEntity.notFound().build()
    }

    @PostMapping("/")
    fun saveStudentAndRespond(@RequestBody student: Student): ResponseEntity<Student> {
        val rtnStudent = studentService.saveStudent(student)
        return if (rtnStudent != null) ResponseEntity.ok()
            .body(rtnStudent) else ResponseEntity.badRequest().build()
    }

    @PostMapping("/all")
    fun saveListOfStudentsAndRespond(@RequestBody listOfStudents: Collection<Student>): ResponseEntity<Collection<Student>> {
        val rtnListOfStudents = studentService.saveListOfStudents(listOfStudents)
        return if (rtnListOfStudents.isNotEmpty()) ResponseEntity.ok()
            .body(rtnListOfStudents) else ResponseEntity.badRequest().build()
    }

}
