# MediGestión - Sistema Integral de Gestión Médica

MediGestión es una aplicación de escritorio desarrollada en Java (Swing) diseñada para administrar de forma eficiente los procesos de una clínica o centro médico. El sistema implementa una arquitectura basada en el patrón DAO (Data Access Object) para garantizar un código limpio, escalable y mantenible.

## Características Principales

* **Autenticación y Seguridad:** Sistema de inicio de sesión con encriptación de contraseñas (BCrypt) y control de acceso basado en roles (Administrador, Médico, Recepcionista, Farmacéutico).
* **Gestión de Citas Médicas:** Agendamiento de citas integrando componentes de fecha y hora, con control de estados (Pendiente, Atendida, Cancelada) e historial por paciente.
* **Módulo de Facturación Transaccional:** Sistema maestro-detalle con control de transacciones SQL (`commit`/`rollback`). Permite agregar productos al carrito, calcular subtotales y descontar automáticamente el stock del inventario.
* **Inventario de Farmacia:** Control de medicamentos y categorías, incluyendo alertas de stock mínimo y fechas de vencimiento.
* **Administración de Personal y Pacientes:** CRUD completo para gestionar el registro de médicos (con sus especialidades) y pacientes (historial, tipo de sangre, datos de contacto).

## Tecnologías y Arquitectura

* **Lenguaje:** Java 8+
* **Interfaz Gráfica:** Java Swing (Diseño con NetBeans IDE)
* **Base de Datos:** MySQL
* **Conexión:** JDBC puro
* **Patrón de Diseño:** DAO (Data Access Object) y Modelo-Vista-Controlador (MVC adaptado).
* **Gestor de Dependencias:** Maven (`pom.xml`)

## Estructura del Proyecto

El código fuente está organizado modularmente siguiendo buenas prácticas de separación de responsabilidades:

    src/main/java/com/mycompany/medigestion/
    ├── conexion/    # Lógica de conexión a MySQL mediante Properties
    ├── dao/         # Data Access Objects (Operaciones CRUD y Transacciones)
    ├── modelo/      # Modelos de datos (POJOs)
    ├── util/        # Clases utilitarias (Manejo de Sesión Global)
    └── ventana/     # Interfaces gráficas (JFrames)


## Estructura de la Base de Datos
El sistema está respaldado por una base de datos relacional robusta conformada por 10 tablas principales, diseñadas para mantener la integridad referencial:

    
    usuario, paciente, medico, cita_medica, inventario, fac_dato, fac_detalle, especialidad, sangre, categoria_prod.


## Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalado:
- Java Development Kit (JDK) 8 o superior.
- MySQL Server (Versión 8.0 recomendada).
- Apache Maven.
- NetBeans IDE (Opcional, pero recomendado para editar las interfaces gráficas).


## Instalación y Uso

Clonar el repositorio:

    git clone [https://github.com/gaboToro/MediGestion.git](https://github.com/gaboToro/MediGestion.git)
  


## Configurar la Base de Datos:

Inicia tu servidor MySQL.
Ejecuta el script SQL ubicado en la carpeta del proyecto (database/medigestion_db) para crear la base de datos medigestion_db y todas sus tablas.

## Configurar Credenciales de Seguridad:
Para proteger tus credenciales locales, el proyecto utiliza un archivo de propiedades.
En la carpeta raíz del proyecto (al mismo nivel que pom.xml), crea un archivo llamado db.properties.

Añade tu configuración local:

    db.url=jdbc:mysql://localhost:3306/medigestion_db
    db.user=tu_usuario_mysql
    db.password=tu_contraseña_mysql

## Compilar y Ejecutar:

Abre el proyecto en NetBeans o tu IDE preferido.
Deja que Maven descargue las dependencias (BCrypt, JCalendar, etc.).
Ejecuta el archivo principal: LoginVentana.java.