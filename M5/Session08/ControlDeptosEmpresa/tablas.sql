CREATE TABLE empleado(
numempleado NUMBER GENERATED BY default AS IDENTITY,
nombre varchar(50) NOT NULL,
numdepto NUMBER
);

CREATE TABLE departamento(
numdepto NUMBER GENERATED BY default AS IDENTITY,
nomdepto varchar(50) NOT NULL,
ubicaciondpto varchar(50)
);