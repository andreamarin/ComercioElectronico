set cb=%cd%\example\hello\ 

if [%1] NEQ [] goto connumclientes
estresador 5 -Djava.rmi.server.codebase=file:%cb% example.hello.Client
goto fin

:connumclientes
estresador %1 -Djava.rmi.server.codebase=file:%cb% example.hello.Client

:fin
