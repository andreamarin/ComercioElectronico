echo off
echo inicializa el servidor de disparo
echo uso:
echo 2_ejesd HOSTNAME (en caso de omitirlo se usa localhost)
echo on

set cb=%cd%\example/hello

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:%cb% example.hello.ServidorDeDisparo 
goto fin

:conHost
java -Djava.rmi.server.codebase=file:%cb% example.hello.ServidorDeDisparo %1

:fin
