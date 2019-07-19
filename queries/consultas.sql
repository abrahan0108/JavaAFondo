SELECT * FROM COURSES;

SELECT * FROM EMP;
SELECT * from DEPT;

SELECT E.EMPNO AS Número_Empleado, E.ENAME AS Nombre_Empleado, E.DEPTNO AS Número_Departamento, D.DNAME AS Nombre_Departamento, D.LOC AS Localización_Departamento FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;
SELECT EMP.EMPNO AS Número_Empleado, EMP.ENAME AS Nombre_Empleado, EMP.DEPTNO AS Número_Departamento, DEPT.DNAME AS Nombre_Departamento, DEPT.LOC AS Localización_Departamento FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;