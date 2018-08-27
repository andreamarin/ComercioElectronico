set cb=%cd%\example/hello

if [%1] NEQ [] goto conHost
java -Djava.rmi.server.codebase=file:///%cb% example.hello.Master localhost reporta
goto fin

:conHost
java -Djava.rmi.server.codebase=file:///%cb% example.hello.Master %1 reporta
:fin


