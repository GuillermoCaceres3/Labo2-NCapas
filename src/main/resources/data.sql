-- =========================================================
-- EXTENSION PARA GENERAR UUID EN POSTGRESQL
-- =========================================================

CREATE EXTENSION IF NOT EXISTS pgcrypto;


-- =========================================================
-- 1. DEPARTAMENTOS
-- =========================================================

INSERT INTO departamento (nombre)
VALUES
('San Salvador'),
('La Libertad'),
('San Miguel'),
('Santa Ana');


-- =========================================================
-- 2. MUNICIPIOS
-- =========================================================

INSERT INTO municipio (nombre, id_departamento)
VALUES
(
    'San Salvador Centro',
    (SELECT id_departamento FROM departamento WHERE nombre = 'San Salvador')
),
(
    'Soyapango',
    (SELECT id_departamento FROM departamento WHERE nombre = 'San Salvador')
),
(
    'Santa Tecla',
    (SELECT id_departamento FROM departamento WHERE nombre = 'La Libertad')
),
(
    'Antiguo Cuscatlán',
    (SELECT id_departamento FROM departamento WHERE nombre = 'La Libertad')
);


-- =========================================================
-- 3. DIRECCIONES
-- =========================================================

INSERT INTO direccion (calle, colonia, id_departamento, id_municipio)
VALUES
(
    'Calle Arce',
    'Colonia Centro',
    (SELECT id_departamento FROM departamento WHERE nombre = 'San Salvador'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'San Salvador Centro')
),
(
    'Boulevard del Ejército',
    'Colonia Las Margaritas',
    (SELECT id_departamento FROM departamento WHERE nombre = 'San Salvador'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'Soyapango')
),
(
    'Avenida San Martín',
    'Colonia Quezaltepec',
    (SELECT id_departamento FROM departamento WHERE nombre = 'La Libertad'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'Santa Tecla')
),
(
    'Calle El Espino',
    'Colonia Jardines de Guadalupe',
    (SELECT id_departamento FROM departamento WHERE nombre = 'La Libertad'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'Antiguo Cuscatlán')
),
(
    '25 Avenida Norte',
    'Colonia Médica',
    (SELECT id_departamento FROM departamento WHERE nombre = 'San Salvador'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'San Salvador Centro')
),
(
    '7a Calle Poniente',
    'Colonia Utila',
    (SELECT id_departamento FROM departamento WHERE nombre = 'La Libertad'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'Santa Tecla')
),
(
    'Alameda Juan Pablo II',
    'Colonia Escalón',
    (SELECT id_departamento FROM departamento WHERE nombre = 'San Salvador'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'San Salvador Centro')
),
(
    'Boulevard Merliot',
    'Colonia Santa Elena',
    (SELECT id_departamento FROM departamento WHERE nombre = 'La Libertad'),
    (SELECT id_municipio FROM municipio WHERE nombre = 'Antiguo Cuscatlán')
);


-- =========================================================
-- 4. PERSONAS
-- id es UUID, por eso usamos gen_random_uuid()
-- =========================================================

INSERT INTO persona (id, nombre, dui, telefono, id_direccion)
VALUES
(
    gen_random_uuid(),
    'Juan Carlos Pérez',
    '01234567-8',
    '77771111',
    (SELECT id_direccion FROM direccion WHERE calle = 'Calle Arce' AND colonia = 'Colonia Centro')
),
(
    gen_random_uuid(),
    'María Fernanda López',
    '12345678-9',
    '77772222',
    (SELECT id_direccion FROM direccion WHERE calle = 'Boulevard del Ejército' AND colonia = 'Colonia Las Margaritas')
),
(
    gen_random_uuid(),
    'Carlos Ernesto Ramírez',
    '23456789-0',
    '77773333',
    (SELECT id_direccion FROM direccion WHERE calle = 'Avenida San Martín' AND colonia = 'Colonia Quezaltepec')
),
(
    gen_random_uuid(),
    'Ana Sofía Martínez',
    '34567890-1',
    '77774444',
    (SELECT id_direccion FROM direccion WHERE calle = 'Calle El Espino' AND colonia = 'Colonia Jardines de Guadalupe')
),
(
    gen_random_uuid(),
    'Luis Alberto Hernández',
    '45678901-2',
    '77775555',
    (SELECT id_direccion FROM direccion WHERE calle = '25 Avenida Norte' AND colonia = 'Colonia Médica')
),
(
    gen_random_uuid(),
    'Sofía Gabriela Torres',
    '56789012-3',
    '77776666',
    (SELECT id_direccion FROM direccion WHERE calle = '7a Calle Poniente' AND colonia = 'Colonia Utila')
),
(
    gen_random_uuid(),
    'Roberto Antonio Mejía',
    '67890123-4',
    '77777777',
    (SELECT id_direccion FROM direccion WHERE calle = 'Alameda Juan Pablo II' AND colonia = 'Colonia Escalón')
),
(
    gen_random_uuid(),
    'Karla Beatriz Aguilar',
    '78901234-5',
    '77778888',
    (SELECT id_direccion FROM direccion WHERE calle = 'Boulevard Merliot' AND colonia = 'Colonia Santa Elena')
);


-- =========================================================
-- 5. ESTACIONES POLICIALES
-- director_id referencia a persona.id
-- =========================================================

INSERT INTO estacion_policial (nombre_estacion, id_direccion, director_id)
VALUES
(
    'Delegación Centro Histórico',
    (SELECT id_direccion FROM direccion WHERE calle = 'Alameda Juan Pablo II' AND colonia = 'Colonia Escalón'),
    (SELECT id FROM persona WHERE dui = '01234567-8')
),
(
    'Delegación Santa Tecla',
    (SELECT id_direccion FROM direccion WHERE calle = 'Boulevard Merliot' AND colonia = 'Colonia Santa Elena'),
    (SELECT id FROM persona WHERE dui = '12345678-9')
);


-- =========================================================
-- 6. POLICIAS
-- id_persona referencia a persona.id
-- =========================================================

INSERT INTO policia (codigo, placa, id_persona, id_estacion_policial)
VALUES
(
    'POL-001',
    'PNC-1001',
    (SELECT id FROM persona WHERE dui = '01234567-8'),
    (SELECT estacion_policial_id FROM estacion_policial WHERE nombre_estacion = 'Delegación Centro Histórico')
),
(
    'POL-002',
    'PNC-1002',
    (SELECT id FROM persona WHERE dui = '12345678-9'),
    (SELECT estacion_policial_id FROM estacion_policial WHERE nombre_estacion = 'Delegación Centro Histórico')
),
(
    'POL-003',
    'PNC-1003',
    (SELECT id FROM persona WHERE dui = '23456789-0'),
    (SELECT estacion_policial_id FROM estacion_policial WHERE nombre_estacion = 'Delegación Santa Tecla')
),
(
    'POL-004',
    'PNC-1004',
    (SELECT id FROM persona WHERE dui = '34567890-1'),
    (SELECT estacion_policial_id FROM estacion_policial WHERE nombre_estacion = 'Delegación Santa Tecla')
);


-- =========================================================
-- 7. CARGOS
-- tipo_cargo:
-- 1 = Procesal
-- 2 = Penal
-- =========================================================

INSERT INTO cargos (fecha, descripcion, id_acusador, id_acusado, tipo_cargo)
VALUES
(
    '2026-05-01',
    'Denuncia por alteración del orden público.',
    (SELECT id FROM persona WHERE dui = '01234567-8'),
    (SELECT id FROM persona WHERE dui = '45678901-2'),
    1
),
(
    '2026-05-02',
    'Acusación por hurto en establecimiento comercial.',
    (SELECT id FROM persona WHERE dui = '12345678-9'),
    (SELECT id FROM persona WHERE dui = '45678901-2'),
    2
),
(
    '2026-05-03',
    'Denuncia por daños a propiedad privada.',
    (SELECT id FROM persona WHERE dui = '23456789-0'),
    (SELECT id FROM persona WHERE dui = '56789012-3'),
    2
),
(
    '2026-05-04',
    'Proceso abierto por incumplimiento de citación.',
    (SELECT id FROM persona WHERE dui = '34567890-1'),
    (SELECT id FROM persona WHERE dui = '56789012-3'),
    1
),
(
    '2026-05-05',
    'Acusación por lesiones leves.',
    (SELECT id FROM persona WHERE dui = '01234567-8'),
    (SELECT id FROM persona WHERE dui = '67890123-4'),
    2
),
(
    '2026-05-06',
    'Denuncia por amenazas verbales.',
    (SELECT id FROM persona WHERE dui = '12345678-9'),
    (SELECT id FROM persona WHERE dui = '67890123-4'),
    1
),
(
    '2026-05-07',
    'Acusación por apropiación indebida.',
    (SELECT id FROM persona WHERE dui = '23456789-0'),
    (SELECT id FROM persona WHERE dui = '45678901-2'),
    2
),
(
    '2026-05-08',
    'Proceso por resistencia a la autoridad.',
    (SELECT id FROM persona WHERE dui = '34567890-1'),
    (SELECT id FROM persona WHERE dui = '78901234-5'),
    1
);
