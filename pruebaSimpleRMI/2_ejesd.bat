echo off
echo inicializa el servidor de disparo
echo uso:
echo 2_ejesd HOSTNAME (en caso de omitirlo se usa localhost)
echo on

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:///C:/ComercioElectronico/pruebaSimpleRMI/example/hello example.hello.ServidorDeDisparo 
goto fin

:conHost
java -Djava.rmi.server.codebase=file:///C:/ComercioElectronico/pruebaSimpleRMI/example/hello example.hello.ServidorDeDisparo %1

:fin
