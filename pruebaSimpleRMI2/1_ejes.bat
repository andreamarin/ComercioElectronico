rem -Djava.rmi.server.useCodebaseOnly=false
rem java -Djava.rmi.server.codebase=file:%cb% example.hello.Server 
rem java -Djava.rmi.server.codebase=file:%cb% example.hello.Server

echo off
echo inicia el servidor
echo uso:
echo 1_ejes HOSTNAME (en caso de omitirlo se usa localhost)
echo on

set cb=%cd%\example/hello

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:%cb% example.hello.Server  
goto fin

:conHost
java -Djava.rmi.server.codebase=file:%cb% example.hello.Server  %1

:fin
