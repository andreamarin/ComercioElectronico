echo off
echo ejecuta el estresador para sembrar los clientes
echo uso:
echo 4_estresa NumCltes NumSolicitudesPorClte HOSTNAME (en caso de omitirlo se usa localhost, si se omiten los clientes usa 15 y el localhost)
echo on

set cb=%cd%\example/hello

if [%1] NEQ [] goto conclientes
estresador 10 -Djava.rmi.server.codebase=file:%cb% example.hello.Client localhost
goto fin

:conclientes
if [%2] NEQ [] goto conHost
estresador %1 -Djava.rmi.server.codebase=file:%cb% example.hello.Client localhost
goto fin

:conHost
estresador %1 -Djava.rmi.server.codebase=file:%cb% example.hello.Client %2

:fin

