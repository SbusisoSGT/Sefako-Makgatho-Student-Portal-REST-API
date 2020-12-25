--
-- Dumping data for table `qualifications`
--

INSERT INTO `qualifications` (`id` , `name`) VALUES
(1, 'Diploma'),
(2, 'Bachelor\'s Degree'),
(3, 'Honours Degree'),
(4, 'Masters Degree'),
(5, 'Doctoral Degree');

-- --------------------------------------------------------

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `name`, `code`, `duration`, `qualification_id`, `school_id`) VALUES
(1, 'Mathematical Science', 'BSCH01', 3, 2, 1),

(2, 'Computer Sciences', 'HONCIT', 1, 3, 1),
(3, 'Mathematics', 'HSCU01', 1, 3, 1),
(4, 'Physics', 'HSCO01', 1, 3, 1),
(5, 'Statistics', 'HSCV01', 1, 3, 1),
(6, 'Applied Mathematics', 'HSCT01', 1, 3, 1),

(7, 'Mathematics', 'MMAA090', 2, 4, 1),
(8, 'Physics', 'MPHA090',  2, 4, 1),
(9, 'Statistics', 'MSTA090',  2, 4, 1),
(10, 'Applied Mathematics', 'MAMA090', 2, 4, 1),

(11, 'Mathematics', 'MMAA100', 2, 5, 1),
(12, 'Physics', 'MPHA100',  2, 5, 1),
(13, 'Statistics', 'MSTA100',  2, 5, 1),
(14, 'Applied Mathematics', 'MAMA100', 2, 5, 1);
-- --------------------------------------------------------


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
	(18, 'Complex Analysis', 'MMTA032', 3, 2, 1),
	
	(19, 'Introduction to Applied Mathematics', 'MAPM011', 1, 1, 0),
	(20, 'Computational Mathematics and Mathematical Modelling', 'MAPM012', 1, 2, 0),
	
	(21, 'Ordinary and Partial Differential Equations', 'MAPA021', 2, 1, 0),
	(22, 'Numerical Analysis', 'MAPA022', 2, 2, 0),
	
	(23, 'Fluid Mechanics', 'MAPA031', 3, 1, 0),
	(24, 'Mathematical Theory of Electromagnetism and Special Theory of Relativity', 'MAPA032', 3, 2, 0),
	
	(25, 'General Physics 1A', 'MPHS011', 1, 1, 0),
	(26, 'General Physics 1B', 'MPHS012', 1, 2, 0),
	
	(27, 'Classical Mechanics', 'MPHA021', 2, 1, 0),
	(28, 'Modern Physics', 'MPHB021', 2, 1, 0),
	(29, 'Electrodynamics and Eletronics', 'MPHA022', 2, 2, 0),
	(30, 'Waves and Physical Optics', 'MPHB022', 2, 2, 0),
	
	
	(31, 'Quantum Mechanics', 'MPHA031', 3, 1, 0),
	(32, 'Thermodynamics and Statistical Mechanics', 'MPHB031', 3, 1, 0),
	(33, 'Solid State Physics', 'MPHA032', 3, 2, 0),
	(34, 'Electrodynamics and Eletronics', 'MPHB032', 3, 2, 0),
	
	(35, 'Introduction to Statistics', 'MSTS011', 1, 1, 0),
	(36, 'Introduction to Statistical Inference', 'MSTS012', 1, 2, 0),
	
	(37, 'Theory of Distributions', 'MSTA021', 2, 1, 0),
	(38, 'Statistical Inference', 'MSTA022', 2, 2, 0),
	
	(39, 'Time Series Analysis', 'MSTA031', 3, 1, 0),
	(40, 'Apply Linear Regression', 'MSTB031', 3, 1, 0),
	(41, 'Design and Analysis Experiments', 'MSTA032', 3, 2, 0),
	(42, 'Multivariate Statistical Methods', 'MSTB032', 3, 2, 0),
	
	
	(43, 'Research Project', 'CSIT700', 1, 1, 1),
	(44, 'Advanced Database Systems and Systems Development', 'CSIT701', 1, 1, 0),
	(45, 'Artificial Intelligence', 'CSIT703', 1, 1, 0),
	(46, 'Health Informatics', 'CSIT705', 1, 2, 0),
	(47, 'Computer Networks', 'CSIT706', 1, 2, 0),
	(48, 'Computer Security', 'CSIT708', 1, 2, 0),
	(49, 'Mobile Application Development', 'CSIT709', 1, 2, 0),
	(50, 'Special Topic', 'CSIT710', 1, 1, 0),
	
	(51, 'Research Project', 'MMTH080', 1, 1, 1),
	(52, 'Group and Field Theory', 'MMTA081', 1, 1, 0),
	(53, 'General Topology', 'MMTB081', 1, 1, 0),
	(54, 'Complex Analysis', 'MMTC081', 1, 1, 0),
	(55, 'Measure Theory and Integration', 'MMTD081', 1, 1, 0),
	(56, 'Functional Analysis', 'MMTD082', 1, 2, 0),
	(57, 'Category Theory', 'MMTE082', 1, 2, 0),
	(58, 'Number Theory', 'MMTG082', 1, 2, 0),
	(59, 'Ring Theory', 'MMTH082', 1, 2, 0),
	
	(60, 'Research Project', 'MAPA080M', 1, 1, 1),
	(61, 'Mathematical Modelling with ODEs', 'MAPB080', 1, 1, 0),
	(62, 'Hydrodynamic Stability', 'MAPC080', 1, 1, 0),
	(63, 'Financial Mathematics', 'MAPD080', 1, 2, 0),
	(66, 'Advanced Mathematical Programming', 'MAPE080', 1, 2, 0),
	(67, 'General Theory of Relativity', 'MAPF080', 1, 2, 0),
	
	(68, 'Research Project', 'MPHS080', 1, 1, 1),
	(69, 'Quantum Mechanics', 'MPHA081', 1, 1, 0),
	(70, 'Statistical Mechanics', 'MPHB081', 1, 1, 0),
	(71, 'Electrodynamics', 'MPHA082', 1, 2, 0),
	(72, 'Solid State Physics', 'MPHB082', 1, 2, 0),
	
	
	(73, 'Research Project', 'MSTS080', 1, 1, 1),
	(74, 'Probabilty Theory', 'MSTA081', 1, 1, 0),
	(75, 'Statistical Inference', 'MSTA082', 1, 2, 0),
	(76, 'Sampling Theory', 'MSTB081', 1, 1, 0),
	(77, 'Biostatistics', 'MSTC081', 1, 1, 0),
	(78, 'Nonparametric Statistical Inference', 'MSTB082', 1, 2, 0),
	(79, 'Multivariant Analysis', 'MSTD081', 1, 1, 0),
	(80, 'Stochastic Processes', 'MSTC082', 1, 2, 0),
	(81, 'Categorical Data Analysis', 'MSTE081', 1, 2, 0);
	

-- --------------------------------------------------------


--
-- Dumping data for table `course_modules`
--

INSERT INTO `course_modules` (`course_id`, `module_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 28),
(1, 29),
(1, 30),
(1, 31),
(1, 32),
(1, 33),
(1, 34),
(1, 35),
(1, 36), 
(1, 37),
(1, 38),
(1, 39),
(1, 40),
(1, 41),
(1, 42),

(2,43),
(2,44),
(2,45),
(2,46),
(2,47),
(2,48),
(2,49),
(2,50),

(3, 51),
(3, 52),
(3, 53),
(3, 54),
(3, 55),
(3, 56),
(3, 57),
(3, 58),
(3, 59),


(4, 68),
(4, 69),
(4, 70),
(4, 71),
(4, 72),

(5, 73),
(5, 74),
(5, 75),
(5, 76),
(5, 77),
(5, 78),
(5, 79),
(5, 80),
(5, 81),


(6, 60),
(6, 61),
(6, 62),
(6, 63),
(6, 64),
(6, 65),
(6, 66),
(6, 67);

-- --------------------------------------------------------