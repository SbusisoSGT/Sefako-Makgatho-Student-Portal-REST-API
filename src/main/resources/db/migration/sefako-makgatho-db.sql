-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2020 at 08:37 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smu`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `duration` int(10) NOT NULL,
  `qualification_id` int(11) NOT NULL,
  `school_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `name`, `code`, `duration`, `qualification_id`, `school_id`) VALUES
(1, 'Mathematical Science', 'BSCH01', 3, 2, 1),
(2, 'Physical Sciences', 'BSCI01', 3, 2, 1),
(3, 'Life Sciences', 'BSCG01', 3, 2, 1),
(4, 'Occupational & Envir', 'BSCJ01', 3, 2, 1),
(5, 'Computer Sciences', 'HONCIT', 1, 3, 1),
(6, 'Mathematics', 'HSCU01', 1, 3, 1),
(7, 'Physics', 'HSCO01', 1, 3, 1),
(8, 'Statistics', 'HSCV01', 1, 3, 1),
(9, 'Mathematics', 'MMAA090', 2, 4, 1),
(10, 'Physics', 'MPHA090', 2, 4, 1),
(11, 'Applied Mathematics', 'MAMA090', 2, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `course_modules`
--

CREATE TABLE `course_modules` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course_modules`
--

INSERT INTO `course_modules` (`id`, `course_id`, `module_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(10, 1, 10),
(11, 1, 11),
(12, 1, 12),
(13, 1, 13),
(14, 1, 14),
(15, 1, 15),
(16, 1, 16),
(17, 1, 17),
(18, 1, 18);

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`id`, `name`) VALUES
(7, 'Computer Science'),
(8, 'Mathematics and Applied Mathematics'),
(9, 'Physics'),
(10, 'Statistics and Operations Research'),
(11, 'Language Proficiency'),
(12, 'Chemistry'),
(13, 'Biology'),
(14, 'Biochemistry');

-- --------------------------------------------------------

--
-- Table structure for table `modules`
--

CREATE TABLE `modules` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(20) NOT NULL,
  `year` int(4) NOT NULL,
  `academic_period` int(2) NOT NULL,
  `prerequisite` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modules`
--

INSERT INTO `modules` (`id`, `name`, `code`, `year`, `academic_period`, `prerequisite`) VALUES
(1, 'Computing Concepts and Algorithms I', 'MCOA011', 1, 1, 0),
(2, 'Computing Concepts and Algorithms II', 'MCOA012', 1, 2, 0),
(3, 'Data Structures', 'MCOA021', 2, 1, 0),
(4, 'Computer Organisation and Architecture', 'MCOA022', 2, 2, 0),
(5, 'Database Systems', 'MCOA031', 3, 1, 0),
(6, 'Operating Systems', 'MCOB031', 3, 1, 0),
(7, 'Artificial Intelligence', 'MCOA032', 3, 2, 0),
(8, 'Computer Networks', 'MCOB032', 3, 2, 0),
(9, 'Health Education and Life Competencies I', 'MHEL011', 1, 1, 1),
(10, 'Health Education and Life Competencies II', 'MHEL012', 1, 2, 1),
(11, 'Differential and Integral Calculus', 'MMTH011', 1, 1, 1),
(12, 'Set Theory, Linear and Abstract Algebra', 'MMTH012', 1, 2, 1),
(13, 'Advanced Calculus', 'MMTA021', 2, 1, 1),
(14, 'Linear Algebra', 'MMTA022', 2, 2, 1),
(15, 'Mathematical Analysis I', 'MMTA031', 3, 1, 1),
(16, 'Abstract Algebra', 'MMTB031', 3, 1, 1),
(17, 'Mathematical Analysis II', 'MMTB032', 3, 2, 1),
(18, 'Complex Analysis', 'MMTA032', 3, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE `permissions` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `permissions`
--

INSERT INTO `permissions` (`id`, `name`, `description`) VALUES
(1, 'view-student', 'Lorem ipsum dolot sit amet consecture'),
(2, 'add-student', 'Lorem ipsum dolot sit amet consecture'),
(3, 'update-student', 'Lorem ipsum dolot sit amet consecture'),
(4, 'delete-student', 'Lorem ipsum dolot sit amet consecture'),
(5, 'view-grades', 'Lorem ipsum dolot sit amet consecture'),
(6, 'add-grades', 'Lorem ipsum dolot sit amet consecture'),
(7, 'update-grades', 'Lorem ipsum dolot sit amet consecture'),
(8, 'add-student-course', 'Lorem ipsum dolot sit amet consecture'),
(9, 'view-student-course', 'Lorem ipsum dolot sit amet consecture'),
(10, 'update-student-course', 'Lorem ipsum dolot sit amet consecture'),
(11, 'add-student-module', 'Lorem ipsum dolot sit amet consecture'),
(12, 'view-student-module', 'Lorem ipsum dolot sit amet consecture'),
(13, 'update-student-module', 'Lorem ipsum dolot sit amet consecture'),
(14, 'add-query', 'Lorem ipsum dolot sit amet consecture'),
(15, 'view-query', 'Lorem ipsum dolot sit amet consecture'),
(16, 'update-query', 'Lorem ipsum dolot sit amet consecture'),
(17, 'add-lecturer', 'Lorem ipsum dolot sit amet consecture'),
(18, 'view-lecturer', 'Lorem ipsum dolot sit amet consecture'),
(19, 'update-lecturer', 'Lorem ipsum dolot sit amet consecture'),
(20, 'add-lecturer-course', 'Lorem ipsum dolot sit amet consecture'),
(21, 'view-lecturer-course', 'Lorem ipsum dolot sit amet consecture'),
(22, 'update-lecturer-course', 'Lorem ipsum dolot sit amet consecture'),
(23, 'add-lecturer-module', 'Lorem ipsum dolot sit amet consecture'),
(24, 'view-lecturer-module', 'Lorem ipsum dolot sit amet consecture'),
(25, 'update-lecturer-module', 'Lorem ipsum dolot sit amet consecture');

-- --------------------------------------------------------

--
-- Table structure for table `qualifications`
--

CREATE TABLE `qualifications` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `qualifications`
--

INSERT INTO `qualifications` (`id`, `name`) VALUES
(1, 'Diploma'),
(2, 'Bachelor\'s Degree'),
(3, 'Honours Degree'),
(4, 'Masters Degree'),
(5, 'Doctoral Degree');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'Student'),
(2, 'Lecturer'),
(3, 'Secretary'),
(4, 'HOD'),
(5, 'Dean'),
(6, 'Admin'),
(7, 'Super-admin');

-- --------------------------------------------------------

--
-- Table structure for table `role_permissions`
--

CREATE TABLE `role_permissions` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role_permissions`
--

INSERT INTO `role_permissions` (`id`, `role_id`, `permission_id`) VALUES
(1, 1, 1),
(2, 1, 3),
(3, 1, 5),
(4, 1, 8),
(5, 1, 11),
(6, 1, 12),
(7, 1, 14),
(8, 1, 16),
(9, 2, 1),
(10, 2, 5),
(11, 2, 6),
(12, 2, 7),
(13, 2, 9),
(14, 2, 12),
(15, 2, 18),
(16, 2, 19),
(17, 2, 21),
(18, 2, 24),
(19, 4, 1),
(20, 4, 2),
(21, 4, 3),
(22, 4, 4),
(23, 4, 5),
(24, 4, 6),
(25, 4, 7),
(26, 4, 8),
(27, 4, 9),
(28, 4, 10),
(29, 4, 11),
(30, 4, 12),
(31, 4, 13),
(32, 4, 15),
(33, 4, 17),
(34, 4, 18),
(35, 4, 19),
(36, 4, 20),
(37, 4, 21),
(38, 4, 22),
(39, 4, 23),
(40, 4, 24),
(41, 4, 25),
(42, 6, 1),
(43, 6, 2),
(44, 6, 3),
(45, 6, 4),
(46, 6, 5),
(47, 6, 6),
(48, 6, 7),
(49, 6, 8),
(50, 6, 9),
(51, 6, 10),
(52, 6, 11),
(53, 6, 12),
(54, 6, 13),
(55, 6, 15),
(56, 6, 17),
(57, 6, 18),
(58, 6, 19),
(59, 6, 20),
(60, 6, 21),
(61, 6, 22),
(62, 6, 23),
(63, 6, 24),
(64, 6, 25);

-- --------------------------------------------------------

--
-- Table structure for table `schools`
--

CREATE TABLE `schools` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schools`
--

INSERT INTO `schools` (`id`, `name`) VALUES
(1, 'Science and Technolo'),
(2, 'Medicine'),
(3, 'Pharmacy'),
(4, 'Health Care Sciences'),
(5, 'Oral Health Sciences');

-- --------------------------------------------------------

--
-- Table structure for table `school_departments`
--

CREATE TABLE `school_departments` (
  `id` int(11) NOT NULL,
  `school_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `school_departments`
--

INSERT INTO `school_departments` (`id`, `school_id`, `department_id`) VALUES
(1, 1, 7),
(2, 1, 8),
(3, 1, 9),
(4, 1, 10),
(5, 1, 11),
(6, 1, 12),
(7, 1, 13),
(8, 1, 14),
(9, 2, 11),
(10, 3, 11),
(11, 4, 11),
(12, 5, 11);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `student_number` int(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `student_number`, `role_id`, `user_id`) VALUES
(1, 2018011752, 1, 3),
(2, 2018051352, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `student_courses`
--

CREATE TABLE `student_courses` (
  `id` int(11) NOT NULL,
  `completed` tinyint(1) NOT NULL DEFAULT 0,
  `current_level` int(2) NOT NULL DEFAULT 1,
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_courses`
--

INSERT INTO `student_courses` (`id`, `completed`, `current_level`, `course_id`, `student_id`) VALUES
(1, 0, 1, 1, 1),
(2, 0, 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `student_modules`
--

CREATE TABLE `student_modules` (
  `id` int(11) NOT NULL,
  `completed` tinyint(1) NOT NULL DEFAULT 0,
  `final_mark` int(5) DEFAULT NULL,
  `registration_year` year(4) DEFAULT NULL,
  `student_course_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_modules`
--

INSERT INTO `student_modules` (`id`, `completed`, `final_mark`, `registration_year`, `student_course_id`, `module_id`) VALUES
(1, 1, 76, 2020, 1, 1),
(2, 1, 51, 2020, 1, 9),
(3, 1, 56, 2020, 1, 11),
(4, 0, NULL, 2020, 1, 2),
(5, 0, NULL, 2020, 1, 10),
(6, 0, NULL, 2020, 1, 12);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `full_name`, `email`, `password`) VALUES
(1, 'Alex Dandadzi', 'alex.dandadzi@smu.ac.za', '6776'),
(2, 'Ntsoka Mathibe', 'ntsoka.mathibe@smu.ac.za', '9832'),
(3, 'Davis Mahlodi', '2018011752@swave.smu.ac.za', '1234'),
(4, 'James Gbenro', '2018051352@swave.smu.ac.za', '4321');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD UNIQUE KEY `code_2` (`code`),
  ADD KEY `qualification_id` (`qualification_id`),
  ADD KEY `school_id` (`school_id`);

--
-- Indexes for table `course_modules`
--
ALTER TABLE `course_modules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `course_id` (`course_id`),
  ADD KEY `module_id` (`module_id`);

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modules`
--
ALTER TABLE `modules`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`);

--
-- Indexes for table `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `qualifications`
--
ALTER TABLE `qualifications`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `permission_id` (`permission_id`);

--
-- Indexes for table `schools`
--
ALTER TABLE `schools`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `school_departments`
--
ALTER TABLE `school_departments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `school_id` (`school_id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_number` (`student_number`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `student_courses`
--
ALTER TABLE `student_courses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `course_id` (`course_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `student_modules`
--
ALTER TABLE `student_modules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `module_id` (`module_id`),
  ADD KEY `student_course_id` (`student_course_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `course_modules`
--
ALTER TABLE `course_modules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `modules`
--
ALTER TABLE `modules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `permissions`
--
ALTER TABLE `permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `qualifications`
--
ALTER TABLE `qualifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `role_permissions`
--
ALTER TABLE `role_permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `schools`
--
ALTER TABLE `schools`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `school_departments`
--
ALTER TABLE `school_departments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student_courses`
--
ALTER TABLE `student_courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student_modules`
--
ALTER TABLE `student_modules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`qualification_id`) REFERENCES `qualifications` (`id`),
  ADD CONSTRAINT `courses_ibfk_2` FOREIGN KEY (`school_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `courses_ibfk_3` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`);

--
-- Constraints for table `course_modules`
--
ALTER TABLE `course_modules`
  ADD CONSTRAINT `course_modules_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `course_modules_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `modules` (`id`);

--
-- Constraints for table `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD CONSTRAINT `role_permissions_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `role_permissions_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`);

--
-- Constraints for table `school_departments`
--
ALTER TABLE `school_departments`
  ADD CONSTRAINT `school_departments_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`),
  ADD CONSTRAINT `school_departments_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `students_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `student_courses`
--
ALTER TABLE `student_courses`
  ADD CONSTRAINT `student_courses_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  ADD CONSTRAINT `student_courses_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

--
-- Constraints for table `student_modules`
--
ALTER TABLE `student_modules`
  ADD CONSTRAINT `student_modules_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `modules` (`id`),
  ADD CONSTRAINT `student_modules_ibfk_3` FOREIGN KEY (`student_course_id`) REFERENCES `student_courses` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
