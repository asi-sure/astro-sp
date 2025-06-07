--21 de abril 2024

-- public.city definition

-- Drop table

-- DROP TABLE city;

CREATE TABLE city (
                      id int4 NOT NULL,
                      "name" varchar(30) NOT NULL,
                      description varchar(150) NULL,
                      status bool DEFAULT true NULL,
                      CONSTRAINT city_pkey PRIMARY KEY (id)
);


-- public.menu definition

-- Drop table

-- DROP TABLE menu;

CREATE TABLE menu (
                      id serial4 NOT NULL,
                      description varchar(150) NULL,
                      "name" varchar(50) NOT NULL,
                      status bool DEFAULT true NULL,
                      CONSTRAINT menu_pkey PRIMARY KEY (id)
);


-- public."permission" definition

-- Drop table

-- DROP TABLE "permission";

CREATE TABLE "permission" (
                              id serial4 NOT NULL,
                              description varchar(150) NULL,
                              "name" varchar(50) NOT NULL,
                              status bool DEFAULT true NULL,
                              CONSTRAINT permission_pkey PRIMARY KEY (id)
);


-- public.rol definition

-- Drop table

-- DROP TABLE rol;

CREATE TABLE rol (
                     id serial4 NOT NULL,
                     description varchar(150) NULL,
                     "name" varchar(50) NOT NULL,
                     status bool DEFAULT true NULL,
                     CONSTRAINT rol_pkey PRIMARY KEY (id)
);


-- public.student definition

-- Drop table

-- DROP TABLE student;

CREATE TABLE student (
                         id int4 NOT NULL,
                         photo varchar(1024) NOT NULL,
                         description varchar(150) NULL,
                         status bool DEFAULT true NOT NULL,
                         CONSTRAINT student_pkey PRIMARY KEY (id)
);


-- public.departament definition

-- Drop table

-- DROP TABLE departament;

CREATE TABLE departament (
                             id int4 NOT NULL,
                             "name" varchar(100) NOT NULL,
                             description varchar(150) NOT NULL,
                             status bool DEFAULT true NOT NULL,
                             id_city int4 NOT NULL,
                             CONSTRAINT departament_pkey PRIMARY KEY (id),
                             CONSTRAINT id_city FOREIGN KEY (id_city) REFERENCES city(id)
);


-- public.permision_menu definition

-- Drop table

-- DROP TABLE permision_menu;

CREATE TABLE permision_menu (
                                menu_id int4 NOT NULL,
                                permission_id int4 NOT NULL,
                                CONSTRAINT permision_menu_pkey PRIMARY KEY (permission_id, menu_id),
                                CONSTRAINT permision_menu_menu_id_fkey FOREIGN KEY (menu_id) REFERENCES menu(id),
                                CONSTRAINT permision_menu_permission_id_fkey FOREIGN KEY (permission_id) REFERENCES "permission"(id)
);


-- public.region definition

-- Drop table

-- DROP TABLE region;

CREATE TABLE region (
                        id int4 NOT NULL,
                        "name" varchar(30) NOT NULL,
                        description varchar(150) NULL,
                        status bool DEFAULT true NULL,
                        id_departament int8 NOT NULL,
                        CONSTRAINT region_pkey PRIMARY KEY (id),
                        CONSTRAINT id_departament FOREIGN KEY (id_departament) REFERENCES departament(id)
);


-- public.rol_permission definition

-- Drop table

-- DROP TABLE rol_permission;

CREATE TABLE rol_permission (
                                rol_id int4 NOT NULL,
                                permission_id int4 NOT NULL,
                                CONSTRAINT rol_permission_pkey PRIMARY KEY (rol_id, permission_id),
                                CONSTRAINT rol_permission_permission_id_fkey FOREIGN KEY (permission_id) REFERENCES "permission"(id),
                                CONSTRAINT rol_permission_rol_id_fkey FOREIGN KEY (rol_id) REFERENCES rol(id)
);


-- public.systems_user definition

-- Drop table

-- DROP TABLE systems_user;

CREATE TABLE systems_user (
                              id int8 NOT NULL,
                              alias varchar(50) NULL,
                              email varchar(100) NOT NULL,
                              username varchar(100) NOT NULL,
                              "password" varchar(1024) NOT NULL,
                              cell varchar(12) NOT NULL,
                              code_cell varchar(12) NULL,
                              status bool DEFAULT true NOT NULL,
                              date_start_verification timestamp NULL,
                              date_end_verification timestamp NULL,
                              id_city int8 NOT NULL,
                              is_enabled bool DEFAULT true NOT NULL,
                              account_no_expired bool DEFAULT true NOT NULL,
                              account_no_locked bool DEFAULT true NOT NULL,
                              credential_no_exipred bool DEFAULT true NOT NULL,
                              CONSTRAINT systems_user_pkey PRIMARY KEY (id),
                              CONSTRAINT username_unique UNIQUE (username),
                              CONSTRAINT id_city FOREIGN KEY (id_city) REFERENCES city(id)
);


-- public.user_rol definition

-- Drop table

-- DROP TABLE user_rol;

CREATE TABLE user_rol (
                          rol_id int4 NOT NULL,
                          system_user_id int8 NOT NULL,
                          CONSTRAINT user_rol_pkey PRIMARY KEY (rol_id, system_user_id),
                          CONSTRAINT user_rol_rol_id_fkey FOREIGN KEY (rol_id) REFERENCES rol(id),
                          CONSTRAINT user_rol_system_user_id_fkey FOREIGN KEY (system_user_id) REFERENCES systems_user(id)
);


-- public.person definition

-- Drop table

-- DROP TABLE person;

CREATE TABLE person (
                        id int8 NOT NULL,
                        ci varchar(25) NOT NULL,
                        first_lastename varchar(100) NOT NULL,
                        gender varchar(1) NOT NULL,
                        "name" varchar(100) NOT NULL,
                        second_lastname varchar(100) NULL,
                        status bool DEFAULT true NOT NULL,
                        id_system_user int8 NOT NULL,
                        id_student int4 NOT NULL,
                        CONSTRAINT person_id_student_key UNIQUE (id_student),
                        CONSTRAINT person_id_system_user_key UNIQUE (id_system_user),
                        CONSTRAINT person_pkey PRIMARY KEY (id),
                        CONSTRAINT id_student FOREIGN KEY (id_student) REFERENCES student(id),
                        CONSTRAINT person_system_user_fk FOREIGN KEY (id_system_user) REFERENCES systems_user(id)
);


-- public.team definition

-- Drop table

-- DROP TABLE team;

CREATE TABLE team (
                      id int4 NOT NULL,
                      alias varchar(30) NOT NULL,
                      description varchar(150) NULL,
                      status bool DEFAULT true NULL,
                      id_region int8 NOT NULL,
                      id_person int8 NOT NULL,
                      CONSTRAINT team_pkey PRIMARY KEY (id),
                      CONSTRAINT id_person FOREIGN KEY (id_person) REFERENCES person(id),
                      CONSTRAINT id_region FOREIGN KEY (id_region) REFERENCES region(id)
);

ALTER TABLE systems_user
    ALTER COLUMN date_start_verification DROP NOT NULL,
ALTER COLUMN date_end_verification DROP NOT NULL,
ALTER COLUMN code_cell DROP NOT NULL;

-- 20 de mayo modificando id de system_user autoincremental

ALTER TABLE systems_user ALTER COLUMN id DROP DEFAULT;
DROP SEQUENCE IF EXISTS systems_user_id_seq;
CREATE SEQUENCE systems_user_id_seq;
ALTER TABLE systems_user ALTER COLUMN id SET DEFAULT nextval('systems_user_id_seq');

ALTER TABLE systems_user ALTER COLUMN id SET NOT NULL;
ALTER SEQUENCE systems_user_id_seq OWNED BY systems_user.id;
-- autoincremental id rol
ALTER TABLE rol ALTER COLUMN id DROP DEFAULT;
DROP SEQUENCE IF EXISTS rol_id_seq;
CREATE SEQUENCE rol_id_seq;
ALTER TABLE rol ALTER COLUMN id SET DEFAULT nextval('rol_id_seq');

ALTER TABLE rol ALTER COLUMN id SET NOT NULL;
ALTER SEQUENCE rol_id_seq OWNED BY rol.id;

--autoincremental id permisos
ALTER TABLE permission  ALTER COLUMN id DROP DEFAULT;
DROP SEQUENCE IF EXISTS permission_id_seq;
CREATE SEQUENCE permission_id_seq;
ALTER TABLE permission ALTER COLUMN id SET DEFAULT nextval('permission_id_seq');

ALTER TABLE permission  ALTER COLUMN id SET NOT NULL;
ALTER SEQUENCE rol_id_seq OWNED BY permission.id;

-- eliminacion de la relacion team person
ALTER TABLE team DROP CONSTRAINT id_person;

ALTER TABLE team DROP COLUMN id_person;