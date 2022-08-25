package io.miso.apitest.config

import io.miso.apitest.models.Student
import io.miso.apitest.services.StudentService
import mu.KotlinLogging
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfiguration {

    private val logger = KotlinLogging.logger {}

    @Bean
    fun databaseInitializer(studentService: StudentService) = ApplicationRunner {

        val student0 = Student(
            1, "Minato",
            "Japan", "Tokyo",
            "Tokyo road 1", 12345,
            11, "Kyudo"
        )

        val student1 = Student(
            2, "Johnny",
            "United states of America", "New york",
            "Main street 69", 98765,
            10, "Football"
        )

        val student2 = Student(
            3, "Hans",
            "Germany", "Berlin",
            "Berlin road 420", 43215,
            12, "Chemistry"
        )

        studentService.saveStudent(student0)
        logger.info { "Tried to save one student!" }

        studentService.saveListOfStudents(arrayListOf(student1, student2))
        logger.info { "Tried to save several students!" }
    }
}
