--
-- Dumping data for table `schools`
--

INSERT INTO `schools` (`id`, `name`) VALUES
(1, 'Science and Technology'),
(2, 'Medicine'),
(3, 'Pharmacy'),
(4, 'Health Care Sciences'),
(5, 'Oral Health Sciences');

-- --------------------------------------------------------


--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`id`, `name`) VALUES
(1, 'Computer Science'),
(2, 'Mathematics and Applied Mathematics'),
(3, 'Physics'),
(4, 'Statistics and Operations Research'),
(5, 'Language Proficiency');

-- --------------------------------------------------------

INSERT INTO `school_departments` (`school_id`, `department_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 5),
(3, 5),
(4, 5),
(5, 5);

-- --------------------------------------------------------