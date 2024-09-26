INSERT INTO roles (rol, fecha_creacion) VALUES ('ADMIN', NOW());
INSERT INTO roles (rol, fecha_creacion) VALUES ('USER', NOW());

INSERT INTO generos (nombre, fecha_creacion) VALUES ('masculino', NOW());
INSERT INTO generos (nombre, fecha_creacion) VALUES ('femenino', NOW());

-- -- Insertar en tabla 'usuarios
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (1, 'user1', 'pass123', 'Juan', 'Pérez', 'juan.perez@example.com', NOW(), NOW(), 1, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (2, 'user2', 'pass123', 'Ana', 'Gómez', 'ana.gomez@example.com', NOW(), NOW(), 2, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (3, 'user3', 'pass123', 'Carlos', 'Rodríguez', 'carlos.rodriguez@example.com', NOW(), NOW(), 1, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (4, 'user4', 'pass123', 'María', 'Martínez', 'maria.martinez@example.com', NOW(), NOW(), 2, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (5, 'user5', 'pass123', 'Luis', 'Fernández', 'luis.fernandez@example.com', NOW(), NOW(), 1, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (6, 'user6', 'pass123', 'Elena', 'Ramos', 'elena.ramos@example.com', NOW(), NOW(), 2, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (7, 'user7', 'pass123', 'Pedro', 'Sánchez', 'pedro.sanchez@example.com', NOW(), NOW(), 1, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (8, 'user8', 'pass123', 'Laura', 'López', 'laura.lopez@example.com', NOW(), NOW(), 2, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (9, 'user9', 'pass123', 'José', 'García', 'jose.garcia@example.com', NOW(), NOW(), 1, TRUE);
INSERT INTO usuarios (id, username, password, nombre, apellido, email, fecha_creacion, fecha_actualizacion, genero_id, enabled) VALUES (10, 'user10', 'pass123', 'Claudia', 'Moreno', 'claudia.moreno@example.com', NOW(), NOW(), 2, TRUE);

-- -- everyone is user
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (3, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (4, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (5, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (6, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (7, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (8, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (9, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (10, 2);

-- -- Insertar en tabla 'organizaciones'
INSERT INTO organizaciones (id, nombre, descripcion, alias, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (1, 'Org1', 'Organización 1', 'org1', NOW(), NOW(), 1);
INSERT INTO organizaciones (id, nombre, descripcion, alias, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (2, 'Org2', 'Organización 2', 'org2', NOW(), NOW(), 5);


-- -- Insertar en tabla 'organizacion_usuarios'INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 1, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 2, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 3, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 4, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 5, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 6, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 7, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 8, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 9, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 9, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 10, NOW(), NOW());
INSERT INTO organizacion_usuarios (organizacion_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 10, NOW(), NOW());


-- Insertar en tabla 'proyectos'
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (1, 'Proj A', 'Proyecto 1 de Org1', 'ACTIVO', NOW(), NOW(), 1);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (2, 'Proj B', 'Proyecto 2 de Org1', 'COMPLETADO', NOW(), NOW(), 1);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (3, 'Proj C', 'Proyecto 1 de Org2', 'CANCELADO', NOW(), NOW(), 5);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (4, 'Proj D', 'Proyecto 2 de Org2', 'ACTIVO', NOW(), NOW(), 5);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (5, 'Proj E', 'Proyecto 3 de Org2', 'COMPLETADO', NOW(), NOW(), 5);
-- -- Insertar en tabla 'proyectos' para proyectos personales
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (6, 'Proj Personal J', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 1);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (7, 'Proj Personal A', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 2);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (8, 'Proj Personal C', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 3);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (9, 'Proj Personal M', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 4);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (10, 'Proj Personal L', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 5);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (11, 'Proj Personal E', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 6);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (12, 'Proj Personal P', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 7);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (13, 'Proj Personal L', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 8);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (14, 'Proj Personal J', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 9);
INSERT INTO proyectos (id, nombre, descripcion, estado_proyecto, fecha_creacion, fecha_actualizacion, usuario_creador_id) VALUES (15, 'Proj Personal C', 'Proyecto independiente', 'ACTIVO', NOW(), NOW(), 10);

-- Insertar en tabla 'proyectos_usuarios'
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 1, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 2, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 3, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 4, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 1, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 2, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 3, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 4, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (3, 5, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (3, 6, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (3, 7, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (3, 8, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (4, 5, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (4, 6, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (4, 7, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (4, 8, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (5, 5, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (5, 6, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (5, 7, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (5, 8, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (1, 9, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (3, 9, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (2, 10, NOW(), NOW());
INSERT INTO proyectos_usuarios (proyecto_id, usuario_id, fecha_creacion, fecha_actualizacion) VALUES (4, 10, NOW(), NOW());

-- Tipo tareas
INSERT INTO tipo_tarea (id, tipo, fecha_creacion, fecha_actualizacion) VALUES (1, 'Tipo Tarea A', NOW(), NOW());
INSERT INTO tipo_tarea (id, tipo, fecha_creacion, fecha_actualizacion) VALUES (2, 'Tipo Tarea B', NOW(), NOW());


-- Tareas para proyectos de organizaciones
-- Proyecto A (Org1)
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (1, 'Tarea 1 Proyecto A', 'Descripción de tarea 1', '2024-01-01', '2024-01-05', NOW(), NOW(), 5, 1, 1, 'EN_PROGRESO');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (2, 'Tarea 2 Proyecto A', 'Descripción de tarea 2', '2024-01-02', '2024-01-06', NOW(), NOW(), 6, 1, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (3, 'Tarea 3 Proyecto A', 'Descripción de tarea 3', '2024-01-03', '2024-01-07', NOW(), NOW(), 7, 1, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (4, 'Tarea 4 Proyecto A', 'Descripción de tarea 4', '2024-01-04', '2024-01-08', NOW(), NOW(), 8, 1, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (5, 'Tarea 5 Proyecto A', 'Descripción de tarea 5', '2024-01-05', '2024-01-09', NOW(), NOW(), 9, 1, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (6, 'Tarea 6 Proyecto A', 'Descripción de tarea 6', '2024-01-06', '2024-01-10', NOW(), NOW(), 10, 1, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (7, 'Tarea 7 Proyecto A', 'Descripción de tarea 7', '2024-01-07', '2024-01-11', NOW(), NOW(), 11, 1, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (8, 'Tarea 8 Proyecto A', 'Descripción de tarea 8', '2024-01-08', '2024-01-12', NOW(), NOW(), 12, 1, 1, 'PENDIENTE');


-- -- Tareas para el Proyecto B (Org1)
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (9, 'Tarea 1 Proyecto B', 'Descripción de la tarea 1 del Proyecto B', '2024-01-01', '2024-01-05', NOW(), NOW(), 5, 2, 1, 'EN_PROGRESO');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (10, 'Tarea 2 Proyecto B', 'Descripción de la tarea 2 del Proyecto B', '2024-01-02', '2024-01-06', NOW(), NOW(), 6, 2, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (11, 'Tarea 3 Proyecto B', 'Descripción de la tarea 3 del Proyecto B', '2024-01-03', '2024-01-07', NOW(), NOW(), 7, 2, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (12, 'Tarea 4 Proyecto B', 'Descripción de la tarea 4 del Proyecto B', '2024-01-04', '2024-01-08', NOW(), NOW(), 8, 2, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (13, 'Tarea 5 Proyecto B', 'Descripción de la tarea 5 del Proyecto B', '2024-01-05', '2024-01-09', NOW(), NOW(), 9, 2, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (14, 'Tarea 6 Proyecto B', 'Descripción de la tarea 6 del Proyecto B', '2024-01-06', '2024-01-10', NOW(), NOW(), 10, 2, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (15, 'Tarea 7 Proyecto B', 'Descripción de la tarea 7 del Proyecto B', '2024-01-07', '2024-01-11', NOW(), NOW(), 11, 2, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (16, 'Tarea 8 Proyecto B', 'Descripción de la tarea 8 del Proyecto B', '2024-01-08', '2024-01-12', NOW(), NOW(), 12, 2, 1, 'PENDIENTE');

-- -- Tareas para el Proyecto C (Org2)
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (17, 'Tarea 1 Proyecto C', 'Descripción de la tarea 1 del Proyecto C', '2024-01-01', '2024-01-05', NOW(), NOW(), 5, 3, 1, 'EN_PROGRESO');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (18, 'Tarea 2 Proyecto C', 'Descripción de la tarea 2 del Proyecto C', '2024-01-02', '2024-01-06', NOW(), NOW(), 6, 3, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (19, 'Tarea 3 Proyecto C', 'Descripción de la tarea 3 del Proyecto C', '2024-01-03', '2024-01-07', NOW(), NOW(), 7, 3, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (20, 'Tarea 4 Proyecto C', 'Descripción de la tarea 4 del Proyecto C', '2024-01-04', '2024-01-08', NOW(), NOW(), 8, 3, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (21, 'Tarea 5 Proyecto C', 'Descripción de la tarea 5 del Proyecto C', '2024-01-05', '2024-01-09', NOW(), NOW(), 9, 3, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (22, 'Tarea 6 Proyecto C', 'Descripción de la tarea 6 del Proyecto C', '2024-01-06', '2024-01-10', NOW(), NOW(), 10, 3, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (23, 'Tarea 7 Proyecto C', 'Descripción de la tarea 7 del Proyecto C', '2024-01-07', '2024-01-11', NOW(), NOW(), 11, 3, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (24, 'Tarea 8 Proyecto C', 'Descripción de la tarea 8 del Proyecto C', '2024-01-08', '2024-01-12', NOW(), NOW(), 12, 3, 1, 'PENDIENTE');

-- -- Tareas para el Proyecto D (Org2)
-- INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (25, 'Tarea 1 Proyecto D', 'Descripción de la tarea 1 del Proyecto D', '2024-01-01', '2024-01-05', NOW(), NOW(), 5, 4, 1, 'EN_PROGRESO');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (26, 'Tarea 2 Proyecto D', 'Descripción de la tarea 2 del Proyecto D', '2024-01-02', '2024-01-06', NOW(), NOW(), 6, 4, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (27, 'Tarea 3 Proyecto D', 'Descripción de la tarea 3 del Proyecto D', '2024-01-03', '2024-01-07', NOW(), NOW(), 7, 4, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (28, 'Tarea 4 Proyecto D', 'Descripción de la tarea 4 del Proyecto D', '2024-01-04', '2024-01-08', NOW(), NOW(), 8, 4, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (29, 'Tarea 5 Proyecto D', 'Descripción de la tarea 5 del Proyecto D', '2024-01-05', '2024-01-09', NOW(), NOW(), 9, 4, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (30, 'Tarea 6 Proyecto D', 'Descripción de la tarea 6 del Proyecto D', '2024-01-06', '2024-01-10', NOW(), NOW(), 10, 4, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (31, 'Tarea 7 Proyecto D', 'Descripción de la tarea 7 del Proyecto D', '2024-01-07', '2024-01-11', NOW(), NOW(), 11, 4, 1, 'PENDIENTE');
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (32, 'Tarea 8 Proyecto D', 'Descripción de la tarea 8 del Proyecto D', '2024-01-08', '2024-01-12', NOW(), NOW(), 12, 4, 1, 'PENDIENTE');

-- -- Tareas para el Proyecto E (Org2)
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (33, 'Tarea 1 Proyecto E', 'Descripción de la tarea 1 del Proyecto E', '2024-01-01', '2024-01-05', NOW(), NOW(), 5, 5, 1, 'EN_PROGRESO'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (34, 'Tarea 2 Proyecto E', 'Descripción de la tarea 2 del Proyecto E', '2024-01-02', '2024-01-06', NOW(), NOW(), 6, 5, 1, 'PENDIENTE'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (35, 'Tarea 3 Proyecto E', 'Descripción de la tarea 3 del Proyecto E', '2024-01-03', '2024-01-07', NOW(), NOW(), 7, 5, 1, 'PENDIENTE'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (36, 'Tarea 4 Proyecto E', 'Descripción de la tarea 4 del Proyecto E', '2024-01-04', '2024-01-08', NOW(), NOW(), 8, 5, 1, 'PENDIENTE'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (37, 'Tarea 5 Proyecto E', 'Descripción de la tarea 5 del Proyecto E', '2024-01-05', '2024-01-09', NOW(), NOW(), 9, 5, 1, 'PENDIENTE'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (38, 'Tarea 6 Proyecto E', 'Descripción de la tarea 6 del Proyecto E', '2024-01-06', '2024-01-10', NOW(), NOW(), 10, 5, 1, 'PENDIENTE'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (39, 'Tarea 7 Proyecto E', 'Descripción de la tarea 7 del Proyecto E', '2024-01-07', '2024-01-11', NOW(), NOW(), 11, 5, 1, 'PENDIENTE'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (40, 'Tarea 8 Proyecto E', 'Descripción de la tarea 8 del Proyecto E', '2024-01-08', '2024-01-12', NOW(), NOW(), 12, 5, 1, 'PENDIENTE'); 

-- -- Insert tasks for personal projects of each user

-- -- Tasks for Proyecto Personal Usuario 1
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (41, 'Tarea 1 Proyecto Personal Usuario 1', 'Descripción de la tarea 1 del proyecto personal del usuario 1', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 6, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (42, 'Tarea 2 Proyecto Personal Usuario 1', 'Descripción de la tarea 2 del proyecto personal del usuario 1', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 6, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 2
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (43, 'Tarea 1 Proyecto Personal Usuario 2', 'Descripción de la tarea 1 del proyecto personal del usuario 2', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 7, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (44, 'Tarea 2 Proyecto Personal Usuario 2', 'Descripción de la tarea 2 del proyecto personal del usuario 2', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 7, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 3
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (45, 'Tarea 1 Proyecto Personal Usuario 3', 'Descripción de la tarea 1 del proyecto personal del usuario 3', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 8, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (46, 'Tarea 2 Proyecto Personal Usuario 3', 'Descripción de la tarea 2 del proyecto personal del usuario 3', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 8, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 4
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (47, 'Tarea 1 Proyecto Personal Usuario 4', 'Descripción de la tarea 1 del proyecto personal del usuario 4', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 9, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (48, 'Tarea 2 Proyecto Personal Usuario 4', 'Descripción de la tarea 2 del proyecto personal del usuario 4', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 9, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 5
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (49, 'Tarea 1 Proyecto Personal Usuario 5', 'Descripción de la tarea 1 del proyecto personal del usuario 5', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 10, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (50, 'Tarea 2 Proyecto Personal Usuario 5', 'Descripción de la tarea 2 del proyecto personal del usuario 5', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 10, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 6
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (51, 'Tarea 1 Proyecto Personal Usuario 6', 'Descripción de la tarea 1 del proyecto personal del usuario 6', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 11, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (52, 'Tarea 2 Proyecto Personal Usuario 6', 'Descripción de la tarea 2 del proyecto personal del usuario 6', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 11, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 7
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (53, 'Tarea 1 Proyecto Personal Usuario 7', 'Descripción de la tarea 1 del proyecto personal del usuario 7', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 12, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (54, 'Tarea 2 Proyecto Personal Usuario 7', 'Descripción de la tarea 2 del proyecto personal del usuario 7', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 12, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 8
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (55, 'Tarea 1 Proyecto Personal Usuario 8', 'Descripción de la tarea 1 del proyecto personal del usuario 8', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 13, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (56, 'Tarea 2 Proyecto Personal Usuario 8', 'Descripción de la tarea 2 del proyecto personal del usuario 8', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 13, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 9
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (57, 'Tarea 1 Proyecto Personal Usuario 9', 'Descripción de la tarea 1 del proyecto personal del usuario 9', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 14, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (58, 'Tarea 2 Proyecto Personal Usuario 9', 'Descripción de la tarea 2 del proyecto personal del usuario 9', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 14, 1, 'EN_PROGRESO'); 

-- -- Tasks for Proyecto Personal Usuario 10
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (59, 'Tarea 1 Proyecto Personal Usuario 10', 'Descripción de la tarea 1 del proyecto personal del usuario 10', '2024-01-01', '2024-01-03', NOW(), NOW(), 3, 15, 1, 'COMPLETADA'); 
INSERT INTO tareas (id, nombre, descripcion, fecha_inicio, fecha_final, fecha_creacion, fecha_actualizacion, horas_estimadas, proyecto_id, tipo_tarea_id, estado_tarea) VALUES (60, 'Tarea 2 Proyecto Personal Usuario 10', 'Descripción de la tarea 2 del proyecto personal del usuario 10', '2024-01-04', '2024-01-06', NOW(), NOW(), 4, 15, 1, 'EN_PROGRESO'); 
