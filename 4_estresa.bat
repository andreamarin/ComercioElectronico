echo off
echo ejecuta el estresador para sembrar los clientes
echo uso:
echo 4_estresa NumCltes NumSolicitudesPorClte HOSTNAME (en caso de omitirlo se usa localhost, si se omiten los clientes usa 15 y el localhost)
echo on

set cb=%cd%\tstRMI.jar

if [%1] NEQ [] goto conclientes
estresador 20 -Djava.rmi.server.codebase=file:///C:/Users/sdist/Desktop/pruebaSimpleRMI/example/hello/ example.hello.Client localhost 200
goto fin

:conclientes

if [%2] NEQ [] goto consolicitudes
estresador %1 -Djava.rmi.server.codebase=file:///C:/Users/sdist/Desktop/pruebaSimpleRMI/example/hello/ example.hello.Client localhost 200
goto fin

:consolicitudes
if [%3] NEQ [] goto conHost
estresador %1 -Djava.rmi.server.codebase=file:///C:/Users/sdist/Desktop/pruebaSimpleRMI/example/hello/ example.hello.Client localhost %2
goto fin

:conHost
estresador %1 -Djava.rmi.server.codebase=file:///C:/Users/sdist/Desktop/pruebaSimpleRMI/example/hello/ example.hello.Client %3 %2


:fin

