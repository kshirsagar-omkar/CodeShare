package com.technocompacademy.config;

/**
 * Configuration interface for the TechnoCompAcademy project.
 * <p>
 * This interface provides a centralized configuration for database-related settings,
 * particularly for defining the file path to the student database. The file path specified
 * here points to the CSV file used to store and retrieve student records.
 * </p>
 * <p>
 * By using this interface, different components of the project can access a consistent
 * database file path without hardcoding values in multiple places, improving maintainability.
 * </p>
 *
 * @author Omkar
 * @version 1.0
 * @since 1.0
 */
public interface ConfigurationTechnoCompAcademy {

    /**
     * The file path to the student database file.
     * <p>
     * This constant defines the location of the CSV file where student data is stored.
     * </p>
     */
    public static final String pathForStudentDatabaseFile = "src/resources/studentDataBase.csv";
}
