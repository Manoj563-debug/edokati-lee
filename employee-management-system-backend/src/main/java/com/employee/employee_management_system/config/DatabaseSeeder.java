package com.employee.employee_management_system.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.employee.employee_management_system.entity.Department;
import com.employee.employee_management_system.entity.Employee;
import com.employee.employee_management_system.entity.PerformanceReview;
import com.employee.employee_management_system.entity.Project;
import com.employee.employee_management_system.repository.DepartmentRepository;
import com.employee.employee_management_system.repository.EmployeeRepository;
import com.employee.employee_management_system.repository.PerformanceReviewRepository;
import com.employee.employee_management_system.repository.ProjectRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;

    @Override
    public void run(String... args) throws Exception {
        // Only seed if no employees exist in the database
        if (employeeRepository.count() == 0) {
            System.out.println("No data found. Seeding database with demo data...");

            // 1. Create Departments
            Department engineering = new Department(null, "Engineering", "New York", 1500000.0);
            Department hr = new Department(null, "Human Resources", "San Francisco", 300000.0);
            Department marketing = new Department(null, "Marketing", "Chicago", 500000.0);
            Department finance = new Department(null, "Finance", "New York", 800000.0);

            departmentRepository.saveAll(Arrays.asList(engineering, hr, marketing, finance));

            // 2. Create Projects
            Project projAlpha = new Project(null, "Project Alpha", "Acme Corp", LocalDate.of(2026, 1, 10), LocalDate.of(2026, 8, 30), "In Progress");
            Project projBeta = new Project(null, "Beta Platform", "Stark Industries", LocalDate.of(2025, 5, 15), LocalDate.of(2026, 3, 20), "Completed");
            Project projCloud = new Project(null, "Cloud Migration", "Wayne Enterprises", LocalDate.of(2026, 3, 1), LocalDate.of(2026, 12, 15), "In Progress");
            Project projAnalytics = new Project(null, "Data Analytics Portal", "Globex Corp", LocalDate.of(2026, 5, 1), LocalDate.of(2026, 10, 31), "In Progress");

            projectRepository.saveAll(Arrays.asList(projAlpha, projBeta, projCloud, projAnalytics));

            // 3. Create 15 Employees
            List<Employee> employees = new ArrayList<>();

            // Eng
            employees.add(new Employee(null, "Alice Johnson", "alice.j@example.com", "9876543210", 95000.0, "Software Engineer", LocalDate.of(2023, 6, 15), engineering, Arrays.asList(projAlpha, projCloud), null));
            employees.add(new Employee(null, "Bob Smith", "bob.s@example.com", "9876543211", 110000.0, "Senior Software Engineer", LocalDate.of(2021, 3, 12), engineering, Arrays.asList(projAlpha), null));
            employees.add(new Employee(null, "Diana Prince", "diana.p@example.com", "9876543213", 125000.0, "Engineering Manager", LocalDate.of(2020, 8, 18), engineering, Arrays.asList(projCloud, projBeta), null));
            employees.add(new Employee(null, "Hannah Abbott", "hannah.a@example.com", "9876543217", 92000.0, "DevOps Engineer", LocalDate.of(2022, 9, 10), engineering, Arrays.asList(projCloud), null));
            employees.add(new Employee(null, "Ian Malcolm", "ian.m@example.com", "9876543218", 140000.0, "Principal Architect", LocalDate.of(2019, 5, 20), engineering, Arrays.asList(projAlpha, projBeta, projCloud), null));
            employees.add(new Employee(null, "Laura Croft", "laura.c@example.com", "9876543221", 115000.0, "Security Architect", LocalDate.of(2021, 12, 1), engineering, Arrays.asList(projCloud), null));

            // HR
            employees.add(new Employee(null, "Charlie Brown", "charlie.b@example.com", "9876543212", 60000.0, "HR Coordinator", LocalDate.of(2024, 1, 10), hr, new ArrayList<>(), null));
            employees.add(new Employee(null, "Nancy Drew", "nancy.d@example.com", "9876543223", 72000.0, "HR Specialist", LocalDate.of(2023, 4, 1), hr, new ArrayList<>(), null));

            // Marketing
            employees.add(new Employee(null, "Evan Wright", "evan.w@example.com", "9876543214", 85000.0, "Data Analyst", LocalDate.of(2024, 7, 1), marketing, Arrays.asList(projAnalytics), null));
            employees.add(new Employee(null, "Fiona Gallagher", "fiona.g@example.com", "9876543215", 55000.0, "Marketing Assistant", LocalDate.of(2025, 2, 15), marketing, Arrays.asList(projAnalytics), null));
            employees.add(new Employee(null, "Julia Roberts", "julia.r@example.com", "9876543219", 82000.0, "Marketing Specialist", LocalDate.of(2024, 4, 12), marketing, new ArrayList<>(), null));
            employees.add(new Employee(null, "Michael Scott", "michael.s@example.com", "9876543222", 90000.0, "Marketing Manager", LocalDate.of(2018, 1, 15), marketing, new ArrayList<>(), null));

            // Finance
            employees.add(new Employee(null, "George Costanza", "george.c@example.com", "9876543216", 75000.0, "Financial Analyst", LocalDate.of(2023, 11, 1), finance, new ArrayList<>(), null));
            employees.add(new Employee(null, "Kevin Malone", "kevin.m@example.com", "9876543220", 65000.0, "Accountant", LocalDate.of(2022, 10, 5), finance, new ArrayList<>(), null));
            employees.add(new Employee(null, "Oscar Martinez", "oscar.m@example.com", "9876543224", 88000.0, "Senior Accountant", LocalDate.of(2020, 11, 15), finance, new ArrayList<>(), null));

            employeeRepository.saveAll(employees);

            // 4. Create Performance Reviews (link back to saved employees)
            // Fetch seeded employees from repo to have correct auto-generated IDs
            List<Employee> seededEmployees = employeeRepository.findAll();
            List<PerformanceReview> reviews = new ArrayList<>();

            for (Employee emp : seededEmployees) {
                if ("Alice Johnson".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 4, "Excellent progress on Project Alpha. Demonstrates great team collaboration.", LocalDate.of(2026, 6, 1), "Keep taking initiative on design decisions.", emp));
                } else if ("Bob Smith".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 5, "Outstanding contribution to the core platform architecture. A key asset to the team.", LocalDate.of(2026, 5, 15), "Continue mentoring junior engineers.", emp));
                } else if ("Charlie Brown".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 3, "Performs basic tasks well but needs to show more proactiveness in HR initiatives.", LocalDate.of(2026, 6, 10), "Focus on professional development and communication skills.", emp));
                } else if ("Diana Prince".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 5, "Superb leadership during cloud migration. Managed stakeholders and timelines flawlessly.", LocalDate.of(2026, 5, 20), "Ready for higher level leadership responsibilities.", emp));
                } else if ("Evan Wright".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 4, "Great data insights generated for the Analytics portal. Highly detail-oriented.", LocalDate.of(2026, 6, 5), "Work on presenting findings more impactfully to non-technical stakeholders.", emp));
                } else if ("Ian Malcolm".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 5, "Brilliant architectural vision. Solved critical performance issues on Beta Platform.", LocalDate.of(2026, 4, 30), "Maintain this level of engineering excellence.", emp));
                } else if ("George Costanza".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 2, "Struggles with financial reporting deadlines. Accuracy needs significant improvement.", LocalDate.of(2026, 5, 28), "Please focus on attention to detail and verify calculations.", emp));
                } else if ("Oscar Martinez".equals(emp.getEmployeeName())) {
                    reviews.add(new PerformanceReview(null, 4, "Highly accurate accounting reports. Very dependable financial resource.", LocalDate.of(2026, 5, 25), "Continue maintaining the high standard of accuracy.", emp));
                }
            }

            performanceReviewRepository.saveAll(reviews);
            System.out.println("Demo database seeding completed successfully with 15 employees, 4 departments, 4 projects, and 8 performance reviews.");
        } else {
            System.out.println("Database already contains data. Seeding skipped.");
        }
    }
}
