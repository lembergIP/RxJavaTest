INSERT INTO `departments` (`id`, `name`) VALUES (1, 'HR');
INSERT INTO `departments` (`id`, `name`) VALUES (2, 'Tech');
INSERT INTO `departments` (`id`, `name`) VALUES (3, 'Finance');

INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (1, 'Ivan', TRUE ,1);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (2, 'Stepan', FALSE ,2);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (3, 'Andriy', TRUE ,3);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (4, 'Oleg', FALSE ,3);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (5, 'Tetiana', TRUE ,1);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (6, 'Orest', TRUE ,2);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (7, 'Olia', FALSE ,2);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (8, 'Igor', FALSE ,1);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (9, 'Nazar', FALSE ,1);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (10, 'Alina', TRUE ,2);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (11, 'Ivan', FALSE ,1);
INSERT INTO `employees` (`id`, `name`, `active`, `department_id`) VALUES (12, 'Olena', TRUE ,3);